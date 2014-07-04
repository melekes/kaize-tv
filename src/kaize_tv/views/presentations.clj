(ns kaize-tv.views.presentations
  (:use [hiccup.core :only (h)])
  (:require [kaize-tv.views.layout :as layout]))

(defn- presentations-list [presentations]
  [:div {:class "articles-list"}
   (map
    (fn [p] [:h1 {:class "article"} (h (:name p))])
    presentations)])

(defn index [presentations]
  (layout/common "List"
                 (presentations-list presentations)))

