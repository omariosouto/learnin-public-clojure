(ns pokebank-api.server
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [ring.handler.dump :refer [handle-dump]]
            [compojure.route :as route]
            [environ.core :refer [env]]
            [cheshire.core :as json]))

; [Service] ============
(defn greet [req]
  {:status 200
   :body "hi there"})

(println (greet "req"))

(defroutes server-routes
           (GET "/" [] greet)
           (GET "/request" [] handle-dump)
           (route/not-found "not found"))
; ======================

; Definition of file
(defn -main [port]
  (jetty/run-jetty server-routes
                   {:port (int port)}))
(defn -dev-main [port]
  (jetty/run-jetty (wrap-reload #'server-routes)
                   {:port (int port)}))

