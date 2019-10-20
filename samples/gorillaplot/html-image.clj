;; gorilla-repl.fileformat = 1

;; **
;;;  # html image test
;;; 
;;; This test explores how custom-html can be rendered in gorilla
;; **

;; @@
(use '[gorilla-repl table latex html])
(use 'gorilla-renderable.core)
(use 'hiccup.core)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defrecord Image [url])
(defn image 
  [url]
  (html [:img {:src url :height 100 :width 100 :alt "it's an image"}]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;gorilla-vega/image</span>","value":"#'gorilla-vega/image"}
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
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(Image. "https://cdn.mos.cms.futurecdn.net/yyvvM9kwaVGySFE6aXXoJL-320-80.jpg")
(Image. "https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg")
;; @@
;; =>
;;; {"type":"html","content":"<img alt=\"it&apos;s an image\" height=\"100\" src=\"https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg\" width=\"100\" />","value":"#gorilla_vega.Image{:url \"https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg\"}"}
;; <=

;; @@
(println (image "https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg"))
;; @@
;; ->
;;; &lt;img alt=&quot;it&amp;apos;s an image&quot; height=&quot;100&quot; src=&quot;https://pbs.twimg.com/profile_images/641353910561566720/VSxsyxs7.jpg&quot; width=&quot;100&quot; /&gt;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
