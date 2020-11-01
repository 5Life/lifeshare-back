# lifeshare-back

## Prerequisites
  - To be able to run this project you'll need:
    - Java 11 
      - The JDK may be the one you prefer, but it is recommended to use the [Azure Zulu JDK](https://sdkman.io/jdks#Azul%20Systems)
      - To quickly install and manage your JDKs you should use [SDKMAN](https://sdkman.io/)
        - Check [here](https://sdkman.io/install) to see how to install SDKMAN
        - And check [here](https://sdkman.io/jdks#Azul%20Systems) to see how SDKMAN can install your JDK
        - To list all java JDKs and its versions: ``` sdk list java ```
        
    - Maven
      - To install Maven just run:
        - ``` sudo apt update ```
        - ``` sudo apt install maven ``` 
        - ``` mvn -version ```

## Environment Set Up:

- Running server:
    - ``` mvn -Dserver.port=8080 clean install ```
    - ``` java -jar -Dserver.port=8080 target/{name.jar} ```
        
- Running Tests:
    - ``` mvn test ```
