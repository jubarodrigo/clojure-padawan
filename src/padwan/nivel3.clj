(ns padwan.nivel3)

;define um mapa
(def transacoes
  [{:valor 33.0M :tipo "despesa" :comentario "Almoço" :moeda "R$" :data "19/08/2019"}
   {:valor 2700.0M :tipo "receita" :comentario "Bico" :moeda "R$" :data "16/08/2019"}
   {:valor 29.0M :tipo "despesa" :comentario "Livro de Clojure" :moeda "R$" :data "07/08/2019"}])

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

;retorna data com simbolo concatenado e valor
(defn data-valor
  [transacao]
  (str (:data transacao) " => " (valor-sinalizado-ref transacao)))

;retorna o resultado da funcao com a primeira posicao do mapa
(data-valor (first transacoes))

;substitui valor por conversao para yuan e altera simbolo da moeda
(defn transacao-em-yuan
  [transacao]
  (assoc transacao :valor (* 2.15M (:valor transacao) )
                   :moeda "¥"))

;retorna o resultado da funcao com a primeira posicao do mapa
(transacao-em-yuan (first transacoes))

;constante para fornecer mapa com cotacoes
(def cotacoes
  {:yuan {:cotacao 2.15M :simbolo "¥"}}
  )

;redefinindo funcao com constante para reutilizar codigo futuramente com outras moedas
(defn transacao-em-yuan
  [transacao]
  (let [yuan (:yuan cotacoes)]
    (assoc transacao :valor (* (:cotacao yuan) (:valor transacao) )
                     :moeda (:simbolo yuan)))
)

;retorna o resultado da funcao com a primeira posicao do mapa
(transacao-em-yuan (first transacoes))

;
(defn resumo-transacao-em-yuan
  [transacao]
  (data-valor (transacao-em-yuan transacao))
  )

(map resumo-transacao-em-yuan transacoes)