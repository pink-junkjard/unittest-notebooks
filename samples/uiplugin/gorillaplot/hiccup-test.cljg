;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-) Shift + enter evaluates code. Poke the question mark (top right) to learn more ...
;; **

;; @@
(use '[hiccup.core :as hiccup])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn circ
  [c]
  (hiccup/html [:svg {:height 100 :width 100}
                [:circle {:cx 50 :cy 50 :r 40 :stroke "black" :stroke-width 4 :fill c}]]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/circ</span>","value":"#'user/circ"}
;; <=

;; @@
(html (circ "red"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;&lt;svg height=\\&quot;100\\&quot; width=\\&quot;100\\&quot;&gt;&lt;circle cx=\\&quot;50\\&quot; cy=\\&quot;50\\&quot; fill=\\&quot;red\\&quot; r=\\&quot;40\\&quot; stroke-width=\\&quot;4\\&quot; stroke=\\&quot;black\\&quot;&gt;&lt;/circle&gt;&lt;/svg&gt;&quot;</span>","value":"\"<svg height=\\\"100\\\" width=\\\"100\\\"><circle cx=\\\"50\\\" cy=\\\"50\\\" fill=\\\"red\\\" r=\\\"40\\\" stroke-width=\\\"4\\\" stroke=\\\"black\\\"></circle></svg>\""}
;; <=

;; @@
(circ "red")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;&lt;svg height=\\&quot;100\\&quot; width=\\&quot;100\\&quot;&gt;&lt;circle cx=\\&quot;50\\&quot; cy=\\&quot;50\\&quot; fill=\\&quot;red\\&quot; r=\\&quot;40\\&quot; stroke-width=\\&quot;4\\&quot; stroke=\\&quot;black\\&quot;&gt;&lt;/circle&gt;&lt;/svg&gt;&quot;</span>","value":"\"<svg height=\\\"100\\\" width=\\\"100\\\"><circle cx=\\\"50\\\" cy=\\\"50\\\" fill=\\\"red\\\" r=\\\"40\\\" stroke-width=\\\"4\\\" stroke=\\\"black\\\"></circle></svg>\""}
;; <=

;; @@

;; @@
