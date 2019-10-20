;; gorilla-repl.fileformat = 2

;; **
;;; # Image-Safe
;; **

;; @@
(ns demo.image
  (:require [pinkgorilla.helper :refer [add-dependencies]]))
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; **
;;; Load gorilla-renderable dependency and use it.
;; **

;; @@
(add-dependencies '[pinkgorilla.ui.gorilla-renderable "2.0.7"])
(use 'pinkgorilla.ui.gorilla-renderable)
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(defrecord Image [url])
(defn image 
  [url]
  [:img {:src url :height 100 :width 100 :alt "it's an image"}])
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-var"],"#'demo.image/image"],"~:value","#'demo.image/image"]
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
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["img",["^ ","~:src","https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg","~:height",100,"~:width",100,"~:alt","it's an image"]],"~:value","#demo.image.Image{:url \"https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg\"}"]
;; <=

;; @@
(Image. "https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg")
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["img",["^ ","~:src","https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg","~:height",100,"~:width",100,"~:alt","it's an image"]],"~:value","#demo.image.Image{:url \"https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg\"}"]
;; <=

;; @@
(table-view
    [
      ["moon" (Image. "https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg")]
      ["sun" (Image. "https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg")]]
     
  :columns [ "planet" "image"])
;; @@

;; @@

;; @@
;; ->
;;; 
;; <-
