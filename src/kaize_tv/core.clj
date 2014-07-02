(ns kaize-tv.core
  (:use [compojure.core :only (defroutes)]
        [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [kaize-tv.controllers.presentations :as presentations]
            [kaize-tv.views.layout :as layout]
            [kaize-tv.migrations.presentations :as schema])
  (:gen-class))

(defroutes routes
  presentations/routes
  (route/resources "/")
  (route/not-found (layout/not-found)))

(def application (handler/site routes))

(defn start [port]
  (run-jetty application {:port port
                          :join? false}))

(defn -main []
  (schema/migrate)
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (start port)))
