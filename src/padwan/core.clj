(ns padwan.core)

;funcao defn cria uma nova função, no caso a Foo
(defn foo
  "Este é o lado Clojure da força!."
  [x]
  (println x "Bem vindo, jovem Padawan!"))

;Função zero? verifica se o numero é exatamente zero e mod traz o resto da divisão
(defn divisivel-por?
  [dividendo divisor]
  (zero? (mod dividendo divisor))
  )

;Funcao and verifica se as duas condicoes sao verdadeiras


(defn fizzbuzz
  [num]
  (cond (and (divisivel-por? num 3) (divisivel-por? num 5)) "fizzbuzz"
        (divisivel-por? num 3) "fizz"
        (divisivel-por? num 5) "buzz"
        :else num))

;-------------------------------LISTAS--------------------------

;def define uma constante
;range é uma função que percorre o espaço informado entre dois numeros
;criacao de uma lista


(def um-ate-quinze (range 1 16))

;list cria uma lista de elementos
(def cantora-arretada (list "Renata Arruda" "Joao Pessoa" 23 "dezembro" 1967))

;funcao nth retorna a posicao informada em uma lista
(nth cantora-arretada 4)

;retorna a primeira posicao
(first cantora-arretada)

;funcao hash-set cria uma lista de valores unicos
(def artistas #{"Renata Arruda" "Chico Cesar"})

;-------------------------------VETORES--------------------------

;funcao vector cria um vetor
(def cantor-arretado (vector "Chico cesar" "Catole da Rocha" 26 "janeiro" 1964))

;funcao get retorna a posicao informada em um vetor
(get cantor-arretado 0)

;retorna a ultima posicao
(last cantor-arretado)

;funcao conj adiciona elementos em uma lista ou array
(conj cantor-arretado "MPB")

;-------------------------------MAPAS--------------------------

;funcao hash-map cria um mapa chave-valor
(hash-map :valor 200 :tipo "receita")

;outra forma de criar um mapa
(def transacao {:valor 200 :tipo "receita"})

;assoc adiciona mais uma chave-valor ao mapa
(assoc transacao :categoria "educação")

;retorna o valor da chave informada
(get transacao :valor)

;outra forma de retornar o valor de uma chave
(:valor transacao)
