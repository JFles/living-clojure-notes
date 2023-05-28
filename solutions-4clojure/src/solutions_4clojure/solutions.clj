(ns solutions-4clojure.solutions
  (:require [clojure.set :as s]))

;; Solutions and notes for 4Clojure problems
;; https://4clojure.oxal.org/#/

;; ====================
;; ~~~ Week 1 Day 1 ~~~
;; ====================

;; 1 - 12

;; #1 - Nothing but the truth
(= true true)

;; #2 - Simple Math
(= (- 10 (* 2 3)) 4)

;; #3 - Strings
(= "HELLO WORLD" (.toUpperCase "hello world")) ;; using java string method for transform

;; #4 - Lists
;;
;; Lists can be constructed with either a func or quoted form (defer eval -- code as data)
(= (list :a :b :c) '(:a :b :c))

;; #5 - Conj on lists
;;
;; When operating on a list, `conj` will append to front (prepend)
(= (list 1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

;; #6 - Vectors
;;
;; Vectors can be constructed in many ways and can be compared with lists directly
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;; #7 - conj on vectors
;;
;; When operating on a Vector, the `conj` func will return a new vector with appended items
(= [1 2 3 4] (conj [1 2 3] 4))

;; #8 - Sets
;;
;; Sets are collections of unique values
(= #{:a :b :c :d} (set '(:a :a :b :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (s/union #{:a :b :c} #{:b :c :d}))

;; #9 - Conj on sets
;;
;; Returns a new set with new keys added
(= #{1 2 3 4} (conj #{1 4 3} 2))

;; #10 - Maps
;;
;; Maps store k-v pairs. Both Keys or Values can be used as lookup. Commas treated as ws
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

;; #11 - Conj on maps
;;
;; `conj` will return a new map with the k-v pair added
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

;; #12 - Sequences
;;
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))


;; ====================
;; ~~~ Week 1 Day 2 ~~~
;; ====================

;; 13-18, 35, 36

;; ====================
;; ~~~ Week 1 Day 3 ~~~
;; ====================

;; 37, 57, 68, 71, 72, 145

;; ====================
;; ~~~ Week 1 Day 4 ~~~
;; ====================

;; 20, 24, 25, 27, 32

;; ====================
;; ~~~ Week 1 Day 5 ~~~
;; ====================

;; 30, 31, 41, 45, 33,

;; ====================
;; ~~~ Week 2 Day 1 ~~~
;; ====================

;; 26, 29, 48, 42, 52

;; ====================
;; ~~~ Week 2 Day 2 ~~~
;; ====================

;; 51, 83, 66

;; ====================
;; ~~~ Week 2 Day 3 ~~~
;; ====================

;; 107, 90

;; ====================
;; ~~~ Week 2 Day 4 ~~~
;; ====================

;; 88, 100

;; ====================
;; ~~~ Week 2 Day 5 ~~~
;; ====================

;; 97

;; ====================
;; ~~~ Week 3 Day 1 ~~~
;; ====================

;; 95, 96

;; ====================
;; ~~~ Week 3 Day 2 ~~~
;; ====================

;; 46, 44

;; ====================
;; ~~~ Week 3 Day 3 ~~~
;; ====================

;; 43, 50

;; ====================
;; ~~~ Week 3 Day 4 ~~~
;; ====================

;; 67

;; ====================
;; ~~~ Week 3 Day 5 ~~~
;; ====================

;; 77



;; *~*~*~*~
;; We're switching gears to Katas starting on Week 4
;; So we'll want a new project per kata
