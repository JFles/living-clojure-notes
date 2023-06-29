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

;; #13 - `rest`
;;
(= [20 30 40] (rest [10 20 30 40]))

;; #14 - Functions
;;
;; Exploring the many ways Clojure allows us to create funcs
(= 8 ((fn add-five [x] (+ x 5)) 3))

(= 8 ((fn [x] (+ x 5)) 3))

(= 8 (#(+ % 5) 3))

(= 8 ((partial + 5) 3))

;; #15 - Double Down
;;
;; Writing a simple function which doubles a number
(= (#(* % 2) 2) 4)

;; #16 - Hello World
;;
;; Writing a func which returns a personalized greeting
(= (#(str "Hello, " % "!") "Dave") "Hello, Dave!")

;; #17 - Map
;;
;; Map takes two args: a func `f` and a seq `s`
;; Map returns a new seq of the result of applying `f` to each item of `s`
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;; #18 - Filter
;;
;; Filter takes two args: a predicate func `f` and a seq `s`.
;; It returns a new seq consisting of each item of `s` where (= (f item) true)
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; #35 - Local Bindings
;;
;; Giving local lexically scoped values names with the `let` form
(= 7 (let [x 5] (+ 2 x)))

(= 7 (let [x 3, y 10] (- y x)))

(= 7 (let [x 21] (let [y 3] (/ x y))))

;; #36 - Let it Be
;;
;; Binding `x` `y`, and `z` to make the statement true
(= 10 (let [x 7, y 3] (+ x y)))

(= 4 (let [y 3, z 1] (+ y z)))

(= 1 (let [z 1] z))




;; ====================
;; ~~~ Week 1 Day 3 ~~~
;; ====================

;; 37, 57, 68, 71, 72, 145

;; #37 - Regular Expressions
;;
;; Regex patterns are supported with a special reader macro
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;; #57 - Simple Recursion
;;
;; Recursion is one of the fundamental techniques used in functional programming
(= '(5 4 3 2 1) ((fn foo [x]
                   (when (> x 0)
                     (conj (foo (dec x)) x)))
                 5))

;; #68 - Recurring Theme
;;
;; Clojure has one non-stack-consuming looping construct, `recur`
;; Either a func or loop can be used as the recursion point
;; `recur` rebinds the bindings of the recursion point to the vals its passed.
;; It must be called from the tail-pos else error
(= [7 6 5 4 3]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))

;; #71 - Rearranging Code: ->
;;
;; The `->` macro threads an expr `x` through a variable num of forms.
;; First, `x` is inserted as the second item in the first form,
;; making a list of it if it isn't already a list.
;; Second, the first form is inserted as the second item in the second form,
;; and making a list of that form if necessary.
;;
;; This process continues for all the forms, and it can sometimes make code more readable
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] reverse rest sort last)
   5)

;; #72 - Rearranging Code: ->>
;;
;; The `->>` macro threads an expr `x` through a variable num of forms.
;; First, `x` is inserted as the last item in the first form,
;; making a list of it if it isn't already a list.
;; Second, the first form is inserted as the last item in the second form,
;; and making a list of that form if necessary.
(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
   11)

;; #145 - For the win
;;
;; Clojure's `for` macro helps us produce a seq based on some other seq(s).
;; It may be hard to understand, but it has a big payoff with clear, concise seq wrangling
(= '(1 5 9 13 17 21 25 29 33 37)
   (for [x (range 40)
         :when (= 1 (rem x 4))]
     x))

(= '(1 5 9 13 17 21 25 29 33 37)
   (for [x (iterate #(+ 4 %) 0)
         :let [z (inc x)]
         :while (< z 40)]
     z))


(= '(1 5 9 13 17 21 25 29 33 37)
   (for [[x y] (partition 2 (range 20))]
     (+ x y)))

;; ====================
;; ~~~ Week 1 Day 4 ~~~
;; ====================

;; 20, 24, 25, 27, 32

;; #20 - Penultimate Element
;;
;; Write a func which returns the 2nd to last el from a seq

(defn get-sec-to-last [list]
  (-> list
      ;; (when (> (count list) 2) drop-last)
      (drop-last)
      reverse
      first))

(get-sec-to-last (list 1 2 3 4 5))

(= ((fn [l] (-> l (drop-last) last))
    (list 1 2 3 4 5))
   4)

(= ((fn [l] (-> l (drop-last) last))
    ["a" "b" "c"])
   "b")

(= ((fn [l] (-> l (drop-last) last))
      [[1 2] [3 4]])
   [1 2])

;; #24 - Sum It All Up
;;
;; Write a func which returns the sum of a sequence of numbers
(defn sum [coll]
  (reduce + coll))

(= (sum [1 2 3]) 6)
(= (sum (list 0 -2 5 5)) 8)
(= (sum #{4 2 1}) 7)
(= (sum '(0 0 -1)) -1)
(= (sum '(1 10 3)) 14)

;; #25 - Find the odd numbers
;;
;; Write a func which only returns the odd nums from a seq
(defn return-only-odds [coll]
  (filter #(= 1 (mod % 2)) coll))

(= (return-only-odds #{1 2 3 4 5}) '(1 3 5))
(= (return-only-odds [4 2 1 6]) '(1))
(= (return-only-odds [2 2 4 6]) '())
(= (return-only-odds [1 1 1 3]) '(1 1 1 3))

;; #27 - Palindrome Detector
;;
;; Write a func which returns true if a given seq is a palindrome
;;
;; Site fails with not being able to find java.lang.String despite it being valid code
(defn palindrome? [coll]
  (= coll (if (= java.lang.String (type coll))
            (apply str (reverse coll))
            (reverse coll))))

;; Another user submitted the following solution which doesn't rely on a type check
(fn [x] (= (reverse x)
           (seq x)))

(false? (palindrome? '(1 2 3 4 5)))
(true? (palindrome? "racecar"))
(true? (palindrome? [:foo :bar :foo]))
(true? (palindrome? '(1 1 3 3 1 1)))
(false? (palindrome? '(:a :b :c)))

;; #32 - Duplicate a Sequence
;;
;; Write a func which duplicates each el of a seq
(defn duplicate-seq [coll]
  (mapcat #(repeat 2 %) coll))

(= (duplicate-seq [1 2 3]) '(1 1 2 2 3 3))
(= (duplicate-seq [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (duplicate-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (duplicate-seq [44 33]) [44 44 33 33])

;; ====================
;; ~~~ Week 1 Day 5 ~~~
;; ====================

;; 30, 31, 41, 45, 33
;;
;; #30 - Compress a Sequence
;;
;; Write a func which removes consecutive dupes from a seq
(= (apply str (dedupe "Leeeeeerrroyyy")) "Leroy")
(= (dedupe [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (dedupe [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

;; #31 - Pack a Sequence
;;
;; Write a func which packs consec dupes into sub-lists
(defn separate-unique-values [coll]
  (partition-by identity coll))

(= (separate-unique-values [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (separate-unique-values [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (separate-unique-values [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

;; #41 - Drop Every Nth Item
;;
;; Write a func which drops every Nth item from a seq
(defn drop-every-nth-item [coll n]
  (let [adj (dec n)]
  (keep-indexed #(if (not= 0 (mod %1 adj)) %2) coll)))

(= (drop-every-nth-item [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (drop-every-nth-item [:a :b :c :d :e :f] 2) [:a :c :e])
(= (drop-every-nth-item [1 2 3 4 5 6] 4) [1 2 3 5 6])

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
