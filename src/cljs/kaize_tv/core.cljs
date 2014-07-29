(ns kaize-tv.core
  (:require-macros [cljs.core.async.macros :refer [go alt!]])
  (:require [goog.events :as events]
            [cljs.core.async :refer [put! <! >! chan timeout]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs-http.client :as http]))

(enable-console-print!)

(defn fetch-presentations
  [url]
  (let [c (chan)]
    (go (let [{presentations :body} (<! (http/get url))]
          (>! c (vec presentations))))
    c))

(defn presentation [{:keys [name]} owner opts]
  (om/component
   (dom/li nil name)))

(defn presentation-list [{:keys [presentations]}]
  (om/component
   (apply dom/ul nil
          (om/build-all presentation presentations))))

(defn presentation-box [app owner opts]
  (reify
    om/IInitState
    (init-state [_]
                (om/transact! app [:presentations] (fn [] [])))
    om/IWillMount
    (will-mount [_]
                (go (while true
                      (let [presentations (<! (fetch-presentations (:url opts)))]
                        (.log js/console (pr-str presentations))
                        (om/update! app #(assoc % :presentations presentations)))
                      (<! (timeout (:poll-interval opts))))))
    om/IRender
    (render [_]
            (dom/h1 nil "Presentations")
            (om/build presentation-list app))))

(defn om-app [app owner]
  (om/component
    (dom/div nil
             (om/build presentation-box app
                       {:opts {:url "/api/presentations"
                               :poll-interval 2000}}))))

(def app-state
  (atom {}))

(om/root app-state om-app
         {:target (. js/document (getElementById "content"))})
