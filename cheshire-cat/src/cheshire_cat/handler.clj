 (ns cheshire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            ;;[cheshire.core :as json] ;; replacing this with ring middleware
            [ring.middleware.json :as ring-json] ;; don;t believe this is a real dependency in the latest version
            [ring.util.response :as rr]))

(defroutes app-routes ;; sequence of HTTP routes -- request paths the web app will handle
  (GET "/" [] "Hello World")
  ;;(GET "/cheshire-cat" []
       ;; defining a map for the json response with cheshire.core
       ;; Cumbersome approach that can be made more succinct with middleware
       ;;{:status 200
        ;;:headers {"Content-Type" "application/json; charset=utf-8"}
        ;;:body (json/generate-string
          ;;     {:name "Cheshire Cat"
            ;;    :status :grinning})})
  (GET "/cheshire-cat" []
       (rr/response {:name "Cheshire Cat" :status :grinning})) ;; create a basic 200 json resp with ring middleware
  (route/not-found "Not Found")) ;; 404 handler for undefined path request

;; (def app (wrap-defaults app-routes site-defaults)) ;; non-threaded approach. Would eval parens from lowest nest

(def app
  "sets up some basic middleware needed on std websites such as parameter, session, cookie handling,
  and handling rsrc files such as images, CSS, and JavaScript"
  (-> app-routes ;; threading `app-routes` for readability and to avoid nesting
      (wrap-defaults site-defaults) ;; wrap our `app-routes` with `site-defaults`
      (ring-json/wrap-json-response))) ;; then wrap `app-routes` with auto JSON response so we only have to pass a map


;; 😺 Experimenting with Cheshire to eval in REPL! 🛑

;; ;; turns our clj data struct into a JSON string
;; (println (json/generate-string {:name "Chesire Cat" :state "Grinning"}))

;; ;; takes a JSON enc str and returns a data struct. Default returns map keys as strings
;; (println (json/parse-string
;;           "{\"name\":\"Chesire Cat\",\"state\":\"Grinning\"}"))

;; ;; supplying `true` as the 2nd arg for `json/parse-string` will transform keys in the result to keywords
;; (println (json/parse-string
;;           "{\"name\":\"Chesire Cat\",\"state\":\"Grinning\"}" true)) ;; Ah, much better 🫶
