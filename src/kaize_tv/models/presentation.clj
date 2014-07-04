(ns kaize-tv.models.presentation
  (:require [clojure.java.jdbc :as sql]))

; FIXME I think this should not be here
(def spec (System/getenv "DATABASE_URL"))

(defn all []
  (into [] (sql/query spec ["select * from presentations order by id desc"])))

