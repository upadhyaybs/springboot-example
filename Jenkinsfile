#!groovy

pipeline {
 agent any
 environment {
  ORG_NAME = "upadhyaybs"
  APP_NAME = "spring-boot-demo"
  APP_VERSION = "1.0-SNAPSHOT"
  APP_CONTEXT_ROOT = "/"
  APP_LISTENING_PORT = "8080"
  TEST_CONTAINER_NAME = "ci-${APP_NAME}-${BUILD_NUMBER}"
  DOCKER_HOST = "tcp://127.0.0.1:2375"
 }

 stages {
  
  stage('Git Checkout') {
   steps {
    echo "-=- Checkout Code -=-"
    // Get some code from a GitHub repository
    git credentialsId: 'git-creds', url: 'https://github.com/upadhyaybs/spring-boot-demo.git'
   }
  }

  stage('Compile') {
   steps {
    echo "-=- compiling project -=-"
    bat "./gradlew clean build"
   }
  }

  stage('Unit tests') {
   steps {
    echo "-=- execute unit tests -=-"
    bat "./gradlew test"
    junit 'build/test-results/test/*.xml'
   }
  }
  stage('JaCoCo') {
   steps {
    echo "-=- Code Coverage -=-"
    jacoco()
   }
  }

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
