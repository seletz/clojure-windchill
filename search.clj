(import '(wt.method RemoteMethodServer)
        '(wt.epm EPMDocument)
        '(wt.fc PersistenceHelper)
        '(wt.query QuerySpec SearchCondition))

;; Authenticate first
(authenticate "orgadmin" "orgadmin")

(defn sc-name [name]
  (SearchCondition. EPMDocument (EPMDocument/NAME) "LIKE" name false))

(defn make-query-spec [class]
  (QuerySpec. class))

(defn build-query-spec [name]
  (let [qs (make-query-spec EPMDocument)]
    (.appendWhere qs (sc-name name))
    qs))

(defn search [name]
  (enumeration-seq
    (.find PersistenceHelper/manager
      (build-query-spec name))))


(def result
  (search "k05%.asm"))

(println result)

