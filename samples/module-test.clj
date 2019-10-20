;; gorilla-repl.fileformat = 2

;; **
;;; # Module-Test
;;; 
;;; Custom UI Modules normally include Javascript Modules.
;;; The Test module defines a Javascript Module that renders data via javascript as json to a cell dom node.
;; **

;; @@
(ns juicy-winds
  (:require 
    [pinkgorilla.ui.module-test :refer [test!]]
    [pinkgorilla.ui.hiccup :refer [html!]]))
;; @@
;; ->
;;; 
;; <-
;; =>
;;; ["^ ","~:type","html","~:content",["span",["^ ","~:class","clj-nil"],"nil"],"~:value","nil"]
;; <=

;; @@
(test! {:bongo 1 :message "hello, world, again"})
;; @@
;; =>
;;; ["^ ","~:type","jsscript","~:content",["^ ","~:data",["^ ","~:bongo",1,"~:message","hello, world, again"],"~:module","\n  define([], function () {\n      return {\n         version: 'module-test 0.0.2',\n         render: function (id_or_domel, data) {\n            var domElement = id_or_domel;\n            if (typeof id_or_domel === 'string' || id_or_domel instanceof String) {\n               selector = '#'+ id_or_domel;\n               console.log ('module-test is rendering to selector: ' + selector);\n               domElement = document.getElementById (selector); \n            } else {\n               console.log ('module-test is rendering to dom-element');\n            }\n\n            var dataJson = JSON.stringify(data)\n            console.log ('module-test data: ' + dataJson);\n\n            var p = document.createElement ('p');\n            var json = JSON.stringify (data);\n            var textnode = document.createTextNode (dataJson);  \n            //var textnode = document.createTextNode ('module-test rocks');  \n            p.appendChild (textnode);\n            domElement.appendChild (p);\n         }\n      }\n  });\n"]]
;; <=

;; @@
(html! [:h1 "hi"])
;; @@
;; ->
;;; 
;; <-
;; =>
;;; ["^ ","~:type","html","~:content","<h1>hi</h1>"]
;; <=

;; @@

;; @@
;; ->
;;; 
;; <-
