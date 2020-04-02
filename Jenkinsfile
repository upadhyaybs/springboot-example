#!groovy

@Library('jenkins-shared-lib@master') _  

deliveryPipeline{
	appName = 'spring-boot-demo'
    branch = env.BRANCH_NAME
    command = './gradlew clean build -DskipTests=true'
    unitTestCommand = './gradlew test'
    unitTestResultPath= 'build/test-results/test/*.xml'
    codeCoverageCommand = './gradlew jacocoTestReport'
    dependencyCheckCommand='./gradlew dependencyCheckAnalyze'
    email = 'team@example.com'
    serverPort = '8080'
    developmentServer = 'dev-myproject.mycompany.com'
    stagingServer = 'staging-myproject.mycompany.com'
    productionServer = 'production-myproject.mycompany.com'
}


/*
pipeline {
 agent any
 environment {
  DOCKER_HOST = "tcp://127.0.0.1:2375"
 }

 stages {
  

  stage('Build') {
   steps {
    script {
     def rtServer = Artifactory.server SERVER_ID
     def rtDocker = Artifactory.docker server: rtServer
     def buildInfo = Artifactory.newBuildInfo()
     def tagName
     buildInfo.env.capture = true
     tagName = "${ARTDOCKER_REGISTRY}/${REPO}/spring-boot-demo:${env.BUILD_NUMBER}"
     println "Docker Framework Build"
     docker.build(tagName)
     println "Docker pushing -->" + tagName + " To " + "${REPO}"
     buildInfo = rtDocker.push(tagName,"${REPO}")
     println "Docker Buildinfo"
     rtServer.publishBuildInfo buildInfo
    }

   }
  }
 }
}

*/
