;; gorilla-repl.fileformat = 2

;; **
;;; # ZMQ testing 
;;; 
;;; https://github.com/daveyarwood/ezzmq
;; **

;; @@
; Automatically Download Dependencies (if they are not installed already) 
 (use '[pinkgorilla.helper]) 
 (pinkgorilla.helper/add-dependencies 
   '[pinkgorilla.ui.gorilla-plot "0.8.6"])
 (pinkgorilla.helper/add-dependencies 
   '[io.djy/ezzmq "0.8.2"])
;; @@
;; =>
;;; ["^ ","~:type","list-like","~:open",["span",["^ ","~:class","clj-map"],"{"],"~:close",["span",["^ ","^2","clj-map"],"}"],"~:separator",["span",", "],"~:items",[["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","~:content",["span",["^ ","^2","clj-symbol"],"org.clojure/clojure"],"~:value","org.clojure/clojure"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"1.9.0\""],"^7","\"1.9.0\""]],"^7","[org.clojure/clojure \"1.9.0\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-set"],"#{"],"^3",["span",["^ ","^2","clj-set"],"}"],"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.clojure/core.specs.alpha"],"^7","org.clojure/core.specs.alpha"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.24\""],"^7","\"0.1.24\""]],"^7","[org.clojure/core.specs.alpha \"0.1.24\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.clojure/spec.alpha"],"^7","org.clojure/spec.alpha"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.143\""],"^7","\"0.1.143\""]],"^7","[org.clojure/spec.alpha \"0.1.143\"]"]],"^7","#{[org.clojure/core.specs.alpha \"0.1.24\"] [org.clojure/spec.alpha \"0.1.143\"]}"]],"^7","[[org.clojure/clojure \"1.9.0\"] #{[org.clojure/core.specs.alpha \"0.1.24\"] [org.clojure/spec.alpha \"0.1.143\"]}]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"clj-wallhack"],"^7","clj-wallhack"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"1.0.1\""],"^7","\"1.0.1\""]],"^7","[clj-wallhack \"1.0.1\"]"],["^ ","^0","html","^6",["span",["^ ","^2","clj-nil"],"nil"],"^7","nil"]],"^7","[[clj-wallhack \"1.0.1\"] nil]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"clj-tuple"],"^7","clj-tuple"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.2.2\""],"^7","\"0.2.2\""]],"^7","[clj-tuple \"0.2.2\"]"],["^ ","^0","html","^6",["span",["^ ","^2","clj-nil"],"nil"],"^7","nil"]],"^7","[[clj-tuple \"0.2.2\"] nil]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.zeromq/jeromq"],"^7","org.zeromq/jeromq"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.4.3\""],"^7","\"0.4.3\""]],"^7","[org.zeromq/jeromq \"0.4.3\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-set"],"#{"],"^3",["span",["^ ","^2","clj-set"],"}"],"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.zeromq/jnacl"],"^7","org.zeromq/jnacl"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.0\""],"^7","\"0.1.0\""]],"^7","[org.zeromq/jnacl \"0.1.0\"]"]],"^7","#{[org.zeromq/jnacl \"0.1.0\"]}"]],"^7","[[org.zeromq/jeromq \"0.4.3\"] #{[org.zeromq/jnacl \"0.1.0\"]}]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"adzerk/boot-test"],"^7","adzerk/boot-test"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"1.2.0\""],"^7","\"1.2.0\""]],"^7","[adzerk/boot-test \"1.2.0\"]"],["^ ","^0","html","^6",["span",["^ ","^2","clj-nil"],"nil"],"^7","nil"]],"^7","[[adzerk/boot-test \"1.2.0\"] nil]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.clojure/core.specs.alpha"],"^7","org.clojure/core.specs.alpha"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.24\""],"^7","\"0.1.24\""]],"^7","[org.clojure/core.specs.alpha \"0.1.24\"]"],["^ ","^0","html","^6",["span",["^ ","^2","clj-nil"],"nil"],"^7","nil"]],"^7","[[org.clojure/core.specs.alpha \"0.1.24\"] nil]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"io.djy/ezzmq"],"^7","io.djy/ezzmq"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.8.2\""],"^7","\"0.8.2\""]],"^7","[io.djy/ezzmq \"0.8.2\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-set"],"#{"],"^3",["span",["^ ","^2","clj-set"],"}"],"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.clojure/clojure"],"^7","org.clojure/clojure"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"1.9.0\""],"^7","\"1.9.0\""]],"^7","[org.clojure/clojure \"1.9.0\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"clj-wallhack"],"^7","clj-wallhack"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"1.0.1\""],"^7","\"1.0.1\""]],"^7","[clj-wallhack \"1.0.1\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.zeromq/jeromq"],"^7","org.zeromq/jeromq"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.4.3\""],"^7","\"0.4.3\""]],"^7","[org.zeromq/jeromq \"0.4.3\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"adzerk/boot-test"],"^7","adzerk/boot-test"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"1.2.0\""],"^7","\"1.2.0\""]],"^7","[adzerk/boot-test \"1.2.0\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"potemkin"],"^7","potemkin"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.4.5\""],"^7","\"0.4.5\""]],"^7","[potemkin \"0.4.5\"]"]],"^7","#{[org.clojure/clojure \"1.9.0\"] [clj-wallhack \"1.0.1\"] [org.zeromq/jeromq \"0.4.3\"] [adzerk/boot-test \"1.2.0\"] [potemkin \"0.4.5\"]}"]],"^7","[[io.djy/ezzmq \"0.8.2\"] #{[org.clojure/clojure \"1.9.0\"] [clj-wallhack \"1.0.1\"] [org.zeromq/jeromq \"0.4.3\"] [adzerk/boot-test \"1.2.0\"] [potemkin \"0.4.5\"]}]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"potemkin"],"^7","potemkin"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.4.5\""],"^7","\"0.4.5\""]],"^7","[potemkin \"0.4.5\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-set"],"#{"],"^3",["span",["^ ","^2","clj-set"],"}"],"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"clj-tuple"],"^7","clj-tuple"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.2.2\""],"^7","\"0.2.2\""]],"^7","[clj-tuple \"0.2.2\"]"],["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"riddley"],"^7","riddley"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.12\""],"^7","\"0.1.12\""]],"^7","[riddley \"0.1.12\"]"]],"^7","#{[clj-tuple \"0.2.2\"] [riddley \"0.1.12\"]}"]],"^7","[[potemkin \"0.4.5\"] #{[clj-tuple \"0.2.2\"] [riddley \"0.1.12\"]}]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"riddley"],"^7","riddley"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.12\""],"^7","\"0.1.12\""]],"^7","[riddley \"0.1.12\"]"],["^ ","^0","html","^6",["span",["^ ","^2","clj-nil"],"nil"],"^7","nil"]],"^7","[[riddley \"0.1.12\"] nil]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.zeromq/jnacl"],"^7","org.zeromq/jnacl"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.0\""],"^7","\"0.1.0\""]],"^7","[org.zeromq/jnacl \"0.1.0\"]"],["^ ","^0","html","^6",["span",["^ ","^2","clj-nil"],"nil"],"^7","nil"]],"^7","[[org.zeromq/jnacl \"0.1.0\"] nil]"],["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","list-like","^1",["span",["^ ","^2","clj-vector"],"["],"^3",["span",["^ ","^2","clj-vector"],"]"],"^4",["span"," "],"^5",[["^ ","^0","html","^6",["span",["^ ","^2","clj-symbol"],"org.clojure/spec.alpha"],"^7","org.clojure/spec.alpha"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"0.1.143\""],"^7","\"0.1.143\""]],"^7","[org.clojure/spec.alpha \"0.1.143\"]"],["^ ","^0","html","^6",["span",["^ ","^2","clj-nil"],"nil"],"^7","nil"]],"^7","[[org.clojure/spec.alpha \"0.1.143\"] nil]"]],"^7","{[org.clojure/clojure \"1.9.0\"] #{[org.clojure/core.specs.alpha \"0.1.24\"] [org.clojure/spec.alpha \"0.1.143\"]}, [clj-wallhack \"1.0.1\"] nil, [clj-tuple \"0.2.2\"] nil, [org.zeromq/jeromq \"0.4.3\"] #{[org.zeromq/jnacl \"0.1.0\"]}, [adzerk/boot-test \"1.2.0\"] nil, [org.clojure/core.specs.alpha \"0.1.24\"] nil, [io.djy/ezzmq \"0.8.2\"] #{[org.clojure/clojure \"1.9.0\"] [clj-wallhack \"1.0.1\"] [org.zeromq/jeromq \"0.4.3\"] [adzerk/boot-test \"1.2.0\"] [potemkin \"0.4.5\"]}, [potemkin \"0.4.5\"] #{[clj-tuple \"0.2.2\"] [riddley \"0.1.12\"]}, [riddley \"0.1.12\"] nil, [org.zeromq/jnacl \"0.1.0\"] nil, [org.clojure/spec.alpha \"0.1.143\"] nil}"]
;; <=

