(ns kaize-tv.controllers.presentations
  (:use [compojure.core :only (defroutes GET)])
  (:require [kaize-tv.views.presentations :as view]
            [kaize-tv.models.presentation :as model]))

(defn index []
  (view/index (model/all)))

(defn show [id]
  (view/show (model/find_by_id id)))

(defroutes routes
  (GET  "/" [] (index))
  (GET  ["/:id" :id #"[0-9]+"] [id] (show id)))
