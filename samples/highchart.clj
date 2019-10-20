;; gorilla-repl.fileformat = 2

;; **
;;; # HighChart.JS demo
;; **

;; @@
(ns juicy-winds
  (:require [pinkgorilla.ui.highcharts :refer [highchart! module]]))
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
;;; ["^ ","~:type","jsscript","~:content",["^ ","~:data",["^ ","~:series",[["^ ","~:name","Installation","^2",[439,523,577,698,931,1131,1333,1175]],["^ ","^4","Manufacturing","^2",[249,244,292,291,390,302,381,404]],["^ ","^4","Sales & Distribution","^2",[117,172,165,191,285,247,321,393]]],"~:legend",["^ ","~:layout","vertical","~:align","right","~:verticalAlign","top"],"~:plotOptions",["^ ","^3",["^ ","~:animation",0,"~:label",["^ ","~:connectorAllowed",false]]],"~:title",["^ ","~:text","Economic Activity"],"~:chart",["^ ","^0","line","^:",false],"~:yAxis",["^ ","~:min",0,"^=",["^ ","^>","","^7","high"]],"~:credits",["^ ","~:enabled",false],"~:subtitle",["^ ","^>","made with Love"],"~:xAxis",["^ ","~:categories",["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"]],"~:tooltip",["^ ","~:valueSuffix"," %"]],"~:module","\n  define([], function () {\n      return {\n         version: 'highcharts 0.0.2',\n         render: function (id_or_domel, data) {\n            var selector_or_domel = id_or_domel;\n            if (typeof id_or_domel === 'string' || id_or_domel instanceof String) {\n               selector_or_domel = '#'+ id_or_domel;\n               console.log ('highcharts-module is rendering to selector id: ' + selector_or_domel);\n            } else {\n               console.log ('highcharts-module is rendering to dom-element');\n            }\n            var dataJson = JSON.stringify(data)\n            console.log ('highcharts-module data: ' + dataJson);\n            require(['highcharts'], function(highcharts) {\n              new highcharts.Chart (selector_or_domel, data, {defaultStyle:true}).catch(console.warn);\n              }, function(err) {\n                console.log('Failed to load');\n            });\n         }\n      }\n  });\n"]]
;; <=

;; @@
;; Show the Source code of the Javascript Module.
module
;; @@
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-string"],"\"\\n  define([], function () {\\n      return {\\n         version: 'highcharts 0.0.2',\\n         render: function (id_or_domel, data) {\\n            var selector_or_domel = id_or_domel;\\n            if (typeof id_or_domel === 'string' || id_or_domel instanceof String) {\\n               selector_or_domel = '#'+ id_or_domel;\\n               console.log ('highcharts-module is rendering to selector id: ' + selector_or_domel);\\n            } else {\\n               console.log ('highcharts-module is rendering to dom-element');\\n            }\\n            var dataJson = JSON.stringify(data)\\n            console.log ('highcharts-module data: ' + dataJson);\\n            require(['highcharts'], function(highcharts) {\\n              new highcharts.Chart (selector_or_domel, data, {defaultStyle:true}).catch(console.warn);\\n              }, function(err) {\\n                console.log('Failed to load');\\n            });\\n         }\\n      }\\n  });\\n\""],"~:value","\"\\n  define([], function () {\\n      return {\\n         version: 'highcharts 0.0.2',\\n         render: function (id_or_domel, data) {\\n            var selector_or_domel = id_or_domel;\\n            if (typeof id_or_domel === 'string' || id_or_domel instanceof String) {\\n               selector_or_domel = '#'+ id_or_domel;\\n               console.log ('highcharts-module is rendering to selector id: ' + selector_or_domel);\\n            } else {\\n               console.log ('highcharts-module is rendering to dom-element');\\n            }\\n            var dataJson = JSON.stringify(data)\\n            console.log ('highcharts-module data: ' + dataJson);\\n            require(['highcharts'], function(highcharts) {\\n              new highcharts.Chart (selector_or_domel, data, {defaultStyle:true}).catch(console.warn);\\n              }, function(err) {\\n                console.log('Failed to load');\\n            });\\n         }\\n      }\\n  });\\n\""]
;; <=

;; @@

;; @@
;; ->
;;; 
;; <-
