SHELL = /bin/bash

install:
	gem install bundler -v 2.4.20 && bundle update --bundler

unit_test:
	./gradlew clean testDebugUnitTest --stacktrace -PpreDexEnable=false

ktlintCheck:
	./gradlew ktlintCheck

ktlintFormat:
	./gradlew ktlintFormat
