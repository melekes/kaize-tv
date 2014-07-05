(ns db.seeds
  (:require [clojure.java.jdbc :as sql]
   [kaize-tv.models.presentation :as presentation]))

(defn run []
  (print "Running seeds...") (flush)
  (sql/insert! presentation/spec
               :presentations
               {:name "The Better Parts"
                :description "This talk is about using programming languages more effectively, and using that experience to create and select better programming languages. There are bad practices in software development that are so old and well established that it is difficult to recognize the problems they cause."
                :author "Douglas Crockford"
                :presented_on (java.sql.Timestamp/valueOf "2014-10-19 10:23:54")
                :presented_at "NDC 2014"})
  (sql/insert! presentation/spec
               :presentations
               {:name "How To Stop Sucking And Be Awesome Instead"
                :description "If you're reading this abstract, you're not awesome enough. Attend this session to unlock the secrets of Jeff Atwood, world famous blogger and industry leading co-founder of Stack Overflow and Stack Exchange. Learn how you too can determine clear goals for your future and turn your dreams into reality through positive-minded conceptualization techniques.* Within four to six weeks, you'll realize the positive effects of Jeff Atwood's wildly popular Coding Horror blog in your own life, transporting you to an exciting new world of wealth, happiness and political power. (*May or may not also include working hard on things that matter for the rest of your life.)"
                :author "Jeff Atwood"
                :presented_on (java.sql.Timestamp/valueOf "2012-10-19 10:23:54")
                :presented_at "Atlassian Summit 2012"})
  (sql/insert! presentation/spec
               :presentations
               {:name "Micro-Service Architecture"
                :description "At the Forward Internet Group in London, we are implementing SOA in unusual ways. Rather than a few, business-related services being implemented per the original vision, we have developed systems made of myriads of very small, usually short-lived services. In this workshop, we will start by exploring the evolution of SOA implementations by the speaker. In particular, lessons learned from each implementation will be discussed, and re-application of these lessons on the next implementation. Challenges (and even failures) will be explicitly identified."
                :author "Fred George"
                :presented_on (java.sql.Timestamp/valueOf "2012-10-19 10:23:54")
                :presented_at "Baruco 2012"})
  (println " done"))
