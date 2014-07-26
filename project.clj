(defproject kaize-tv "0.1.0"
  :description "KaizeTv provides convenient access to Kaize presentations."
  :url "http://tv.kaize.ru"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-core "1.3.0"]
                 [ring/ring-json "0.3.1"]
                 [org.clojure/clojurescript "0.0-2277"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [cljs-http "0.1.15"]
                 [om "0.6.5"]
                 [com.facebook/react "0.11.1"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.11"]
            [lein-pdo "0.1.1"]]
  :ring {:handler kaize-tv.handler/app}
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   :optimizations :none
                                   :source-map true}}]}
  :aliases {"up" ["pdo" "cljsbuild" "auto" "dev," "ring" "server-headless"]}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
