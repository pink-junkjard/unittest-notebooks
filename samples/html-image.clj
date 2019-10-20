;; gorilla-repl.fileformat = 2

;; **
;;;  # html image test
;;; 
;;; This test explores how custom-html can be rendered in gorilla
;; **

;; @@
;(use '[gorilla-repl table latex html])
(use '[pinkgorilla.ui.gorilla-renderable :refer :all])
(use '[pinkgorilla.ui.hickup :refer [html!]])
;(use 'hiccup.core)
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(defrecord Image [url])
(defn image 
  [url]
  (html! [:img {:src url :height 100 :width 100 :alt "it's an image"}]))
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-var"],"#'demo-html/image"],"~:value","#'demo-html/image"]
;; <=

;; @@
(extend-type Image
  Renderable
  (render [self]
          {:type :html
           :content (image (:url self))
           :value (pr-str self)}))
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(Image. "https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg")
;(Image. "https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg")
;; @@
;; =>
;;; ["^ ","~:type","list-like","~:open",["span",["^ ","~:class","clj-record"],"#demo_html.Image{"],"~:close",["span",["^ ","^2","clj-record"],"}"],"~:separator",["span"," "],"~:items",[["^ ","^0","list-like","^1",null,"^3",null,"^4",["span"," "],"^5",[["^ ","^0","html","~:content",["span",["^ ","^2","clj-keyword"],":url"],"~:value",":url"],["^ ","^0","html","^6",["span",["^ ","^2","clj-string"],"\"https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg\""],"^7","\"https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg\""]],"^7","[:url \"https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg\"]"]],"^7","#demo_html.Image{:url \"https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg\"}"]
;; <=

;; @@
(println (image "https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg"))
;; @@
;; ->
;;; #object[pinkgorilla.ui.hickup$html_BANG_$reify__102501 0x4979c60e pinkgorilla.ui.hickup$html_BANG_$reify__102501@4979c60e]
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@

;; @@
;; ->
;;; 
;; <-
