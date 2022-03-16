(ns pokebank-api.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [environ.core :refer [env]]
            [cheshire.core :as json]))

(defroutes app-routes
  (GET "/" [] {
               :headers {"Content-Type" "application/json; charset=utf-8"}
               :body (json/generate-string {:data {:message "Hello, world!"}})
  })
  (route/not-found "Not Found"))

; (println (site-defaults))
(println "Okay okay, chegou até aqui!")

(def app
  (wrap-defaults app-routes site-defaults))

#_ (defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app-routes) {:port port :join? false})))
