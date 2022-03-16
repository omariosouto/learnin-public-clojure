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
