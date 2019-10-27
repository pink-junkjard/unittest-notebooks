;; gorilla-repl.fileformat = 2

;; **
;;; # PinkGorilla 
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands.
;;; 
;;; It's a good habit to run each worksheet in its own namespace. We created a random namespace for you; you can keep using it.
;; **

;; @@
(ns fuckup-pprint
  (:require 
     [clojure.pprint]))
;; @@
;; ->
;;; 
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(def data 
  [{:name "william shakespeare" :speciality "novels"}
   {:name "rich hickie" :speciality "clojure"}
   {:name "christian" :speciality "replikativ"}])
;; @@
;; ->
;;; 
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-var"],"#'fuckup-pprint/data"],"~:value","#'fuckup-pprint/data"]
;; <=

;; @@
; this should print multiple rows. but it only shows the last row.
(clojure.pprint/print-table data)
;; @@
;; ->
;;; |           christian |  replikativ |
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
; with-out-str redirects the stdout and returns stdout as a string
; 
(with-out-str (clojure.pprint/print-table data))
;; @@
;; ->
;;; 
;;; |               :name | :speciality |
;;; |---------------------+-------------|
;;; | william shakespeare |      novels |
;;; |         rich hickie |     clojure |
;;; |           christian |  replikativ |
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(printf (with-out-str (clojure.pprint/print-table data)))
;; @@
;; ->
;;; 
;;; |               :name | :speciality |
;;; |---------------------+-------------|
;;; | william shakespeare |      novels |
;;; |         rich hickie |     clojure |
;;; |           christian |  replikativ |
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(print (clojure.string/replace (with-out-str (clojure.pprint/print-table data)) #"\n" "\r\n"))
;; @@
;; ->
;;; 
;;; |               :name | :speciality |
;;; |---------------------+-------------|
;;; | william shakespeare |      novels |
;;; |         rich hickie |     clojure |
;;; |           christian |  replikativ |
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@

;; @@
