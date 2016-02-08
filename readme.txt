Crossbank Hypothetical System

Prerequisites:
1. JDK 1.8
2. Internet connection to download dependencies
3. [optional] Docker should be installed if you would like to try running modules in separate containers

Build instructions:
1. Project's build system is Gradle. All required dependencies will be downloaded automatically.
   To build the sources please run as follows
   ./gradlew build

2. After building succeeded check directories and find built artifacts
   accounts/build/libs/accounts-0.1.jar
   front/build/libs/transactions-0.1.jar
   front/build/libs/front-0.1.jar

3. To run the system all the built components should be started.

   java -jar accounts-0.1.jar [--server.port=8444]
   Started microservice listens https/8444. The port can be customized with an optional parameter

   java -jar transactions-0.1.jar [--server.port=8445]
   Started microservice listens https/8445. The port can be customized with an optional parameter

   java -jar front-0.1.jar [--account.service.url=https://localhost:8444/accounts] [--transaction.service.url=https://localhost:8445/transactions] [--server.port=8443]
   Started microservice listens https/8443. Dependencies are specified as optional URLs as well as the port.

4. A delivery pipeline offered in the design document includes packaging into a Docker image. This can be easily achieved as a part of standard CI life cycle.

   Buiding docker images can be started as follows
   gradlew buildDockerImage

   Further we can deploy a built image so many times as we need to support growing use. Arguments can be passed to a module by setting environment variables as follows

   docker run -d --name accounts -e server.port=8444 crossbank/accounts:0.1
   decker run -d --name transactions -e server.port=8445 crossbank/transactions:0.1
   docker run -d --link accounts:accounts --link transactions:transactions -e account.service.url=https://accounts:8444/accounts -e transaction.service.url=https://transactions:8445/transactions crossbank/front:0.1

5. Some parts of the design document have not been implemented due to time restrictions. Sorry.

Thank you for your time spent on evaluation of my implementation. Have a nice day.

Best regards,
Dmitry Dobrynin