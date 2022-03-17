(defproject pokebank-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :aliases {"run-dev" ["echo 'alo alo w brazil'"]}

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [compojure "1.1.6"]
                 [ring "1.9.5"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [ring/ring-core "1.9.5"]
                 [cheshire "5.8.1"]
                 [environ "1.1.0"]]
  :repl-options {:init-ns pokebank-api.server}
  :plugins [[lein-ring "0.12.5"]
            [environ/environ.lein "0.3.1"]]
  ; Profile
  :profiles {:dev
             {:main pokebank-api.server/-dev-main}}
  ; Tasks
  :ring {:handler pokebank-api.server/-dev-main})
