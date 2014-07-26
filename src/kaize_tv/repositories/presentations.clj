(ns kaize-tv/repositories
  (require '[clojure.data.json :as json]))

(def ^:private presentations-dir "presentations")

(defn all
  (let [directory (clojure.java.io/file presentations-dir)
        files (file-seq directory)]
    ))
