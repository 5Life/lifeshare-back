# lifeshare-back

## Prerequisites
  - To be able to run this project you'll need:
    - Java 11 
      - The JDK may be the one you prefer but it is recomended to use the [Amazon Corretto JDK](https://sdkman.io/jdks#Amazon)
      - To quickly install and manage your JDKs you should use [SDKMAN](https://sdkman.io/)
        - Check [here](https://sdkman.io/install) to see how to instal SDKMAN
        - And check [here](https://sdkman.io/jdks#Amazon) to see how SDKMAN can install your JDK
    - Maven
      - To install maven just run:
        - ``` sudo apt update ```
        - ``` sudo apt install maven ``` 
        - ``` mvn -version ``` to see if it was installed 

## running it:

- Go to the project root folder

- ``` mvn clean install ```
- ``` java -jar target/{name.jar} ```
- now the project should be up and running !
