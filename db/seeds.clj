(ns db.seeds
  (:require [clojure.java.jdbc :as sql]
   [kaize-tv.models.presentation :as presentation]))

(defn run []
  (print "Running seeds...") (flush)
  (sql/insert! presentation/spec
               :presentations
               {:name "The Better Parts" :description "This talk is about using programming languages more effectively, and using that experience to create and select better programming languages. There are bad practices in software development that are so old and well established that it is difficult to recognize the problems they cause." :author "Douglas Crockford"})
  (println " done"))
