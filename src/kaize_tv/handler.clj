(ns kaize-tv.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [kaize-tv.controllers.presentations :as presentations_controller]
            [kaize-tv.views.layout :as layout]
            [kaize-tv.migrations.presentations :as presentations_schema]))

(defroutes app-routes
  (route/resources "/")
  (route/not-found (layout/not-found)))

(defn init []
  (println "kaize-tv is starting")
  (presentations_schema/migrate))

(def app
  (-> (routes presentations_controller/routes app-routes)
      (handler/site)))

