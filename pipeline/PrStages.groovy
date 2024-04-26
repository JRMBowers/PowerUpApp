tools = load('./pipeline/Tools.groovy')

def runUnitTests() {
    tools.printedStage("Running unit tests") {
        sh 'make unit_test'
    }
}

def runKtlintCheck() {
    tools.printedStage("Run KtLint Check") {
        sh 'make ktlintCheck'
    }
}
return this;
