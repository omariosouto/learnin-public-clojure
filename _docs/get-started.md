# Get Started

- First of all install: https://leiningen.org

## How to use Clojure REPL?

```sh
lein repl
```
> First time that you run, probably some jar files will be downloaded. So just wait for them

```clj
(+ 2 2)
```
> Parenthesis declares that you are using a function. In this case "+" is a add function.

## How to create a CLI project?
```sh
lein new app <name>
```
> That's how I create `./projects/github-profile-display-cli`

## How to create a Back End project?
```
lein new compojure <name>
```
> That's how I create `./projects/pokebank-api`

## How to create a Front End project (ClojureScript + Reframe [React] and shadow-cljs)?
```
lein new reagent <name> +test
```
> That's how I create `./projects/pokebank-ui`
> You can check other ways to start a project here: https://github.com/reagent-project/reagent-template