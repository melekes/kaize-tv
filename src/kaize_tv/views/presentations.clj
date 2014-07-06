(ns kaize-tv.views.presentations
  (:use [hiccup.core :only (h)])
  (:require [kaize-tv.views.layout :as layout]))

(defn- presentations-list [presentations]
  [:div {:class "presentations"}
   (map
    (fn [p] [:article
             [:h1 [:a {:href (:url p)} (h (:name p))]]
             [:p [:small (str "by " (h (:author p)) " at " (h (:presented_at p)) " (" (h (:presented_on p)) ")")]]
             [:p (h (:description p))]
             [:p [:a {:class "btn watch-btn" :href (:url p)} "Watch"]]])
    presentations)])

(defn index [presentations]
  (layout/common "Kaize TV"
                 (presentations-list presentations)))

(defn show [presentation]
  (layout/common (str "Kaize TV | " (h (:name presentation)))
                 [:div {:class "presentation"}
                  [:article {:class "player"}]
                  [:aside
                   [:h3 (h (:name presentation))]
                   [:p [:small (str "by " (h (:author presentation)) " at " (h (:presented_at presentation)) " (" (h (:presented_on presentation)) ")")]]
                   [:p (h (:description presentation))]]]))
