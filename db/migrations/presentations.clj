(ns db.migrations.presentations
  (:require [clojure.java.jdbc :as sql]
            [kaize-tv.models.presentation :as presentation]))

(defn migrated? []
  (-> (sql/query presentation/spec
                 [(str "select count(*) from information_schema.tables "
                       "where table_name='presentations'")])
      first :count pos?))

(defn migrate []
   (when (not (migrated?))
    (print "Creating presentations table...") (flush)
    (sql/db-do-commands presentation/spec
                        (sql/create-table-ddl
                        :presentations
                        [:id :serial "PRIMARY KEY"]
                        [:name :varchar "NOT NULL"]
                        [:description :varchar "NOT NULL"]
                        [:author :varchar "NOT NULL"]
                        [:presented_on :date "NOT NULL"]
                        [:presented_at :varchar "NOT NULL"]
                        [:url :varchar]
                        [:path :varchar]
                        [:updated_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]
                        [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]))
    (println " done")))
