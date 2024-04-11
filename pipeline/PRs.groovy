timeout(60) {
    timestamps {
        ansiColor('xterm') {
            def lang_format = 'en_US.UTF-8'
            withEnv([
                    "LANG=$lang_format",
                    "LANGUAGE=$lang_format",
                    "ANDROID_SDK_ROOT=/Users/admin/Library/Android/sdk",
                    "GEM_HOME=/Users/admin/.rvm/gems/ruby-3.2.2",
                    "GEM_PATH=/Users/admin/.rvm/gems/ruby-3.2.2:/Users/admin/.rvm/gems/ruby-3.2.2@global",
                    "RUBY_VERSION=ruby-3.2.2"
            ]) {
                stages = load('./pipeline/PrStages.groovy')
                stages.checkLocalProperties()
                try {
                    stages.runKtlintCheck()
                    stages.runUnitTests()
                    currentBuild.result = 'SUCCESS'
                } catch (e) {
                    echo 'Err: ' + e.toString()
                    currentBuild.result = 'FAILURE'
                } finally {
                    echo 'Cleaning up the workspace'
                    cleanWs()
                }
            }
        }
    }
}
