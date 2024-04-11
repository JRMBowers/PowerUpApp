// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.dynamic-feature") version "8.2.2" apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}
ktlint {
    outputToConsole = true
}

task<Copy>("installPrePushGitHook") {
    from(File("$rootDir/git_hooks", "pre-push"))
    into { File(rootProject.rootDir, ".git/hooks") }
    fileMode = Integer.parseInt("777", 8)
}

task<Copy>("installPreCommitGitHook") {
    from(File("$rootDir/git_hooks", "pre-commit"))
    into { File(rootProject.rootDir, ".git/hooks") }
    fileMode = Integer.parseInt("777", 8)
}

tasks.getByPath("app:preBuild").dependsOn("installPrePushGitHook")