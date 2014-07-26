(ns kaize-tv.models.presentation)

; FIXME I think this should not be here
(def spec (System/getenv "DATABASE_URL"))

(defn all []
  (into [] (sql/query spec ["select * from presentations order by id desc"])))

(defn find_by_id [id]
  (into {} (sql/query spec ["select * from presentations where id = ?", (Integer/parseInt id)])))
