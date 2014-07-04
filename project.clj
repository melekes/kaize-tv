(defproject kaize-tv "0.0.1"
  :description "KaizeTv provides convenient access to Kaize presentations."
  :url "http://tv.kaize.ru"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/java.jdbc "0.3.4"]
                 [org.postgresql/postgresql "9.3-1101-jdbc41"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.4"]
                 [ring-server "0.3.1"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler kaize-tv.handler/app
         :init kaize-tv.handler/init}
  :aot :all
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
    {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.0"]]
     :ring
     {:open-browser? false}}}
  )

