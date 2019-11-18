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
     [clojure.pprint]
     [pinkgorilla.hacks :refer [print-table]]))
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
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-string"],"\"\\n|               :name | :speciality |\\n|---------------------+-------------|\\n| william shakespeare |      novels |\\n|         rich hickie |     clojure |\\n|           christian |  replikativ |\\n\""],"~:value","\"\\n|               :name | :speciality |\\n|---------------------+-------------|\\n| william shakespeare |      novels |\\n|         rich hickie |     clojure |\\n|           christian |  replikativ |\\n\""]
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
; hack in pinkgorilla.hacks
(print-table data)
;; @@
;; =>
;;; ["^ ","~:type","html","~:content","<div gorilla-ui=\"text\"><div><span></span><br /></div><div><span>|               :name | :speciality |</span><br /></div><div><span>|---------------------+-------------|</span><br /></div><div><span>| william shakespeare |      novels |</span><br /></div><div><span>|         rich hickie |     clojure |</span><br /></div><div><span>|           christian |  replikativ |</span><br /></div></div>"]
;; <=

;; @@
; hack in pinkgorilla.hacks
(print-table [:name] data)
;; @@
;; =>
;;; ["^ ","~:type","html","~:content","<div gorilla-ui=\"text\"><div><span></span><br /></div><div><span>|               :name |</span><br /></div><div><span>|---------------------|</span><br /></div><div><span>| william shakespeare |</span><br /></div><div><span>|         rich hickie |</span><br /></div><div><span>|           christian |</span><br /></div></div>"]
;; <=

;; @@
; Note that the doc function currently also does not render correct, as it skips the header
(clojure.repl/doc clojure.pprint/print-table)
;; @@
;; ->
;;;   Prints a collection of maps in a textual table. Prints table headings
;;;    ks, and then a line of output for each row, corresponding to the keys
;;;    in ks. If ks are not specified, use the keys of the first item in rows.
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@

;; @@
