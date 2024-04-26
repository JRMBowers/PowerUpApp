timeout(60) {
    timestamps {
        stages = load('./pipeline/PrStages.groovy')
        try {
            stages.runKtlintCheck()
            currentBuild.result = 'SUCCESS'
        } catch (e) {
            echo 'Err: ' + e.toString()
            currentBuild.result = 'FAILURE'
        }
    }
}


