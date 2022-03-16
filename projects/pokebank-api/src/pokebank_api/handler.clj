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
               :body (json/generate-string {:data {:message "Hello, world!"}})})
  
  (route/not-found "Not Found"))

; (println (site-defaults))
(println "Okay okay, chegou até aqui!")
(println (str "port" (Integer. (or (env :port) 5000))))

;; [Running the server]
(defn -main [port]
  (jetty/run-jetty app-routes                 {:port (Integer. (or port (env :port) 5000))}))

(defn -dev-main [port]
  (jetty/run-jetty app-routes                 {:port (Integer. (or port (env :port) 5000))}))

; using the greet handler as a var here
; this way wrap-reload, when it refreshes the namespaces,
; will affect the value of greet
#_ (defn -dev-main [port]
  (jetty/run-jetty (wrap-reload #'app-routes) {:port (Integer. (or port (env :port) 5000))}))

#_ (def app
    (wrap-defaults app-routes site-defaults))

#_ (defn -main [& [port]]
    (let [port (Integer. (or port (env :port) 5000))]
      (jetty/run-jetty (site #'app-routes) {:port port :join? false})))
