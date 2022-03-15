(ns github-profile-display.core
  (:gen-class))


; global "variable" declaration
(def profile-username "omariosouto")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "Hello, World!" profile-username)))
