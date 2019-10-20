;; gorilla-repl.fileformat = 1

;; **
;;; # html vega test
;;; 
;;; This test explores how VEGA charts can be rendered in gorilla
;;; 
;;; Stolen from: https://github.com/metasoarous/oz/blob/master/src/clj/oz/notebook/clojupyter.clj
;;; 
;; **

;; @@
(ns vega-test
  (:require
   [gorilla-renderable.core]
   [gorilla-repl table html]
   [hiccup.core :as hiccup]
   [clojure.data.json :as json]))
(use '[gorilla-repl table latex html])
(use 'gorilla-renderable.core)
;(use 'hiccup.core :as hiccup)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def require-string
  "
<div>
  <script data-main='scripts/main' src='https://cdnjs.cloudflare.com/ajax/libs/require.js/2.3.6/require.min.js'>     </script>

  <div id='uuid-%s'></div>
  <script>
  requirejs.config({
    baseUrl: 'https://cdn.jsdelivr.net/npm/',
    paths: {
      'vega-embed':  'vega-embed@3?noext',
      'vega-lib': 'vega-lib?noext',
      'vega-lite': 'vega-lite@2?noext',
      'vega': 'vega@3?noext'
    }
  });
  require(['vega-embed'], function(vegaEmbed) {
    let spec = %s;
    vegaEmbed('#uuid-%s', spec, {defaultStyle:true}).catch(console.warn);
    }, function(err) {
    console.log('Failed to load');
  });
  </script>
</div>
  ")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;vega-test/require-string</span>","value":"#'vega-test/require-string"}
;; <=

;; @@
(defn- uuid [] (str (java.util.UUID/randomUUID)))

(defn- live-embed [v]
  (let [id (uuid)]
    (format require-string id (json/write-str v) id)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;vega-test/live-embed</span>","value":"#'vega-test/live-embed"}
;; <=

;; @@
(defn ^:no-doc embed
  "Take hiccup or vega/lite spec and embed the vega/lite portions using vegaEmbed, as hiccup :div and :script blocks.
  When rendered, should present as live html page; Currently semi-private, may be made fully public in future."
  ([spec {:as opts :keys [embed-fn] :or {embed-fn live-embed}}]
   ;; prewalk spec, rendering special hiccup tags like :vega and :vega-lite, and potentially other composites,
   ;; rendering using the components above. Leave regular hiccup unchanged).
   ;; TODO finish writing; already hooked in below so will break now
   (if (map? spec)
     (embed-fn spec)
     (clojure.walk/prewalk
       (fn [x] (if (and (coll? x) (#{:vega :vega-lite} (first x)))
                 (embed-fn (second x))
                 x))
       spec)))
  ([spec]
   (embed spec {})))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;vega-test/embed</span>","value":"#'vega-test/embed"}
;; <=

;; @@
(defrecord Mega [specs])
(extend-type Mega
  Renderable
  (render [self]
          {:type :html
           :content (embed (:specs self))
           :value (pr-str self)}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def sample-chart {
  :$schema "https://vega.github.io/schema/vega-lite/v4.json"
  :description "A simple bar chart with embedded data."
  :data {
    :values [
      {:a "A" :b 28} {:a "B" :b 55} {:a "C" :b 43}{:a "D" :b 91} {:a "E" :b 81} {:a "F" :b 53}
      {:a "G" :b 19} {:a "H" :b 87} {:a "I" :b 52} {:a "J" :b 127}
    ]
  }
  :mark "bar",
  :encoding {
    :x {:field "a" :type "ordinal"}
    :y {:field "b" :type "quantitative"}
  }
})

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;vega-test/sample-chart</span>","value":"#'vega-test/sample-chart"}
;; <=

;; @@
(Mega. sample-chart)(Mega. sample-chart)

;; @@
;; =>
;;; {"type":"html","content":"\n<div>\n  <script data-main='scripts/main' src='https://cdnjs.cloudflare.com/ajax/libs/require.js/2.3.6/require.min.js'>     </script>\n\n  <div id='uuid-91423241-acc9-4fc4-9b10-a50b48c37c77'></div>\n  <script>\n  requirejs.config({\n    baseUrl: 'https://cdn.jsdelivr.net/npm/',\n    paths: {\n      'vega-embed':  'vega-embed@3?noext',\n      'vega-lib': 'vega-lib?noext',\n      'vega-lite': 'vega-lite@2?noext',\n      'vega': 'vega@3?noext'\n    }\n  });\n  require(['vega-embed'], function(vegaEmbed) {\n    let spec = {\"$schema\":\"https:\\/\\/vega.github.io\\/schema\\/vega-lite\\/v4.json\",\"description\":\"A simple bar chart with embedded data.\",\"data\":{\"values\":[{\"a\":\"A\",\"b\":28},{\"a\":\"B\",\"b\":55},{\"a\":\"C\",\"b\":43},{\"a\":\"D\",\"b\":91},{\"a\":\"E\",\"b\":81},{\"a\":\"F\",\"b\":53},{\"a\":\"G\",\"b\":19},{\"a\":\"H\",\"b\":87},{\"a\":\"I\",\"b\":52},{\"a\":\"J\",\"b\":127}]},\"mark\":\"bar\",\"encoding\":{\"x\":{\"field\":\"a\",\"type\":\"ordinal\"},\"y\":{\"field\":\"b\",\"type\":\"quantitative\"}}};\n    vegaEmbed('#uuid-91423241-acc9-4fc4-9b10-a50b48c37c77', spec, {defaultStyle:true}).catch(console.warn);\n    }, function(err) {\n    console.log('Failed to load');\n  });\n  </script>\n</div>\n  ","value":"#vega_test.Mega{:specs {:$schema \"https://vega.github.io/schema/vega-lite/v4.json\", :description \"A simple bar chart with embedded data.\", :data {:values [{:a \"A\", :b 28} {:a \"B\", :b 55} {:a \"C\", :b 43} {:a \"D\", :b 91} {:a \"E\", :b 81} {:a \"F\", :b 53} {:a \"G\", :b 19} {:a \"H\", :b 87} {:a \"I\", :b 52} {:a \"J\", :b 127}]}, :mark \"bar\", :encoding {:x {:field \"a\", :type \"ordinal\"}, :y {:field \"b\", :type \"quantitative\"}}}}"}
;; <=

;; @@
(println (embed sample-chart))
;; @@
;; ->
;;; 
;;; &lt;div&gt;
;;;   &lt;script data-main=&#x27;scripts/main&#x27; src=&#x27;https://cdnjs.cloudflare.com/ajax/libs/require.js/2.3.6/require.min.js&#x27;&gt;     &lt;/script&gt;
;;; 
;;;   &lt;div id=&#x27;uuid-2278153d-3902-4e3b-92d8-71dbc23c43fd&#x27;&gt;&lt;/div&gt;
;;;   &lt;script&gt;
;;;   requirejs.config({
;;;     baseUrl: &#x27;https://cdn.jsdelivr.net/npm/&#x27;,
;;;     paths: {
;;;       &#x27;vega-embed&#x27;:  &#x27;vega-embed@3?noext&#x27;,
;;;       &#x27;vega-lib&#x27;: &#x27;vega-lib?noext&#x27;,
;;;       &#x27;vega-lite&#x27;: &#x27;vega-lite@2?noext&#x27;,
;;;       &#x27;vega&#x27;: &#x27;vega@3?noext&#x27;
;;;     }
;;;   });
;;;   require([&#x27;vega-embed&#x27;], function(vegaEmbed) {
;;;     let spec = {&quot;$schema&quot;:&quot;https:\/\/vega.github.io\/schema\/vega-lite\/v4.json&quot;,&quot;description&quot;:&quot;A simple bar chart with embedded data.&quot;,&quot;data&quot;:{&quot;values&quot;:[{&quot;a&quot;:&quot;A&quot;,&quot;b&quot;:28},{&quot;a&quot;:&quot;B&quot;,&quot;b&quot;:55},{&quot;a&quot;:&quot;C&quot;,&quot;b&quot;:43},{&quot;a&quot;:&quot;D&quot;,&quot;b&quot;:91},{&quot;a&quot;:&quot;E&quot;,&quot;b&quot;:81},{&quot;a&quot;:&quot;F&quot;,&quot;b&quot;:53},{&quot;a&quot;:&quot;G&quot;,&quot;b&quot;:19},{&quot;a&quot;:&quot;H&quot;,&quot;b&quot;:87},{&quot;a&quot;:&quot;I&quot;,&quot;b&quot;:52},{&quot;a&quot;:&quot;J&quot;,&quot;b&quot;:127}]},&quot;mark&quot;:&quot;bar&quot;,&quot;encoding&quot;:{&quot;x&quot;:{&quot;field&quot;:&quot;a&quot;,&quot;type&quot;:&quot;ordinal&quot;},&quot;y&quot;:{&quot;field&quot;:&quot;b&quot;,&quot;type&quot;:&quot;quantitative&quot;}}};
;;;     vegaEmbed(&#x27;#uuid-2278153d-3902-4e3b-92d8-71dbc23c43fd&#x27;, spec, {defaultStyle:true}).catch(console.warn);
;;;     }, function(err) {
;;;     console.log(&#x27;Failed to load&#x27;);
;;;   });
;;;   &lt;/script&gt;
;;; &lt;/div&gt;
;;;   
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defrecord Bongo [id])
(defn bongo [self]
   (str "\n<div \n id='" (:id self)"'> <h1> bongo </h1> </div>"))
(extend-type Bongo
  Renderable
  (render [self]
          {:type :html
           :content (bongo self)
           :value (pr-str self)}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(Bongo. {:id 1})
(println (bongo {:id 1}))

;; @@
;; ->
;;; 
;;; &lt;div 
;;;  id=&#x27;1&#x27;&gt; &lt;h1&gt; bongo &lt;/h1&gt; &lt;/div&gt;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def xxx {
  :$schema "https://vega.github.io/schema/vega/v5.json"
  :width 650
  :height 300
  :padding 5
  :autosize {:type "fit"
             :contains "padding"}
  :signals [
    {
      :name "indexDate"
      :update "time('Jan 1 2005')"
      :on [
        {
          :events "mousemove"
          :update "invert('x', clamp(x(), 0, width))"
        }
      ]
    }
    {
      :name "maxDate"
      :update "time('Mar 1 2010')"
    }
  ]

  :data [
    {
      :name "stocks"
      :url "https://vega.github.io/editor/data/stocks.csv"
      :format {
               :type "csv"
               :parse {:price "number"
                       :date "date"}}
    }
    {
      :name "index"
      :source "stocks"
      :transform [
        {
          :type "filter"
          :expr "month(datum.date) == month(indexDate) && year(datum.date) == year(indexDate)"
        }
      ]
    }
    {
      :name "indexed_stocks"
      :source "stocks"
      :transform [
        {
          :type "lookup" :from "index"  :key "symbol"
          :fields ["symbol"] :as ["index"] :default {:price 0}
        }
        {
          :type "formula"
          :as "indexed_price"
          :expr "datum.index.price > 0 ? (datum.price - datum.index.price)/datum.index.price : 0"
        }
      ]
    }
  ]

  :scales [
    {
      :name "x"
      :type "time"
      :domain {:data "stocks" :field "date"}
      :range "width"
    }
    {
      :name "y"
      :type "linear"
      :domain {:data "indexed_stocks" :field "indexed_price"}
      :nice true :zero true
      :range "height"
    }
    {
      :name "color"
      :type "ordinal"
      :range "category"
      :domain {:data "stocks" :field "symbol"}
    }
  ]

  :axes [
    {:orient "left" :scale "y" :grid true :format "%"}
  ]

  :marks [
    {
      :type "group"
      :from {
        :facet {
          :name "series"
          :data "indexed_stocks"
          :groupby "symbol"
        }
      }
      :data [
        {
          :name "label"
          :source "series"
          :transform [
            {:type "filter" :expr "datum.date == maxDate" }
          ]
        }
      ]
      :marks [
        {
          :type "line"
          :from {:data "series"}
          :encode {
            :update {
              :x {:scale "x" :field "date"}
              :y {:scale "y" :field "indexed_price"}
              :stroke {:scale "color" :field "symbol"}
              :strokeWidth {:value 2}
            }
          }
        }
        {
          :type "text"
          :from {:data "label"}
          :encode {
            :update {
              :x {:scale "x" :field "date" :offset 2}
              :y {:scale "y" :field "indexed_price"}
              :fill {:scale "color" :field "symbol"}
              :text {:field "symbol"}
              :baseline {:value "middle"}
            }
          }
        }
      ]
    }
    {
      :type "rule"
      :encode {
        :update {
          :x {:field {:group "x"}}
          :x2 {:field {:group "width"}}
          :y {:value 0.5 :offset {:scale "y" :value 0 :round true}}
          :stroke {:value "black"}
          :strokeWidth {:value 1}
        }
      }
    }
    {
      :type "rule"
      :encode {
        :update {
          :x {:scale "x" :signal "indexDate" :offset 0.5}
          :y {:value 0}
          :y2 {:field {:group "height"}}
          :stroke {:value "firebrick"}
        }
      }
    }
    {
      :type "text"
      :encode {
        :update {
          :x {:scale "x" :signal "indexDate"}
          :y2 {:field {:group "height"} :offset 15}
          :align {:value "center"}
          :text {:signal "timeFormat(indexDate, '%b %Y')"}
          :fill {:value "firebrick"}
        }
      }
    }
  ]
})

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;vega-test/xxx</span>","value":"#'vega-test/xxx"}
;; <=

;; @@
(Mega. xxx)


;; @@
;; =>
;;; {"type":"html","content":"\n<div>\n  <script data-main='scripts/main' src='https://cdnjs.cloudflare.com/ajax/libs/require.js/2.3.6/require.min.js'>     </script>\n\n  <div id='uuid-319b5912-ff2b-452a-af92-04498bd70e89'></div>\n  <script>\n  requirejs.config({\n    baseUrl: 'https://cdn.jsdelivr.net/npm/',\n    paths: {\n      'vega-embed':  'vega-embed@3?noext',\n      'vega-lib': 'vega-lib?noext',\n      'vega-lite': 'vega-lite@2?noext',\n      'vega': 'vega@3?noext'\n    }\n  });\n  require(['vega-embed'], function(vegaEmbed) {\n    let spec = {\"autosize\":{\"type\":\"fit\",\"contains\":\"padding\"},\"axes\":[{\"orient\":\"left\",\"scale\":\"y\",\"grid\":true,\"format\":\"%\"}],\"width\":650,\"scales\":[{\"name\":\"x\",\"type\":\"time\",\"domain\":{\"data\":\"stocks\",\"field\":\"date\"},\"range\":\"width\"},{\"name\":\"y\",\"type\":\"linear\",\"domain\":{\"data\":\"indexed_stocks\",\"field\":\"indexed_price\"},\"nice\":true,\"zero\":true,\"range\":\"height\"},{\"name\":\"color\",\"type\":\"ordinal\",\"range\":\"category\",\"domain\":{\"data\":\"stocks\",\"field\":\"symbol\"}}],\"padding\":5,\"marks\":[{\"type\":\"group\",\"from\":{\"facet\":{\"name\":\"series\",\"data\":\"indexed_stocks\",\"groupby\":\"symbol\"}},\"data\":[{\"name\":\"label\",\"source\":\"series\",\"transform\":[{\"type\":\"filter\",\"expr\":\"datum.date == maxDate\"}]}],\"marks\":[{\"type\":\"line\",\"from\":{\"data\":\"series\"},\"encode\":{\"update\":{\"x\":{\"scale\":\"x\",\"field\":\"date\"},\"y\":{\"scale\":\"y\",\"field\":\"indexed_price\"},\"stroke\":{\"scale\":\"color\",\"field\":\"symbol\"},\"strokeWidth\":{\"value\":2}}}},{\"type\":\"text\",\"from\":{\"data\":\"label\"},\"encode\":{\"update\":{\"x\":{\"scale\":\"x\",\"field\":\"date\",\"offset\":2},\"y\":{\"scale\":\"y\",\"field\":\"indexed_price\"},\"fill\":{\"scale\":\"color\",\"field\":\"symbol\"},\"text\":{\"field\":\"symbol\"},\"baseline\":{\"value\":\"middle\"}}}}]},{\"type\":\"rule\",\"encode\":{\"update\":{\"x\":{\"field\":{\"group\":\"x\"}},\"x2\":{\"field\":{\"group\":\"width\"}},\"y\":{\"value\":0.5,\"offset\":{\"scale\":\"y\",\"value\":0,\"round\":true}},\"stroke\":{\"value\":\"black\"},\"strokeWidth\":{\"value\":1}}}},{\"type\":\"rule\",\"encode\":{\"update\":{\"x\":{\"scale\":\"x\",\"signal\":\"indexDate\",\"offset\":0.5},\"y\":{\"value\":0},\"y2\":{\"field\":{\"group\":\"height\"}},\"stroke\":{\"value\":\"firebrick\"}}}},{\"type\":\"text\",\"encode\":{\"update\":{\"x\":{\"scale\":\"x\",\"signal\":\"indexDate\"},\"y2\":{\"field\":{\"group\":\"height\"},\"offset\":15},\"align\":{\"value\":\"center\"},\"text\":{\"signal\":\"timeFormat(indexDate, '%b %Y')\"},\"fill\":{\"value\":\"firebrick\"}}}}],\"$schema\":\"https:\\/\\/vega.github.io\\/schema\\/vega\\/v5.json\",\"signals\":[{\"name\":\"indexDate\",\"update\":\"time('Jan 1 2005')\",\"on\":[{\"events\":\"mousemove\",\"update\":\"invert('x', clamp(x(), 0, width))\"}]},{\"name\":\"maxDate\",\"update\":\"time('Mar 1 2010')\"}],\"height\":300,\"data\":[{\"name\":\"stocks\",\"url\":\"https:\\/\\/vega.github.io\\/editor\\/data\\/stocks.csv\",\"format\":{\"type\":\"csv\",\"parse\":{\"price\":\"number\",\"date\":\"date\"}}},{\"name\":\"index\",\"source\":\"stocks\",\"transform\":[{\"type\":\"filter\",\"expr\":\"month(datum.date) == month(indexDate) && year(datum.date) == year(indexDate)\"}]},{\"name\":\"indexed_stocks\",\"source\":\"stocks\",\"transform\":[{\"type\":\"lookup\",\"from\":\"index\",\"key\":\"symbol\",\"fields\":[\"symbol\"],\"as\":[\"index\"],\"default\":{\"price\":0}},{\"type\":\"formula\",\"as\":\"indexed_price\",\"expr\":\"datum.index.price > 0 ? (datum.price - datum.index.price)\\/datum.index.price : 0\"}]}]};\n    vegaEmbed('#uuid-319b5912-ff2b-452a-af92-04498bd70e89', spec, {defaultStyle:true}).catch(console.warn);\n    }, function(err) {\n    console.log('Failed to load');\n  });\n  </script>\n</div>\n  ","value":"#vega_test.Mega{:specs {:autosize {:type \"fit\", :contains \"padding\"}, :axes [{:orient \"left\", :scale \"y\", :grid true, :format \"%\"}], :width 650, :scales [{:name \"x\", :type \"time\", :domain {:data \"stocks\", :field \"date\"}, :range \"width\"} {:name \"y\", :type \"linear\", :domain {:data \"indexed_stocks\", :field \"indexed_price\"}, :nice true, :zero true, :range \"height\"} {:name \"color\", :type \"ordinal\", :range \"category\", :domain {:data \"stocks\", :field \"symbol\"}}], :padding 5, :marks [{:type \"group\", :from {:facet {:name \"series\", :data \"indexed_stocks\", :groupby \"symbol\"}}, :data [{:name \"label\", :source \"series\", :transform [{:type \"filter\", :expr \"datum.date == maxDate\"}]}], :marks [{:type \"line\", :from {:data \"series\"}, :encode {:update {:x {:scale \"x\", :field \"date\"}, :y {:scale \"y\", :field \"indexed_price\"}, :stroke {:scale \"color\", :field \"symbol\"}, :strokeWidth {:value 2}}}} {:type \"text\", :from {:data \"label\"}, :encode {:update {:x {:scale \"x\", :field \"date\", :offset 2}, :y {:scale \"y\", :field \"indexed_price\"}, :fill {:scale \"color\", :field \"symbol\"}, :text {:field \"symbol\"}, :baseline {:value \"middle\"}}}}]} {:type \"rule\", :encode {:update {:x {:field {:group \"x\"}}, :x2 {:field {:group \"width\"}}, :y {:value 0.5, :offset {:scale \"y\", :value 0, :round true}}, :stroke {:value \"black\"}, :strokeWidth {:value 1}}}} {:type \"rule\", :encode {:update {:x {:scale \"x\", :signal \"indexDate\", :offset 0.5}, :y {:value 0}, :y2 {:field {:group \"height\"}}, :stroke {:value \"firebrick\"}}}} {:type \"text\", :encode {:update {:x {:scale \"x\", :signal \"indexDate\"}, :y2 {:field {:group \"height\"}, :offset 15}, :align {:value \"center\"}, :text {:signal \"timeFormat(indexDate, '%b %Y')\"}, :fill {:value \"firebrick\"}}}}], :$schema \"https://vega.github.io/schema/vega/v5.json\", :signals [{:name \"indexDate\", :update \"time('Jan 1 2005')\", :on [{:events \"mousemove\", :update \"invert('x', clamp(x(), 0, width))\"}]} {:name \"maxDate\", :update \"time('Mar 1 2010')\"}], :height 300, :data [{:name \"stocks\", :url \"https://vega.github.io/editor/data/stocks.csv\", :format {:type \"csv\", :parse {:price \"number\", :date \"date\"}}} {:name \"index\", :source \"stocks\", :transform [{:type \"filter\", :expr \"month(datum.date) == month(indexDate) && year(datum.date) == year(indexDate)\"}]} {:name \"indexed_stocks\", :source \"stocks\", :transform [{:type \"lookup\", :from \"index\", :key \"symbol\", :fields [\"symbol\"], :as [\"index\"], :default {:price 0}} {:type \"formula\", :as \"indexed_price\", :expr \"datum.index.price > 0 ? (datum.price - datum.index.price)/datum.index.price : 0\"}]}]}}"}
;; <=

;; @@
(def yyy {:$schema "https://vega.github.io/schema/vega/v5.json",
 :width 720,
 :height 480,
 :padding 5,
 :data
 [{:name "sp500",
   :url "https://vega.github.io/vega/data/sp500.csv",
   :format {:type "csv", :parse {:price "number", :date "date"}}}],
 :signals [{:name "detailDomain"}],
 :marks
 [{:type "group",
   :name "detail",
   :encode {:enter {:height {:value 390}, :width {:value 720}}},
   :scales
   [{:name "xDetail",
     :type "time",
     :range "width",
     :domain {:data "sp500", :field "date"},
     :domainRaw {:signal "detailDomain"}}
    {:name "yDetail",
     :type "linear",
     :range [390 0],
     :domain {:data "sp500", :field "price"},
     :nice true,
     :zero true}],
   :axes
   [{:orient "bottom", :scale "xDetail"}
    {:orient "left", :scale "yDetail"}],
   :marks
   [{:type "group",
     :encode
     {:enter
      {:height {:field {:group "height"}},
       :width {:field {:group "width"}},
       :clip {:value true}}},
     :marks
     [{:type "area",
       :from {:data "sp500"},
       :encode
       {:update
        {:x {:scale "xDetail", :field "date"},
         :y {:scale "yDetail", :field "price"},
         :y2 {:scale "yDetail", :value 0},
         :fill {:value "steelblue"}}}}]}]}
  {:type "group",
   :name "overview",
   :encode
   {:enter
    {:x {:value 0},
     :y {:value 430},
     :height {:value 70},
     :width {:value 720},
     :fill {:value "transparent"}}},
   :signals
   [{:name "brush",
     :value 0,
     :on
     [{:events "@overview:mousedown", :update "[x(), x()]"}
      {:events
       "[@overview:mousedown, window:mouseup] > window:mousemove!",
       :update "[brush[0], clamp(x(), 0, width)]"}
      {:events {:signal "delta"},
       :update
       "clampRange([anchor[0] + delta, anchor[1] + delta], 0, width)"}]}
    {:name "anchor",
     :value nil,
     :on [{:events "@brush:mousedown", :update "slice(brush)"}]}
    {:name "xdown",
     :value 0,
     :on [{:events "@brush:mousedown", :update "x()"}]}
    {:name "delta",
     :value 0,
     :on
     [{:events
       "[@brush:mousedown, window:mouseup] > window:mousemove!",
       :update "x() - xdown"}]}
    {:name "detailDomain",
     :push "outer",
     :on
     [{:events {:signal "brush"},
       :update "span(brush) ? invert('xOverview', brush) : null"}]}],
   :scales
   [{:name "xOverview",
     :type "time",
     :range "width",
     :domain {:data "sp500", :field "date"}}
    {:name "yOverview",
     :type "linear",
     :range [70 0],
     :domain {:data "sp500", :field "price"},
     :nice true,
     :zero true}],
   :axes [{:orient "bottom", :scale "xOverview"}],
   :marks
   [{:type "area",
     :interactive false,
     :from {:data "sp500"},
     :encode
     {:update
      {:x {:scale "xOverview", :field "date"},
       :y {:scale "yOverview", :field "price"},
       :y2 {:scale "yOverview", :value 0},
       :fill {:value "steelblue"}}}}
    {:type "rect",
     :name "brush",
     :encode
     {:enter
      {:y {:value 0},
       :height {:value 70},
       :fill {:value "#333"},
       :fillOpacity {:value 0.2}},
      :update {:x {:signal "brush[0]"}, :x2 {:signal "brush[1]"}}}}
    {:type "rect",
     :interactive false,
     :encode
     {:enter
      {:y {:value 0},
       :height {:value 70},
       :width {:value 1},
       :fill {:value "firebrick"}},
      :update {:x {:signal "brush[0]"}}}}
    {:type "rect",
     :interactive false,
     :encode
     {:enter
      {:y {:value 0},
       :height {:value 70},
       :width {:value 1},
       :fill {:value "firebrick"}},
      :update {:x {:signal "brush[1]"}}}}]}]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;vega-test/yyy</span>","value":"#'vega-test/yyy"}
;; <=

;; @@
(Mega. yyy)
;; @@
;; =>
;;; {"type":"html","content":"\n<div>\n  <script data-main='scripts/main' src='https://cdnjs.cloudflare.com/ajax/libs/require.js/2.3.6/require.min.js'>     </script>\n\n  <div id='uuid-8bf49d85-8afc-4edc-9bd1-90340d7c2cae'></div>\n  <script>\n  requirejs.config({\n    baseUrl: 'https://cdn.jsdelivr.net/npm/',\n    paths: {\n      'vega-embed':  'vega-embed@3?noext',\n      'vega-lib': 'vega-lib?noext',\n      'vega-lite': 'vega-lite@2?noext',\n      'vega': 'vega@3?noext'\n    }\n  });\n  require(['vega-embed'], function(vegaEmbed) {\n    let spec = {\"$schema\":\"https:\\/\\/vega.github.io\\/schema\\/vega\\/v5.json\",\"width\":720,\"height\":480,\"padding\":5,\"data\":[{\"name\":\"sp500\",\"url\":\"https:\\/\\/vega.github.io\\/vega\\/data\\/sp500.csv\",\"format\":{\"type\":\"csv\",\"parse\":{\"price\":\"number\",\"date\":\"date\"}}}],\"signals\":[{\"name\":\"detailDomain\"}],\"marks\":[{\"type\":\"group\",\"name\":\"detail\",\"encode\":{\"enter\":{\"height\":{\"value\":390},\"width\":{\"value\":720}}},\"scales\":[{\"name\":\"xDetail\",\"type\":\"time\",\"range\":\"width\",\"domain\":{\"data\":\"sp500\",\"field\":\"date\"},\"domainRaw\":{\"signal\":\"detailDomain\"}},{\"name\":\"yDetail\",\"type\":\"linear\",\"range\":[390,0],\"domain\":{\"data\":\"sp500\",\"field\":\"price\"},\"nice\":true,\"zero\":true}],\"axes\":[{\"orient\":\"bottom\",\"scale\":\"xDetail\"},{\"orient\":\"left\",\"scale\":\"yDetail\"}],\"marks\":[{\"type\":\"group\",\"encode\":{\"enter\":{\"height\":{\"field\":{\"group\":\"height\"}},\"width\":{\"field\":{\"group\":\"width\"}},\"clip\":{\"value\":true}}},\"marks\":[{\"type\":\"area\",\"from\":{\"data\":\"sp500\"},\"encode\":{\"update\":{\"x\":{\"scale\":\"xDetail\",\"field\":\"date\"},\"y\":{\"scale\":\"yDetail\",\"field\":\"price\"},\"y2\":{\"scale\":\"yDetail\",\"value\":0},\"fill\":{\"value\":\"steelblue\"}}}}]}]},{\"type\":\"group\",\"name\":\"overview\",\"encode\":{\"enter\":{\"x\":{\"value\":0},\"y\":{\"value\":430},\"height\":{\"value\":70},\"width\":{\"value\":720},\"fill\":{\"value\":\"transparent\"}}},\"signals\":[{\"name\":\"brush\",\"value\":0,\"on\":[{\"events\":\"@overview:mousedown\",\"update\":\"[x(), x()]\"},{\"events\":\"[@overview:mousedown, window:mouseup] > window:mousemove!\",\"update\":\"[brush[0], clamp(x(), 0, width)]\"},{\"events\":{\"signal\":\"delta\"},\"update\":\"clampRange([anchor[0] + delta, anchor[1] + delta], 0, width)\"}]},{\"name\":\"anchor\",\"value\":null,\"on\":[{\"events\":\"@brush:mousedown\",\"update\":\"slice(brush)\"}]},{\"name\":\"xdown\",\"value\":0,\"on\":[{\"events\":\"@brush:mousedown\",\"update\":\"x()\"}]},{\"name\":\"delta\",\"value\":0,\"on\":[{\"events\":\"[@brush:mousedown, window:mouseup] > window:mousemove!\",\"update\":\"x() - xdown\"}]},{\"name\":\"detailDomain\",\"push\":\"outer\",\"on\":[{\"events\":{\"signal\":\"brush\"},\"update\":\"span(brush) ? invert('xOverview', brush) : null\"}]}],\"scales\":[{\"name\":\"xOverview\",\"type\":\"time\",\"range\":\"width\",\"domain\":{\"data\":\"sp500\",\"field\":\"date\"}},{\"name\":\"yOverview\",\"type\":\"linear\",\"range\":[70,0],\"domain\":{\"data\":\"sp500\",\"field\":\"price\"},\"nice\":true,\"zero\":true}],\"axes\":[{\"orient\":\"bottom\",\"scale\":\"xOverview\"}],\"marks\":[{\"type\":\"area\",\"interactive\":false,\"from\":{\"data\":\"sp500\"},\"encode\":{\"update\":{\"x\":{\"scale\":\"xOverview\",\"field\":\"date\"},\"y\":{\"scale\":\"yOverview\",\"field\":\"price\"},\"y2\":{\"scale\":\"yOverview\",\"value\":0},\"fill\":{\"value\":\"steelblue\"}}}},{\"type\":\"rect\",\"name\":\"brush\",\"encode\":{\"enter\":{\"y\":{\"value\":0},\"height\":{\"value\":70},\"fill\":{\"value\":\"#333\"},\"fillOpacity\":{\"value\":0.2}},\"update\":{\"x\":{\"signal\":\"brush[0]\"},\"x2\":{\"signal\":\"brush[1]\"}}}},{\"type\":\"rect\",\"interactive\":false,\"encode\":{\"enter\":{\"y\":{\"value\":0},\"height\":{\"value\":70},\"width\":{\"value\":1},\"fill\":{\"value\":\"firebrick\"}},\"update\":{\"x\":{\"signal\":\"brush[0]\"}}}},{\"type\":\"rect\",\"interactive\":false,\"encode\":{\"enter\":{\"y\":{\"value\":0},\"height\":{\"value\":70},\"width\":{\"value\":1},\"fill\":{\"value\":\"firebrick\"}},\"update\":{\"x\":{\"signal\":\"brush[1]\"}}}}]}]};\n    vegaEmbed('#uuid-8bf49d85-8afc-4edc-9bd1-90340d7c2cae', spec, {defaultStyle:true}).catch(console.warn);\n    }, function(err) {\n    console.log('Failed to load');\n  });\n  </script>\n</div>\n  ","value":"#vega_test.Mega{:specs {:$schema \"https://vega.github.io/schema/vega/v5.json\", :width 720, :height 480, :padding 5, :data [{:name \"sp500\", :url \"https://vega.github.io/vega/data/sp500.csv\", :format {:type \"csv\", :parse {:price \"number\", :date \"date\"}}}], :signals [{:name \"detailDomain\"}], :marks [{:type \"group\", :name \"detail\", :encode {:enter {:height {:value 390}, :width {:value 720}}}, :scales [{:name \"xDetail\", :type \"time\", :range \"width\", :domain {:data \"sp500\", :field \"date\"}, :domainRaw {:signal \"detailDomain\"}} {:name \"yDetail\", :type \"linear\", :range [390 0], :domain {:data \"sp500\", :field \"price\"}, :nice true, :zero true}], :axes [{:orient \"bottom\", :scale \"xDetail\"} {:orient \"left\", :scale \"yDetail\"}], :marks [{:type \"group\", :encode {:enter {:height {:field {:group \"height\"}}, :width {:field {:group \"width\"}}, :clip {:value true}}}, :marks [{:type \"area\", :from {:data \"sp500\"}, :encode {:update {:x {:scale \"xDetail\", :field \"date\"}, :y {:scale \"yDetail\", :field \"price\"}, :y2 {:scale \"yDetail\", :value 0}, :fill {:value \"steelblue\"}}}}]}]} {:type \"group\", :name \"overview\", :encode {:enter {:x {:value 0}, :y {:value 430}, :height {:value 70}, :width {:value 720}, :fill {:value \"transparent\"}}}, :signals [{:name \"brush\", :value 0, :on [{:events \"@overview:mousedown\", :update \"[x(), x()]\"} {:events \"[@overview:mousedown, window:mouseup] > window:mousemove!\", :update \"[brush[0], clamp(x(), 0, width)]\"} {:events {:signal \"delta\"}, :update \"clampRange([anchor[0] + delta, anchor[1] + delta], 0, width)\"}]} {:name \"anchor\", :value nil, :on [{:events \"@brush:mousedown\", :update \"slice(brush)\"}]} {:name \"xdown\", :value 0, :on [{:events \"@brush:mousedown\", :update \"x()\"}]} {:name \"delta\", :value 0, :on [{:events \"[@brush:mousedown, window:mouseup] > window:mousemove!\", :update \"x() - xdown\"}]} {:name \"detailDomain\", :push \"outer\", :on [{:events {:signal \"brush\"}, :update \"span(brush) ? invert('xOverview', brush) : null\"}]}], :scales [{:name \"xOverview\", :type \"time\", :range \"width\", :domain {:data \"sp500\", :field \"date\"}} {:name \"yOverview\", :type \"linear\", :range [70 0], :domain {:data \"sp500\", :field \"price\"}, :nice true, :zero true}], :axes [{:orient \"bottom\", :scale \"xOverview\"}], :marks [{:type \"area\", :interactive false, :from {:data \"sp500\"}, :encode {:update {:x {:scale \"xOverview\", :field \"date\"}, :y {:scale \"yOverview\", :field \"price\"}, :y2 {:scale \"yOverview\", :value 0}, :fill {:value \"steelblue\"}}}} {:type \"rect\", :name \"brush\", :encode {:enter {:y {:value 0}, :height {:value 70}, :fill {:value \"#333\"}, :fillOpacity {:value 0.2}}, :update {:x {:signal \"brush[0]\"}, :x2 {:signal \"brush[1]\"}}}} {:type \"rect\", :interactive false, :encode {:enter {:y {:value 0}, :height {:value 70}, :width {:value 1}, :fill {:value \"firebrick\"}}, :update {:x {:signal \"brush[0]\"}}}} {:type \"rect\", :interactive false, :encode {:enter {:y {:value 0}, :height {:value 70}, :width {:value 1}, :fill {:value \"firebrick\"}}, :update {:x {:signal \"brush[1]\"}}}}]}]}}"}
;; <=

;; @@

;; @@
