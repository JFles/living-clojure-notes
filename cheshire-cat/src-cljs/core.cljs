(ns cheshire-cat.core
  (:require-macros [cljs.core.async.macros :refer [go]]) ;; need a special keyword because this macro comes from clj
  (:require [clojure.browser.repl :as repl]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [enfocus.core :as ef]))

;; `^:export` is used to add metadata
;; We use this as the `main` entry point for the browser.
;; Export allows `init` to be exposed as a func that JS can call from the global context
(defn ^:export init []
  ;; (js/alert "This is fun!"))
  (repl/connect "http://localhost:9000/repl") ;; connect our cljs REPL to our served webpage
  (go ;; async take needs to be in a go block
    (let [response (<! (http/get "/cheshire-cat"))
          body (:body response)]
      (ef/at "#cat-name" (ef/content (:name body)))
      (ef/at "#status" (ef/content (:status body))))))
