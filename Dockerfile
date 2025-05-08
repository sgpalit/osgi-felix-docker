FROM eclipse-temurin:17-jdk-alpine

ENV FELIX_VERSION=7.0.5

RUN apk add --no-cache wget && \
    wget https://downloads.apache.org/felix/org.apache.felix.main.distribution-${FELIX_VERSION}.tar.gz && \
    tar -xzf org.apache.felix.main.distribution-${FELIX_VERSION}.tar.gz && \
    mv felix-framework-${FELIX_VERSION} /opt/felix && \
    rm org.apache.felix.main.distribution-${FELIX_VERSION}.tar.gz

WORKDIR /opt/felix

COPY osgi-app1/target/osgi-app1-1.0.0.jar load/
COPY osgi-app2/target/osgi-app2-1.0.0.jar load/

RUN echo "felix.auto.start.1=file:load/osgi-app1-1.0.0.jar file:load/osgi-app2-1.0.0.jar" >> conf/config.properties

CMD ["java", "-jar", "bin/felix.jar"]