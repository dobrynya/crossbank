Crossbank Hypothetical System

Prerequisites:
1. JDK 1.8
2. Internet connection to download dependencies

Build instructions:
1. Project's build system is Gradle. To build the sources please run "gradlew build".

2. After building succeeded check directories and find built artifacts
   accounts/build/libs/accounts-0.1.jar
   front/build/libs/transactions-0.1.jar
   front/build/libs/front-0.1.jar

3. To run the system all the built components should be started.

   java -jar accounts-0.1.jar [--server.port=8444]
   Started microservice listens https/8444. The port can be customized with an optional parameter

   java -jar transactions-0.1.jar [--server.port=8445]
   Started microservice listens https/8445. The port can be customized with an optional parameter

   java -jar fron-0.1.jar [--account.service.url=https://localhost:8444/accounts] [--transaction.service.url=https://localhost:8445/transactions] [--server.port=8443]
   Started microservice listens https/8443. Dependencies are specified as optional URLs as well as the port.

4. A delivery pipeline offered in the design document includes packaging into a Docker image. This can be easily achieved as a part of standard CI life cycle.
Further we can deploy a built image so many times as we need to support growing use.
Dockerfile in the root project directory is just an example
