FROM eclipse-temurin:11-jdk AS war

RUN mkdir -p sp-webapp
COPY ./src sp-webapp/src/
COPY ./gradle/ sp-webapp/gradle/
COPY ./gradlew ./build.gradle ./gradle.properties ./docker-run.sh /sp-webapp/

RUN cd / \
    && mkdir -p /etc/cas/config/saml \
    && mkdir -p /etc/cas/saml

RUN mkdir -p ~/.gradle \
    && echo "org.gradle.daemon=false" >> ~/.gradle/gradle.properties \
    && echo "org.gradle.configureondemand=true" >> ~/.gradle/gradle.properties \
    && cd sp-webapp \
    && chmod 750 ./gradlew \
    && ./gradlew --version;

RUN cd sp-webapp && ./gradlew clean build --parallel --no-daemon;
    
EXPOSE 9876 8076

ENV PATH $PATH:$JAVA_HOME/bin:.

WORKDIR sp-webapp
RUN ls -al && chmod +x *.sh

ENTRYPOINT ["docker-run.sh"]
