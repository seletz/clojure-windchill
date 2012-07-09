(import '(wt.method RemoteMethodServer)
        '(wt.epm EPMDocument)
        '(wt.fc PersistenceHelper)
        '(wt.query QuerySpec SearchCondition))

(defn authenticate [u p]
  (doto (. RemoteMethodServer getDefault)
    (.setUserName u)
    (.setPassword p)))
