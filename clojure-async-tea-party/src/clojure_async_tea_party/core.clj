(ns clojure-async-tea-party.core
  (:gen-class) ;; needed to generate a class to run as a stand-alone program
  (:require [clojure.core.async :as async]))

;; For our example, we'll simulate hitting both a "Google Tea Service" and a "Yahoo Tea Service"
;; And we'll return whichever service gets us our tea faster

;; To start, we'll create buffered channels for both services
(def google-tea-service-chan (async/chan 10))
(def yahoo-tea-service-chan (async/chan 10))

;; we can simulate calling each service with a func that returns at random different times
(defn random-add []
  (reduce + (conj [] (repeat 1 (rand-int 100000)))))

;; When we req each svc, we'll randomly sleep w/i our core.async `go` block,
;; then we'll put our tea on the channel to be consumed
(defn request-google-tea-service []
  (async/go
    (random-add)
    (async/>! google-tea-service-chan
              "Tea compliments of Google")))

(defn request-yahoo-tea-service []
  (async/go
    (random-add)
    (async/>! yahoo-tea-service-chan
              "Tea compliments of Yahoo")))

;; And now we can create a func to call both svcs and return the fastest tea
;; which will use `alts!` to listen to both services
(defn request-tea []
  (request-google-tea-service) ;; request tea w/ random sleep
  (request-yahoo-tea-service) ;; request tea w/ random sleep
  (async/go (let [[v] (async/alts! ;; listen on both channels to see which svc returns a val first
                       [google-tea-service-chan
                        yahoo-tea-service-chan])]
              (println v)))) ;; print out our winning tea service!

;; And we can now call our "Tea Race" function repeatedly to see who is faster each time!
;; 👇 uncomment this if you want to eval this in a buffer
;; (request-tea)



;; And now we're going to make a few additional modifications so we can
;; create a tea party on command line!

;; One issue we'll need to address is that our program doesn't know to wait for our
;; async call to finish and print out, and it will likely exit before then.
;;
;; We can address this by using a blocking `take` off the result channel.
(def result-chan (async/chan 10))

(defn request-tea-cli []
  (request-google-tea-service)
  (request-yahoo-tea-service)
  (async/go (let [[v] (async/alts!
                       [google-tea-service-chan
                        yahoo-tea-service-chan])]
              (async/>! result-chan v)))) ;; fastest result gets put on `result-chan`

;; We will also need a `-main` func before we can run this on cli.
(defn -main [& args]
  (println "Requesting tea!")
  (request-tea-cli)
  (println (async/<!! result-chan)))
