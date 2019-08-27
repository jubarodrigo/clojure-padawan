(ns padwan.nivel3)

;define um mapa
(def transacoes
  [{:valor 33.0 :tipo "despesa" :comentario "Almoço" :moeda "R$" :data "19/08/2019"}
   {:valor 2700.0 :tipo "receita" :comentario "Bico" :moeda "R$" :data "16/08/2019"}
   {:valor 29.0 :tipo "despesa" :comentario "Livro de Clojure" :moeda "R$" :data "07/08/2019"}])

;retorna valor com concatecação de string para sinalizar a operação
(defn valor-sinalizado
  [transacao]
  (if (= (:tipo transacao) "despesa")
    (str (:moeda transacao) " + " (:valor transacao))
    (str (:moeda transacao) " - " (:valor transacao))))

;retorna primeiro valor do mapa
(valor-sinalizado (first transacoes))

;let é usada para criação de variaveis locais, atribuindo valores
; para reutilização dentro do escopo da função
(defn valor-sinalizado-ref
  [transacao]
  (let [moeda (:moeda transacao "R$")
        valor (:valor transacao)]
    (if (= (:tipo transacao) "despesa")
      (str moeda " -" valor)
      (str moeda " +" valor))))

;retorna segundo valor do mapa
(valor-sinalizado-ref (second transacoes))

(defn data-valor
  [transacao]
  (str (:data transacao) "=>" (valor-sinalizado-ref transacao)))

(data-valor (first transacoes))

