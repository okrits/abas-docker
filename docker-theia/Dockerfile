#Theia-Image

ARG NODE_VERSION=10
FROM ibmcom/ibmjava:8-sdk as java-base

FROM node:$NODE_VERSION
COPY --from=java-base /opt/ibm/java /opt/ibm/java

ENV JAVA_HOME=/opt/ibm/java/jre \
    PATH=/opt/ibm/java/jre/bin:$PATH

RUN apt-get update && \
  apt-get install -y curl apt-transport-https maven gradle && \
  curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add - && \
  echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list && \
  apt-get update && apt-get install -y yarn && \
  rm -rf /var/lib/apt/lists/*
# User account
RUN adduser --disabled-password --gecos '' theia
RUN chmod g+rw /home && \
    mkdir -p /home/project && \
    chown -R theia:theia /home/theia && \
    chown -R theia:theia /home/project;
WORKDIR /home/theia
USER theia
RUN git clone https://60f7787ae4074c4dc5a69d6608f87652dc21e6bd:x-oauth-basic@github.com/okrits/abas-docker browser-ide

ARG version=latest
ADD $version.package.json ./package.json
ARG GITHUB_TOKEN
RUN yarn --cache-folder ./ycache && rm -rf ./ycache
RUN yarn theia build
EXPOSE 3000
ENV SHELL /bin/bash
ENTRYPOINT [ "yarn", "theia", "start", "/home/theia/browser-ide", "--hostname=0.0.0.0" ]