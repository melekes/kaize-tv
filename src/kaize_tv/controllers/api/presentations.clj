(ns kaize-tv.controllers.presentations
  (:use [compojure.core :only (defroutes GET)]
        [cheshire.core :as cheshire]))

(defn- find-files [dir]
  (fs/find-files dir #".+\.json"))

(defn index []
  (let [files (find-files "presentations")
        contents (map #(cheshire/parse-string (slurp %)) files)]))
