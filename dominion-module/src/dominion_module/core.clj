(ns dominion-module.core
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]
            [unicode-math.core :refer :all])
  (:gen-class))

; In mm
;
; Total module measurements
(def module-length 15)
(def module-length-e (+ module-length 1))
(def module-width 69)
(def module-height 45)

; Measurements for the part that the cards sit on
(def deck-depth 8)
(def deck-height 96)
(def deck-width 62)
(def deck-intersect-depth (+ deck-depth 1))
(def deck-side-height (/ module-height 2))
(def to-deck-edge (/ (- module-length-e deck-intersect-depth) 2))

; Measurements for the hole in the middle
(def finger-hole-width 40)
(def finger-hole-heigth 60)
(def finger-hole-lower-w (* (/ finger-hole-width 3) 2))

; Calculations for the couplers
(def coupler-width (/ deck-width 10))
(def coupler-length (/ deck-depth 5))
(def coupler-height deck-depth)
(def coupler-diameter (/ deck-depth 3))


(defn -main
  "I am become tool, the optimizer of Dominion-boxes."
  [& args]

  (def coupler [scale]
    (rotate [0,0,(* 0.5 pi)] ; 90 degrees
            (translate [(+ coupler-length (/ coupler-diameter 2))  0 (- (-(/ module-height 2) (/ coupler-height 2)))]
                       (union
                        (translate [(* coupler-length 2) 0 0] (cylinder coupler-diameter coupler-height))
                        (cube coupler-width coupler-length coupler-height)))))
  (def front-couplers
    (union
     (translate [(- (/ module-width 2) (* coupler-diameter 2)) (/ module-length 2) 0] coupler)
     (translate [(- (- (/ module-width 2) (* coupler-diameter 2))) (/ module-length 2) 0] coupler)))

  (def base
    (difference
     (union
      (cube  module-width module-length module-height)
      front-couplers)
     (translate [0 (- module-length) 0] front-couplers)))

  (def finger-hole
    (translate [0 0 (/ module-height 2)]
               (cube finger-hole-width module-width finger-hole-heigth)))

  (def get-main-deck-cut
    (translate [0 (/ (- module-length deck-depth) 2) (/ module-width 2)]
               (cube deck-width, deck-intersect-depth, deck-height)))

  (def get-side-cut
    (let [side-intersect-height              (- module-height deck-side-height)
          to-module-top    (- (/ module-height 2) (/ side-intersect-height 2))]
      (translate [0 to-deck-edge to-module-top]
                 (cube (+ module-width 1) deck-intersect-depth side-intersect-height))))

  (def get-lower-fhole-cut
    (translate [0 to-deck-edge 0]
               (cube finger-hole-lower-w deck-intersect-depth module-height)))

  (def card-deck
    (union
     (union get-main-deck-cut get-side-cut)
     get-lower-fhole-cut))

  (def primitives
    (difference
     (difference
      base
      card-deck)
     finger-hole))

  (spit "dominion-module.scad"
        (write-scad primitives)))
