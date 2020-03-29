#!groovy

pipeline {
    agent any

    environment {
        ORG_NAME = "upadhyaybs"
        APP_NAME = "spring-boot-demo"
        APP_VERSION = "1.0-SNAPSHOT"
        APP_CONTEXT_ROOT = "/"
        APP_LISTENING_PORT = "8080"
        //TEST_CONTAINER_NAME = "ci-${APP_NAME}-${BUILD_NUMBER}"
        //DOCKER_HUB = credentials("${ORG_NAME}-docker-hub")
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
                sh "./gradlew clean build"
            }
        }

        stage('Unit tests') {
            steps {
                echo "-=- execute unit tests -=-"
                sh "./gradlew test"
                junit 'build/surefire-reports/*.xml'
                jacoco execPattern: 'build/jacoco.exec'
            }
        }

        stage('Build Docker image') {
            steps {
                echo "-=- build Docker image -=-"
                sh "docker build -t ${ORG_NAME}/${APP_NAME}:${APP_VERSION} -t ${ORG_NAME}/${APP_NAME}:latest ."
            }
        }
		
		/*
        stage('Run Docker image') {
            steps {
                echo "-=- run Docker image -=-"
                sh "docker run --name ${TEST_CONTAINER_NAME} --detach --rm --network ci --expose 6300 --env JAVA_OPTS='-javaagent:/jacocoagent.jar=output=tcpserver,address=*,port=6300' ${ORG_NAME}/${APP_NAME}:latest"
            }
        }
        */

         stage('Dependency vulnerability tests') {
            steps {
                echo "-=- run dependency vulnerability tests -=-"
                sh "./mvnw dependency-check:check"
                dependencyCheckPublisher failedTotalHigh: 2, unstableTotalHigh: 2, failedTotalMedium: 5, unstableTotalMedium: 5
            }
        }
	/*
        stage('Push Docker image') {
            steps {
                echo "-=- push Docker image -=-"
                withDockerRegistry([ credentialsId: "${ORG_NAME}-docker-hub", url: "" ]) {
                    sh "docker push ${ORG_NAME}/${APP_NAME}:${APP_VERSION}"
                    sh "docker tag ${ORG_NAME}/${APP_NAME}:${APP_VERSION} ${ORG_NAME}/${APP_NAME}:latest"
                }
            }
        }
	*/
    }

   /*
    post {
        always {
            echo "-=- remove deployment -=-"
            sh "docker stop ${TEST_CONTAINER_NAME}"
        }
    }
    */
}
