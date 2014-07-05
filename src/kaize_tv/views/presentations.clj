(ns kaize-tv.views.presentations
  (:use [hiccup.core :only (h)])
  (:require [kaize-tv.views.layout :as layout]))

(defn- presentations-list [presentations]
  [:div {:class "articles-list"}
   (map
    (fn [p] [:article
             [:h1 (h (:name p))]
             [:p [:small (str "by " (h (:author p)) " at " (h (:presented_at p)) " (" (h (:presented_on p)) ")")]]
             [:p (h (:description p))]])
    presentations)])

(defn index [presentations]
  (layout/common "List"
                 (presentations-list presentations)))

