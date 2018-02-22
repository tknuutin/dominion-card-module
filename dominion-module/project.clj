(defproject dominion-module "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "GPLv3"
            :url "http://www.gnu.org/copyleft/gpl.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [scad-clj "0.5.2"]
                 [unicode-math "0.2.0"]]
  :plugins [[lein-cljfmt "0.5.7"]]
  :main ^:skip-aot dominion-module.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
