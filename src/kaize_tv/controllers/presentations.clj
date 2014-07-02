(ns kaize-tv.controllers.presentations
  (:use [compojure.core :only (defroutes GET)])
  (:require [kaize-tv.views.presentations :as view]
            [kaize-tv.models.presentation :as model]))

(defn index []
  (view/index (model/all)))

(defroutes routes
  (GET  "/" [] (index)))
