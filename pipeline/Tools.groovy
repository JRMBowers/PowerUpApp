def printHighlighted(string) {
    println "\033[1;4;42m $string \033[0m"
}

def printedStage(name, body) {
    stage(name) {
        printHighlighted(name)
        body()
    }
}

return this;