;; @@
(ns zeromq-playground
  (:require 
    [pinkgorilla.ui.hiccup :refer [html!]] 
    [pinkgorilla.ui.vega :refer [vega!]] 
    [pinkgorilla.ui.gorilla-plot.core :refer [list-plot bar-chart compose histogram plot]] 
    [ezzmq.core :as zmq]))
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(html! 
  [:div [:h1 "0MQ is great"]
        [:img {:src "https://raw.githubusercontent.com/booksbyus/zguide/master/images/fig1.png"}]
        [:p [:a {:href "https://github.com/daveyarwood/ezzmq"} "ezzmq is an amazing library"]]
        [:p [:a {:href "https://zeromq.org/get-started/"} "zero mq get started is cool"]]])      
;; @@
;; =>
;;; ["^ ","~:type","html","~:content","<div><h1>0MQ is great</h1><img src=\"https://raw.githubusercontent.com/booksbyus/zguide/master/images/fig1.png\" /><p><a href=\"https://github.com/daveyarwood/ezzmq\">ezzmq is an amazing library</a></p><p><a href=\"https://zeromq.org/get-started/\">zero mq get started is cool</a></p></div>"]
;; <=

;; @@
(html! [:div 
        [:h1 "Let's create a ping server"]
        [:ul 
         [:li "Create a ping server that binds to localhost:4321"]
         [:li "Since the Repl may not forget about the server, we need to define a symbol \"ping-server\" (otherwise the repl will just shutdown the server as soon as eval is finished)"]
         [:li "The future is necessary, as otherwise the repl would just be blocking (and notebook stops working)"]]]) 

