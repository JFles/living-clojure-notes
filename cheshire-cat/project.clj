(defproject cheshire-cat "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.4"]
                 ;;[cheshire "5.11.0"]] ;; for enc/dec json quickly
                 [ring/ring-json  "0.5.1"] ;; ring middleware for handling json req/resp
                 [org.clojure/clojurescript "1.11.60"] ;; clojurescript time boi!
                 [cljs-http "0.1.46"] ;; handling HTTP in cljs
                 [org.clojure/core.async "1.6.673"]] ;; cljs-http will leverage async calls
  :plugins [[lein-ring "0.12.5"] ;; provides automation for common Ring tasks, e.g. starting the web server
            [lein-cljsbuild "1.1.8"]] ;; autocompile cljs code and get a nice cljs repl to boot!
  :ring {:handler cheshire-cat.handler/app} ;; points to the main app route for the web server startup task
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}}
  :cljsbuild {:builds [{:source-paths ["src-cljs"] ;; tells `cljsbuild` where to find our cljs code
                        :compiler {:output-to "resources/public/main.js" ;; where our compiled cljs code will go
                                   :optimizations :whitespace ;; trims ws. Good for dev/debugging. Prod can use advanced compilation modes
                                   :pretty-print true}}]}) ;; you know what's up
