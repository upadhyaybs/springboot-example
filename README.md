# spring-boot-demo

-This is simple spring boot demo app with Rest Service Controller. This app can be deployed/run as docker image as well.

###Build App

You must have gradle installed and set GRADLE_HOME environment variable.

Run the following command to build the app from the source code directory

### Compile & Build :
gradle clean build

### Run application 
java  -Dspring.profiles.active=dev -jar build/libs/*.jar

### Running as docker image 

Execute the following command to build docker image 

./gradlew jibDockerBuild --image= dockerhub-id/image-name

Example:

./gradlew jibDockerBuild --image=johndoe/spring-boot-demo


### Push the image to docker registry

./gradlew jib --image=dockerhub-id/image-name

Example:

./gradlew jib --image=johndoe/spring-boot-demo

### Test the application 

Enter the below url in browser it should print the message 

''
http://localhost:8080/greetings

Output:

Hello ! This is Spring Boot Demo App.
''

