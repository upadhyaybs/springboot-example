#!groovy

@Library('jenkins-shared-lib@master') _  

deliveryPipeline{
	appName = 'spring-boot-demo'
    command = './gradlew clean build -DskipTests=true'
    unitTestCommand = './gradlew test'
    unitTestResultPath= 'build/test-results/test/*.xml'
    codeCoverageCommand = './gradlew jacocoTestReport'
    dependencyCheckCommand='./gradlew dependencyCheckAnalyze'
    //email = 'team@example.com'
    //serverPort = '8080'
    //developmentServer = 'dev-myproject.mycompany.com'
    //stagingServer = 'staging-myproject.mycompany.com'
    //productionServer = 'production-myproject.mycompany.com'
}
