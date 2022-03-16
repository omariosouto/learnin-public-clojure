(ns pokebank-api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :as json]
            [environ.core :refer [env]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] {
               :headers {"Content-Type" "application/json; charset=utf-8"}
               :body (json/generate-string {:data {:message "Hello, world!"}})
  })
  (route/not-found "Not Found"))

;; (def app
;;   (wrap-defaults app-routes site-defaults))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app-routes) {:port port :join? false})))
