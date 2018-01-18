(ns dominion-module.core
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]
            [unicode-math.core :refer :all])
  (:gen-class))

                                        ; In mm
(def card-deck-depth 6)
(def card-deck-height 96)
(def card-deck-width 62)

(def module-length 15)
(def module-width 69)
(def module-height 45)

(def finger-hole-width 40)
(def finger-hole-heigth 60)

(defn -main
  "I am become tool, the optimizer of Dominion-boxes."
  [& args]

  (def base
    (cube  module-width module-length module-height))

  (def finger-hole
    (translate [0 0 (/ module-height 2)]
               (cube finger-hole-width module-width finger-hole-heigth)))


  (def card-deck
    (translate [0 (/ (- module-length card-deck-depth) 2) (/ module-width 2)]
               (cube card-deck-width, card-deck-depth, card-deck-height)))

  (def primitives
    (difference
     (difference
      base
      card-deck)
     finger-hole))

  (spit "dominion-module.scad"
        (write-scad primitives)))
