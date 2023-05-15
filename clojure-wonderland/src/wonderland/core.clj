(ns wonderland.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(+ 2 2)

(foo 2)

(defn who-are-you [input]
  (cond
    (= java.lang.String (class input)) "String - Who are you?"
    (= clojure.lang.Keyword (class input)) "Keyword - Who are you?"
    (= java.lang.Long (class input)) "Number - Who are you?"))

(who-are-you :alice)
(who-are-you "alice")
(who-are-you 123)
(who-are-you true)
