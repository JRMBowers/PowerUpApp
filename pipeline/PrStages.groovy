

//def runUnitTests() {
//    tools.printedStage("Running unit tests") {
//        sh 'make unit_test'
//    }
//}

def runKtlintCheck() {
    stage("Run KtLint Check") {
        sh 'make ktlintCheck'
    }
}
return this;