;; @@
;; =>
;;; ["^ ","~:type","html","~:content","<div><h1>Let's create a ping server</h1><ul><li>Create a ping server that binds to localhost:4321</li><li>Since the Repl may not forget about the server, we need to define a symbol \"ping-server\" (otherwise the repl will just shutdown the server as soon as eval is finished)</li><li>The future is necessary, as otherwise the repl would just be blocking (and notebook stops working)</li></ul></div>"]
;; <=

;; @@
(def ping-server
  (future 
    (zmq/with-new-context
      (let [socket (zmq/socket :rep {:bind "tcp://127.0.0.1:4321"})]
        (while true 
          (let [msg (zmq/receive-msg socket)]
            (println "RCVD ping.")
            (zmq/send-msg socket "pong")))))))

;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-var"],"#'zeromq-playground/ping-server"],"~:value","#'zeromq-playground/ping-server"]
;; <=

;; **
;;; # Lets Ping the server
;; **

;; @@
(zmq/with-new-context
  (let [socket (zmq/socket :req {:connect "tcp://127.0.0.1:4321"})]
      (zmq/send-msg socket "ping")
      (let [rmsg (zmq/receive-msg socket {:stringify true})]
        (println "RCVD: " rmsg))))
;; @@
;; ->
;;; RCVD:  [pong]
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; **
;;; # Lets Fuck up the Repl
;;; - Since we are dysclectic we confused 4321 with 1234.
;;; - Therefore there is no listening server, and we will block forever
;; **

;; @@
(zmq/with-new-context
  (let [socket (zmq/socket :req {:connect "tcp://127.0.0.1:1234"})]
      (zmq/send-msg socket "ping")
      (let [rmsg (zmq/receive-msg socket {:stringify true})]
        (println "RCVD: " rmsg))))
;; @@
