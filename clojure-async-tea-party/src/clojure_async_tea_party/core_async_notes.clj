(ns clojure-async-tea-party.core-async-notes
  (:require [clojure.core.async :as async]))

;; first, we need to create a channel to put values on
(def tea-channel (async/chan))

;; There are two ways to get things on and off channels -- async and sync.
;; Starting with sync, we have blocking `puts` and `takes`
;; - Blocking put uses `>!!`
;; - Blocking take uses `<!!`
;; Both are handled synchronously.

;; We can start by putting a cup of tea on our tea channel, but we have a big problem.
;; Currently `tea-channel` is unbuffered, so if we were to put a val on it, the main thread would
;; block until the value is taken off. This would also lock up our program and repl
;;
;; To solve this, lets create a buffered REPL
(def tea-channel (async/chan 10))

;; Now we can put our cup of tea on our channel with a blocking put
(async/>!! tea-channel :cup-of-tea)

;; And then we can use a blocking take to pull it off our channel
(async/<!! tea-channel)

;; WARNING!!
;; Be careful to not using blocking puts OR takes when there is no buffer size or when the buffer is empty]
;; Seems to still stop the repl if we `take` from an empty channel

;; We can also close our channel with `close!`
;; This closes the channel to new inputs. We can still pull values off, and when the
;; channel is finally empty, it will return nil.
;; Maybe this will prevent the empty buffer blocking `take` locking up the main thread.
(async/>!! tea-channel :cup-of-tea-2)
(async/>!! tea-channel :cup-of-tea-3)
(async/>!! tea-channel :cup-of-tea-4)

(async/close! tea-channel)

;; and we can eval the statement below to see what happens when try to add another
;; cup of tea after we've closed the channel
(async/>!! tea-channel :cup-of-tea-5)
;; It returns a false!

;; but we can still take our cups of tea off until the channel is empty
(async/<!! tea-channel)
(async/<!! tea-channel)
(async/<!! tea-channel)

;; and if we try to `take` from our empty and closed channel, it will return `nil`
;; BUT it no longer blocks the main thread as it did when the channel was still open
;; and we did a blocking take on an empty channel 🍻
(async/<!! tea-channel)




;; Now that we can do this synchronously, how can we do this asynchronously?
;; We can do this within a `go` block and an async `put` and `take`
;; - Async `put` is indicated by `>!`
;; - Async `take` is indicated by `<!`
;; NOTE: async must be used within a `go` block
(let [tea-channel (async/chan)]
  (async/go (async/>! tea-channel :cup-of-tea-1))
  (async/go (println "Thanks for the " (async/<! tea-channel))))

;; We can set up a `go-loop` which will continuously execute and wait on a val from a channel
(def tea-channel (async/chan 10))

(async/go-loop []
  (println "Thanks for the " (async/<! tea-channel))
  (recur))

;; Once we eval our `async/go-loop`, it'll wait in the background and listen to anything we put
;; on our `tea-channel`
(async/go (async/>! tea-channel :hot-cup-of-tea))
(async/go (async/>! tea-channel :tea-with-sugar))
(async/go (async/>! tea-channel :tea-with-milk))



;; With `core.async`, we can look at multiple channels as well and
;; get the val from whichever arrives first using `alts!`.

;; For our example, we can use 3 channels
(def tea-channel (async/chan 10))
(def milk-channel (async/chan 10))
(def sugar-channel (async/chan 10))

;; And now we can combine input on all these channels using `alts!`
(async/go-loop []
  (let [[v ch] (async/alts! [tea-channel
                             milk-channel
                             sugar-channel])]
    (println "Got " v " from " ch)
    (recur)))

;; Now we can add input to any of the channels and the `go-loop` will process the input
;; from whatever channel has the value
(async/go (async/>! sugar-channel :sugar))
(async/go (async/>! milk-channel :milk))
(async/go (async/>! tea-channel :tea))
