(ns kaize-tv.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.json :as middleware]))

(defroutes app-routes
  (GET  "/" [] (resource-response "index.html" {:root "public"}))
  (GET  "/api/presentations" [] (response [{:name "# 1"} {:name "# 3"}]))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-response)))
