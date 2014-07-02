(ns kaize-tv.views.presentations
  (:use [hiccup.core :only (h)])
  (:require [kaize-tv.views.layout :as layout]))

(defn- presentations-list [presentations]
  [:div {:class "presentations-list"}
   (map
    (fn [p] [:h2 {:class "presentation"} (h (:body p))])
    presentations)])

(defn index [presentations]
  (layout/common "List"
                 (presentations-list presentations)))

