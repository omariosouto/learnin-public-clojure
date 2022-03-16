(defproject pokebank-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License v1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [cheshire "5.8.1"]
                 [ring/ring-defaults "0.3.2"]
                 [environ "1.1.0"]
                 [ring/ring-jetty-adapter "1.7.1"]]
  :min-lein-version "2.0.0"
  :plugins [[lein-ring "0.12.5"]
            [environ/environ.lein "0.3.1"]]
  :hooks [environ.leiningen.hooks]
  :ring {:handler pokebank-api.handler/app}
  :uberjar-name "clojure-getting-started-standalone.jar"
  :profiles
  {:dev {:production {:env {:production true}}
         :dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
