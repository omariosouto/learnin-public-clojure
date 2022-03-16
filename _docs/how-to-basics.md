# How to basics


## Declaring Symbols and Functions
```clj
; #_ COMENTA UM BLOCO INTEIRO

; Passamos a função primeiro e depois seus argumentos
(println "Bem vindo ao sistema de estoque")

; Definição de um simbolo com o valor 15
(def total-de-produtos 15)

; Operação é sempre o primeiro argumento "soma 13 com 3"
(+ 13 3) ; 16
```

## Working with vectors/arrays 
```clj
(def pokemons ["Pikachu", "Lucario"])

; ## Acessando Valores

;Se você usar um vetor como se fosse uma função passando um numero,
;você acessa aquela posição 
(pokemons 1) ; => "Lucario"

; ## Adicionando itens
; Usando `conj` você consegue adicionar itens em um vetor,
; mas sempre é retornado um novo vetor 
(conj pokemons "Onix")  ; => ["Pikachu", "Lucario", "Onix"]
(println pokemons) ; => ["Pikachu", "Lucario"]
```

## Definindo Funções
```clj
; Precisa declarar com "defn" e passar os argumentos possíveis de serem recebidos
(defn homeOutput [prefix]
  "Comentário opcional descrevendo o funcionamento da função"
  (str prefix " O total de pokémons é '"(count pega-pokemons)"'))
```
> Na hora de dar nome para as funções, é bom pensar em algo que não remeta a um efeito colateral


## Trabalhando com definição de variáveis pra valer
```clj
; Acho que uma boa forma de ler isso é pensar assim:
; function valorDescontado10%() {
;    let valorBruto = ; // Todas as declarações de variáveis vem
; no topo do escopo que você está
;
;
;
; }

(defn valor-descontado-10%
  "Retorna o valor com deconto de 10%, se o valor bruto for maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (
      let [desconto (/ 10 100)
           desconto-bonus 5]
      (- (* valor-bruto (- 1 desconto)) desconto-bonus))
    valor-bruto
    ))
```


## Booleans e Condicionais
- Só `nil` e `false` são booleans que dão como false

```clj
(defn token-valido?
       [token]
       (if (= token "suadhasuhd")
         true
         false)) 
; retorna true ou false

(defn token-valido?
  [token]
  (when (= token "suadhasuhd")
    true))
; retorna true ou nil


(defn token-valido?
  [token]
  (= token "suadhasuhd"))
; retorna true ou false
```

## Função Anônima
```clj
(fn [valor-bruto] (> valor-bruto 100))


(defn is-the-same?
  "Ensuer that some thing is the same"
  [is-equal? valorA valorB]
  (if (is-equal? valorA valorB)
    (println "é sim confia")
    (println "Num é não :(")))

(is-the-same? (fn [a,b] (= a b)) "oi" "oi")


; ==========================================

(defn is-the-same?
  "Ensuer that some thing is equal A and B"
  [is-equal? valorA valorB]
  (if (is-equal? valorA valorB)
    (println "é sim confia")
    (println "Num é não :(")))

(is-the-same? #(= %1 %2) "oi" "oi")
```

## Vetores,get e updates
```clj
(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0)) ; tem tratamento pra dar out of bond e permite valor default


; ## Adicionando item no final
(println (conj precos 0))

; ## Como usar map?
(println 
  (map 
    (fn [item] (+ item 1))
    [1,2,3]))


(reduce + 0 [1,2,3])
; https://clojuredocs.org/clojure.core
```

## Mapas e threading
```clj
; HashMap

; #keyword :mochila :teste
(def estoque {
	:mochila 10
	:camiseta 5
	})

(assoc estoque :cadeira 3) ; adiciona um devolve um novo 
(assoc estoque :mochila 1) ; override

;========================================================

(def pedido { :mochila {: quantidade 2, :preco 80}
							:camiseta {: quantidade 1, :preco 50}})

(:mochila pedido) ; usa mochila como função pra pegar o valor

; THREADING

; pedido.get('mochila').get('quantidade')
(println (
	-> pedido
			:mochila
			:quantidade)) ; Retorna a quantidade


; Como fazer destructuring 
(defn preco-dos-produtos
    [pedido]
    (let [{:keys [preco quantidade]} pedido]
        (* preco quantidade)))
```


## Thread Last vs Thread First
```clj
; No First passa o parametro como valor no começo
(-> valor (funcao (fn [] ())))
; No last passa o parametro como valor no final
(->> valor (funcao (fn [] ())))
```

## Collections
```clj
(def array [1 2 3 4])
(def mapa {:mario 23 :amanda 24})
(def listaligada '(1 2 3 4))
```
