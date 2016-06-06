(ns shouter.views.shouts
  (:require [shouter.views.layout :as layout]
            [hiccup.core :refer [h]]
            [ring.util.anti-forgery :as x]))

(defn shout-form []
  [:div {:id "shout-form" :class "sixteen columns alpha omega"}
   [:form {:action "/" :method "post"}
    (x/anti-forgery-field)
    [:label {:for "shout"} "What do you want to SHOUT?!"]
    [:textarea {:name "shout"}]
    [:button "SHOUT!!"]]])

(defn display-shouts [shouts]
  [:div {:class "shouts sixteen columns alpha omega"}
   (map (fn [shout]
          [:h2 {:class "shout"} (h (:body shout))]) shouts)])

(defn index [shouts]
  (layout/common "SHOUTER!!"
                 (shout-form)
                 [:div {:class "clear"}]
                 (display-shouts shouts)))
