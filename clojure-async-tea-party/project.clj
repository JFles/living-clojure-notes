(defproject clojure-async-tea-party "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/core.async "1.6.673"]]
  :repl-options {:init-ns clojure-async-tea-party.core}
  :main clojure-async-tea-party.core ;; needed for cli entry point
  :aot [clojure-async-tea-party.core]) ;; `aot` == `ahead-of-time` compilation -- useful for clojure code on cli
