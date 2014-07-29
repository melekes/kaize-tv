(ns kaize-tv.core
  (:require [compojure.core :refer [GET defroutes context]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.json :as middleware]
            [cheshire.core :as cheshire]
            [me.raynes.fs :as fs]))

(defn- find-files []
  "List files under presentations directory"
  (fs/find-files "presentations" #".*\.json"))

(defn get-presentations [n]
  "List presentations"
  (let [files (take n (find-files))]
    (response (map #(cheshire/parse-string (slurp %)) files))))

(defroutes app-routes
  (GET  "/" [] (resource-response "index.html" {:root "public"}))
  (context "/api/presentations" [] (defroutes presentations-routes
                                     (GET "/" [] (get-presentations 10))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-response)))
