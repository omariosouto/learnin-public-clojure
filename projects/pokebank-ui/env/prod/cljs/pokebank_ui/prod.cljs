(ns pokebank-ui.prod
  (:require [pokebank-ui.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
