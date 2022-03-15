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
```clj
lein new app <name>
```
> Thats how I create `./projects/github-profile-display`