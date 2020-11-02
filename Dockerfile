FROM openjdk:11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

# -Xmx512m will define that docker may only use 512MB of RAM
# 512MB of RAM is the maximum offered by heroku on a free subscription
ENTRYPOINT ["java","-Xmx512m","-Dserver.port=${PORT}","-jar","/app.jar"]
