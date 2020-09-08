(ns app.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(def containerDom (js/document.querySelector "#app")) ; app container

(defn counter []
  (let [count (r/atom 0)] ; internal state. Atoms is containers for state that change over time.
    (js/setInterval #(swap! count inc) 1000) ; didMounted
    (fn []
      (js/setTimeout #(js/console.log "did updated") 0) ; didUpdate
      [:div
       [:p.test.test2 {:class ["append1" "append2"]} @count] ; 클래스명에 대해 정적 할당시 . notation을 동적 할당시 :class를 쓰면될 것 같다.
       [:input {:type "button" :on-click #(swap! count inc) :value "+"}]
       [:input {:type "button" :on-click #(swap! count dec) :value "-"}]])))

(defn ^:dev/after-load start [] ; HMR 을 위한 코드 ^:dev~는 메타 태그이다
  ; 매번 파일 저장시마다 이 함수가 호출이 된다.
  (rdom/render [counter] containerDom))


(defn ^:export init [] ; entry point. devserver 실행시 호출된다.
  (start))