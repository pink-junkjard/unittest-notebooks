;; gorilla-repl.fileformat = 2

;; **
;;; # HighChart.JS demo
;; **

;; @@
(ns juicy-winds
  (:require [pinkgorilla.ui.vega :refer [vega!]]
            [pinkgorilla.ui.highcharts :refer [highchart!]]
            [pinkgorilla.ui.hiccup :refer [html!]]))
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(defn make-chart-config [data]
  {:chart {:type "line"
           :animation false}
   :title {:text (:title data)}
   :subtitle {:text (:subtitle data)}
   :yAxis {:min 0
           :title {:text ""
                   :align "high"}}
               ;:labels {:overflow "justify"}
             
   :xAxis {:categories (:labels data)}
   :tooltip {:valueSuffix " %"}
   :plotOptions
     {:series
        {:animation 0
         :label
           {;:pointStart 2010
            :connectorAllowed false}}}
   :legend
     {;:x -40
      ;:y 100
      ;:floating true
      ;:borderWidth 1
      ;:shadow true
      :layout "vertical"
      :align "right"
      :verticalAlign "top"}
    :credits {:enabled false}
    :series (:series data)})
       
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-var"],"#'juicy-winds/make-chart-config"],"~:value","#'juicy-winds/make-chart-config"]
;; <=

;; @@
 (def highchart-spec 
   (make-chart-config 
    {:title "Economic Activity"
     :subtitle "made with Love"
     :labels ["Jan" "Feb" "Mar" "Apr" "May" "Jun" "Jul" "Aug"]
     :series 
     [{:name "Installation" :data [439 523 577 698 931 1131 1333 1175]}
      {:name "Manufacturing" :data [249 244 292 291 390 302 381 404]}
      {:name "Sales & Distribution" :data [117 172 165 191 285 247 321 393]}]}))      
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-var"],"#'juicy-winds/highchart-spec"],"~:value","#'juicy-winds/highchart-spec"]
;; <=

;; @@
(highchart! highchart-spec)
;; @@
;; =>
;;; ["^ ","~:type","jsscript","~:content",["^ ","~:data",["^ ","~:series",[["^ ","~:name","Installation","^2",[439,523,577,698,931,1131,1333,1175]],["^ ","^4","Manufacturing","^2",[249,244,292,291,390,302,381,404]],["^ ","^4","Sales & Distribution","^2",[117,172,165,191,285,247,321,393]]],"~:legend",["^ ","~:layout","vertical","~:align","right","~:verticalAlign","top"],"~:plotOptions",["^ ","^3",["^ ","~:animation",0,"~:label",["^ ","~:connectorAllowed",false]]],"~:title",["^ ","~:text","Economic Activity"],"~:chart",["^ ","^0","line","^:",false],"~:yAxis",["^ ","~:min",0,"^=",["^ ","^>","","^7","high"]],"~:credits",["^ ","~:enabled",false],"~:subtitle",["^ ","^>","made with Love"],"~:xAxis",["^ ","~:categories",["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"]],"~:tooltip",["^ ","~:valueSuffix"," %"]],"~:module","\n  define([], function () {\n      return {\n         render: function (id_or_domel, data) {\n            var domElement = id_or_domel;\n            if (typeof id_or_domel === 'string' || id_or_domel instanceof String) {\n               selector = '#'+ id_or_domel;\n               console.log ('module-test is rendering to selector: ' + selector);\n               domElement = document.getElementById (id); \n            } else {\n               console.log ('module-test is rendering to dom-element');\n            }\n\n            var dataJson = JSON.stringify(data)\n            console.log ('module-test data: ' + dataJson);\n\n            var p = document.createElement ('p');\n            var json = JSON.stringify (data);\n            var textnode = document.createTextNode (dataJson);  \n            //var textnode = document.createTextNode ('module-test rocks');  \n            p.appendChild (textnode);\n            domElement.appendChild (p);\n         }\n      }\n  });\n"]]
;; <=

;; @@

;; @@
