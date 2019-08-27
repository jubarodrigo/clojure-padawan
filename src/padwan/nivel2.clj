(ns padwan.nivel2)

;-----------------------------------MAP----------------------------------

;funcao select-keys retorna as chaves de um mapa
(defn resumo
  [transacao]
  (select-keys transacao [:valor :tipo :data])
  )

;define um mapa
(def transacoes
  [{:valor 33.0 :tipo "despesa" :comentario "Almoço" :data "19/08/2019"}
   {:valor 2700.0 :tipo "receita" :comentario "Bico" :data "16/08/2019"}
   {:valor 29.0 :tipo "despesa" :comentario "Livro de Clojure" :data "07/08/2019"}]
  )

;retorna um mapa com as chaves filtradas pela funcao resumo
(map resumo transacoes)

;-----------------------------------FILTER----------------------------------

;retorna true para o tipo de transacao igual a despesa
(defn despesa?
  [transacao]
  (= (:tipo transacao) "despesa")
  )

;funcao filter retorna o mapa das despesas conforme funcao despesa? retorna true
(filter despesa? transacoes)

;-----------------------------------REDUCE----------------------------------

;retorna somente chave valor de um mapa
(defn so-valor
  [transacao]
  (:valor transacao)
  )

;retorna somente os valores das despesas
(map so-valor (filter despesa? transacoes))

;reduce combina os itens em um valor, no caso soma todos os valores das despesas
(reduce + (map so-valor (filter despesa? transacoes)))

;-----------------------------------FUNCOES ANONIMAS----------------------------------

;verifica valores maiores que 100
(defn valor-grande?
  [transacao]
  (> (:valor transacao) 100)
  )

;filtra valores maiores que 100 a partir da funcao valor-grande?
(filter valor-grande? transacoes)

;esquema simples de uma funão anonima
((fn [nome]
   (str "Ola,"  nome  "!"))
 "mundo novo"
 )

;funcao de filtrar valores maiores que sem utilizando funcao anonima
(filter
  (fn [transacao] (> (:valor transacao) 100))
  transacoes
  )

;mesma função anterior, com funcao anonima de forma abreviada
(reduce
  + (map #(:valor %)
         (filter #(= (:tipo %) "despesa") transacoes))
  )

;-----------------------------------THREAD FIRST/LAST----------------------------------

;retorna o primeiro valor do mapa
(so-valor (first transacoes))

;funcao thread first faz com que o resultado da linha seja passado como
; primeiro argumento na proxima funcao
(-> (first transacoes)
    (so-valor)
    )
;funcao thread last passa o resultado da funcao como ultimo argumento da funcao seguinte
(->> (filter despesa? transacoes)
     (map so-valor)
     (reduce +)
     )

