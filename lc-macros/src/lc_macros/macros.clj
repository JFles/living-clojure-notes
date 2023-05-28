(ns lc-macros.macros)

;; Exploring macros in ch 8 of Living Clojure
;;
;; Allows us to do meta-programming in Clojue.
;; We can use them for creating abstraction as well as implementing language features.
;;
;; One example macro in the library is `when`
(defmacro when
  "Evaluates a test. If logical true, evaluates body in an implicit do."
  {:added "1.0"}
  [test & body] ;; takes in a test and remaining args as the body of the expression
  (list 'if test (cons 'do body))) ;; returns a list of the code with deferred execution

;; I'm not sure I completely follow, but the "macro is creating code from code"
;; It is taking advantage of the fact that in clojure "code is data"
;; Essentially, the macro takes code in and transforms it into new code for the program to evaluate
;;
;;Here's an example of code using our `when` macro
(when (= 2 2) (println "It is four!"))
;;
;; In order to see what's happening in the code, we can use the `macroexpand` func.
;; It takes a macro form and allows us to see the resulting code from the macro transformation.
(macroexpand-1
 '(when (= 2 2) (println "It is four!")))

;; Creating our own macros
;;
;; The following example is of characters from Alice in Wonderland introducing themselves
;; to the Queen of Hearts.
(defn hi-queen [phrase]
  (str phrase ", so please your Majesty."))

(defn alice-hi-queen []
  (hi-queen "My name is Alice"))

(alice-hi-queen)

(defn march-hare-hi-queen []
  (hi-queen "I'm the March Hare"))

(march-hare-hi-queen)

(defn white-rabbit-hi-queen []
  (hi-queen "I'm the White Rabbit"))

(white-rabbit-hi-queen)

(defn mad-hatter-hi-queen []
  (hi-queen "I'm the Mad Hatter"))

(mad-hatter-hi-queen)

;; There is a ton of repetition in the above example. We should see a pattern here.
;; - The function name is the character name followed by `hi-queen`
;; - The string of the characters intro is returned appended by "so please your majesty"
;;
;; If we have the name of the symbol and the intro string, we could generate
;; a function with a macro
;;
;; As a tip, the best place to start when creating a macro is at the end.
;; We need to visualize how we want to call our macro.
;; We also need to visualize what the code will look like once we call it.
;; Once we know what we want the end result to look like, we can concentrate
;; on creating the transformation we want the macro to do.
;;
;; To that end, before we write any code, we will first take an example and imagine
;; what the end result will look like.
;;
;; We want to be able to call our macro with the two pieces of info it needs:
;; the symbol of the function and the intro string.
;;
;; Because the macro will be generating our funcs, we'll call it `def-hi-queen`
;; and call it as follows
(def-hi-queen alice-hi-queen "My name is alice")
;;
;; Once our macro is evaluated, we want it to produce the following
(defn alice-hi-queen []
  (hi-queen "My name is Alice"))
;;
;; since we know our end result, we can start writing our `defmacro`
;; We'll be designing it with the knowledge that code is data
;; and we can create a list with code that we want as an end result
(defmacro def-hi-queen [name phrase] ;; takes in the func symb name and intro string
  (list 'defn ;; return a list of `code is data` in order to defer evaluation and return the symbol
        (symbol name) ;; create a symbol from the `name` arg
        [] ;; vector for the args that `defn` expects
        (list 'hi-queen phrase)))
;;
;;now we can test our macro to see what it will look like with `macroexpand-1`
(macroexpand-1
 '(def-hi-queen alice-hi-queen "My name is Alice"))
;;
;; And so we can generate our func by calling the macro
(def-hi-queen alice-hi-queen "My name is Alice")
;;
;; This will allow us to refactor our code into the following
(defmacro def-hi-queen [name phrase] ;; takes in the func symb name and intro string
  (list 'defn ;; return a list of `code is data` in order to defer evaluation and return the symbol
        (symbol name) ;; create a symbol from the `name` arg
        [] ;; vector for the args that `defn` expects
        (list 'hi-queen phrase)))

(def-hi-queen alice-hi-queen "My name is Alice")
(def-hi-queen march-hare-hi-queen "I'm the March Hare")
(def-hi-queen white-rabbit-hi-queen "I'm the White Rabbit")
(def-hi-queen mad-hatter-hi-queen "I'm the Mad Hatter")

(alice-hi-queen)
(march-hare-hi-queen)
(white-rabbit-hi-queen)
(mad-hatter-hi-queen)

;; We can make this code even more concise with `templating`
;; Templating in clojure uses something called the `Syntax-quote`
;; which is represented by a backtick.
;; It works similarly to the regular quote which defers eval and returns
;; code as data in list form.
;;
;; Here's a list of code with the regular quote
'(first [1 2 3])
;; -> (first [1 2 3])
;;
;; And here's a list of code using the Syntax-quote
`(first [1 2 3])
;; -> (clojure.core/first [1 2 3])
;;
;; One difference to note here is that the Syntax-quote gives us back a fully qualified function.
;; The other diff is that we can use the Syntax-quote with another templating helper
;; called the `Unquote` which is represented by the tilde ~.
;;
;; Using both of these together allows us to insert values into the syntax quote.
;; This gives us finer control over what the resulting code will look like.
;;
;; With just a plain Syntax-quote, we aren't able to insert values into our resulting list.
;; This is because the Syntax-quote will also prevent eval like the regular-quote
;;
;;We can use the Unquote to tell for a symbol of `x`, we want to deref and use its value
(let [x 5]
  `(first [~x 2 3]))
;; Which seems similar to string interpolation in Swift if we think about
;; "Code as Data" in a similar way to how strings can be parsed, manipulated, and interpolated
;;
;; So with our `templating` we can further reduce our earlier `def-hi-queen` macro
;; to make it more concise and readable
(defmacro def-hi-queen [name phrase]
  `(defn ~(symbol name) [] ;; we use the unquote to eval the symb name of the param
     (hi-queen ~phrase))) ;; and the same is done here

;; Macros are powerful, but they come with additional costs in comprehensibility.
;; Because they use metaprogramming, they are harder to understand than standard funcs.
;; Additionally, they're harder to compose. For example, you can't use them directly
;; with higher-order funcs such as `map` or `filter`
;;
;; It is a good rule to never write a macro if you can use a regular func instead
;;
;; Good times to use macros are:
;; - To overcome the limitation of when code is eval'd
;;   - e.g. params are always eagerly evaluated -- we wouldn't want this in the case of `when`
;; - When we want code to be eval'd at `compiletime` rather than `runtime` with funcs
;; - When we want custom syntax that can't be eval'd with the normal func's syntax
