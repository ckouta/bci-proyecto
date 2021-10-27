#!/bin/bash
echo "Compilando Fuentes"

export JAVA_HOME=/opt/jdk1.8.0_291
export GRADLE_HOME=/opt/gradle-7.1.1

export PATH=$JAVA_HOME/bin:$GRADLE_HOME/bin:$PATH

#gradle clean jacocoTestCoverageVerification
gradle test jacocoTestReport

echo '==FIN del Build=='