(ns polymorphism)


;; Practical Polymorphism
;;
;; using a case like statement and defining behavior per class
;; There are better options -- this is more likely for example purposes
(defn who-are-you [input]
  (cond
    (= java.lang.String (class input)) "String - Who are you?"
    (= clojure.lang.Keyword (class input)) "Keyword - Who are you?"
    (= java.lang.Long (class input)) "Number - Who are you?"))

(who-are-you :alice)
(who-are-you "alice")
(who-are-you 123)
(who-are-you true)

;; We can use multimethods in Clojure to express polymorphism.
;; Need to determine how the multimethod is going to dispatch.
;; For our example, the multimethod will dispatch on the class of the input
(defmulti who-are-you-multi class)

(defmethod who-are-you-multi java.lang.String
  [input]
  (str "String - Who are you? " input))

(defmethod who-are-you-multi clojure.lang.Keyword
  [input]
  (str "Keyword - Who are you? " input))

(defmethod who-are-you-multi java.lang.Long
  [input]
  (str "Number - Who are you? " input))

(who-are-you-multi :alice)
(who-are-you-multi "alice")
(who-are-you-multi 123)
(who-are-you-multi true)

;; We can define a default dispatch for our multimethod so it doesn't throw an exception if it doesn't find a match
(defmethod who-are-you-multi :default
  [input]
  (str "I don't know - Who are you? " input))

;; For the next example, we'll create a multimethod that will dispatch on a function of Alice's height
;; so that she knows which side of the mushroom to eat from
(defmulti eat-mushroom (fn [height]
                         (if (< height 3)
                           :grow
                           :shrink)))

(defmethod eat-mushroom :grow
  [_]
  "Eat the right side to grow")

(defmethod eat-mushroom :shrink
  [_]
  "Eat the left side to shrink")

(eat-mushroom 1)
(eat-mushroom 9)

;; Another way to use polymorphism in Clojure is through protocols.
;; While multimethods are great using polymorphism on 1 func,
;; sometimes protocols can handle polymorphism elegantly w/ groups of funcs
(defprotocol BigMushroom
  (eat-mushroom-p [this]))

;; We implements the protocol for all our types at once using `extend-protocol`
(extend-protocol BigMushroom
  java.lang.String
  (eat-mushroom-p [this]
    (str (.toUpperCase this) " mmmm tasty!"))

  clojure.lang.Keyword
  (eat-mushroom-p [this]
    (case this
      :grow "Eat the right side!"
      :shrink "Eat the left side!"))

  java.lang.Long
  (eat-mushroom-p [this]
    (if (< this 3)
      "Eat the right side!"
      "Eat the left side!")))

(eat-mushroom-p "Big Mushroom")
(eat-mushroom-p :grow)
(eat-mushroom-p 1)

;; If we want to create our own data structures, we have two options.
;; If we need structured data, we should use `defrecord` which will create a class with a new type.
;; The `defrecord` form defines the fields that the class will hold.
;; For an example, lets make a `defrecord` to describe the mushroom that the
;; caterpillar was sitting on when Alice met him.
;; It had a color and height.
(defrecord Mushroom [color height])

;; Now we can create a new mushroom obj with dot notation
(def regular-mushroom (Mushroom. "white and blue polka dots" "2 inches"))

(class regular-mushroom)

;; we can get the values for fields on the class with `.-`
(.-color regular-mushroom)
(.-height regular-mushroom)

;; We can combine the structured data and type that `defrecord` gives us with protocols to
;; implement interfaces.
(defprotocol Edible
  (bite-right-side [this])
  (bite-left-side [this]))

;; now that our protocol is defined, we can have records implement it
(defrecord WonderlandMushroom [color height]
           Edible
           (bite-right-side [this]
             (str "The " color " bite makes you grow bigger"))
           (bite-left-side [this]
             (str "The " color " bite makes you grow smaller")))

(defrecord RegularMushroom [color height]
           Edible
           (bite-right-side [this]
             (str "The " color " bite tastes bad"))
           (bite-left-side [this]
             (str "The " color " bite tastes bad too")))

;; construct our mushrooms with the record dot syntax
(def alice-mushroom (WonderlandMushroom. "blue dots" "3 inches"))
(def reg-mushroom (RegularMushroom. "brown" "3 inches"))

;; and then we can take bites from each of our mushrooms to see what happens!
(bite-right-side alice-mushroom)
(bite-left-side alice-mushroom)

(bite-right-side reg-mushroom)
(bite-left-side reg-mushroom)

;; The benefits of `defrecord` include type-based dispatch and maipulating the data like maps (great for reuse).
;; When we don't need these benefits, then use `deftype` to avoid overhead
;;
;; WARNING
;; Don't reach for protocols too quickly! They should be used sparingly.
;; In most situtations, a pure function or multimethod could be used instead.
;;
;; As an example, we could rewrite our earlier protocol example to use a simple map and get the same result
(defn bite-right-side-m [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow bigger"
    "The bite tastes bad"))

(defn bite-left-side-m [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow smaller"
    "The bite tastes bad too"))

(bite-right-side-m {:type "wonderland"})
(bite-left-side-m {:type "wonderland"})

(bite-right-side-m {:type "regular"})
(bite-left-side-m {:type "regular"})
