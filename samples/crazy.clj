;; gorilla-repl.fileformat = 2

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns juicy-winds
  (:require [pinkgorilla.ui.vega :refer [vega!]]
            [pinkgorilla.ui.hickup :refer [html!]]))
            
            
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(vega! {:bongo 1})
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-unkown"],"#object[pinkgorilla.ui.vega$vega_BANG_$reify__102290 0x1fa3ed03 \"pinkgorilla.ui.vega$vega_BANG_$reify__102290@1fa3ed03\"]"],"~:value","#object[pinkgorilla.ui.vega$vega_BANG_$reify__102290 0x1fa3ed03 \"pinkgorilla.ui.vega$vega_BANG_$reify__102290@1fa3ed03\"]"]
;; <=

;; @@
(html! [:h1 "hi"])
;; @@
;; =>
;;; ["^ ","~:type","html","~:content","<h1>hi</h1>"]
;; <=

;; @@

;; @@
