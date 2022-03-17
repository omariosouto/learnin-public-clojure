(ns pokebank-api.server
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [ring.handler.dump :refer [handle-dump]]
            [compojure.route :as route]))

; [Service] ============
(defn greet [req]
  {:status 200
   :body "hi there im here oloco!"})

(defroutes server-routes
           (GET "/" [] greet)
           (GET "/request" [] handle-dump)
           (route/not-found "not found"))
; ======================

(def dev-port 8080)

; Definition of file
(defn -main [config]
  (jetty/run-jetty server-routes
                   {:port dev-port}))
(defn -dev-main [config]
  (println (str config "manooo"))
  (jetty/run-jetty (wrap-reload #'server-routes)
                   {:port dev-port}))

