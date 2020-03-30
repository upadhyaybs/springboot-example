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
 }

 stages {
   /*
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

  stage('Build Docker image') {
   steps {
    echo "-=- build Docker image -=-"
    bat "docker build -t ${APP_NAME}:${APP_VERSION} ."
   }
  }

 
  stage('Docker Image Tag') {
   steps {
    echo "-=- Create Docker image Tag -=-"
    echo "${ORG_NAME}/${APP_NAME}:${APP_VERSION}"
    withDockerRegistry(credentialsId: 'docker-login', url: 'https://docker.io') {
     bat "docker tag ${APP_NAME}:${APP_VERSION} ${ORG_NAME}/${APP_NAME}:latest"
    }
   }
  }
*/

  stage('Push Docker image') {
   steps {
    echo "-=- push Docker image -=-"
    echo "${ORG_NAME}/${APP_NAME}:latest"
    withDockerRegistry(credentialsId: 'docker-login', url: 'http://vupadh:8081') {
     bat "docker push ${ORG_NAME}/${APP_NAME}:latest"
    }
   }
  }
 }


}
