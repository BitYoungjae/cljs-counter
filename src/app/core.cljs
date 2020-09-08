(ns app.core)

(defn ^:dev/after-load start [] ; HMR 을 위한 코드 ^:dev~는 메타 태그이다
  ; 매번 파일 저장시마다 이 함수가 호출이 된다.
  (js/console.log "안녕 CLJS"))

(defn ^:export init [] ; entry point. devserver 실행시 호출된다.
  (start))