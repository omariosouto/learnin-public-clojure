(ns pokebank-ui.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [pokebank-ui.core-test]))

(doo-tests 'pokebank-ui.core-test)
