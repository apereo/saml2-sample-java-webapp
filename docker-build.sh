#!/bin/sh

docker build --tag="apereo/saml2-sp" . \
  && echo "Built image successfully." \
  && docker images "apereo/saml2-sp"

docker_user="$1"
docker_psw="$2"

if [ -n "${docker_user}" ]; then
  echo "$docker_psw" | docker login --username "$docker_user" --password-stdin
  echo "Pushing docker image: apereo/saml2-sp"
  docker push apereo/saml2-sp \
    && echo "Pushed apereo/saml2-sp successfully.";
fi

# docker run -p 9876:9876 -it -d --rm --name=sp \
# -v /etc/cas/config/saml/idp-metadata.xml:/etc/cas/config/saml/idp-metadata.xml \
# -v /etc/cas/thekeystore:/etc/cas/thekeystore apereo/saml2-sp
