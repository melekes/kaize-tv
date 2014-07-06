(ns kaize-tv.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn common [title & body]
  (html5 {:class "no-js"}
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
    [:title title]
    (include-css "/css/normalize.min.css"
                 "/css/main.css")
    (include-css "http://fonts.googleapis.com/css?family=Sigmar+One&v1")]
    (include-js "/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js")
   [:body
    [:div {:class "header-container"}
     [:header {:class "wrapper clearfix"}
      [:h1 {:class "title"} "Kaize TV"]]]
    [:div {:class "main-container"} [:div {:class "main wrapper clearfix"} body]]]))

(defn not-found []
  (common "Page Not Found"
          [:div {:id "four-oh-four"}
           "The page you requested could not be found"]))
