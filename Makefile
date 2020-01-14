PROJECT_NAME = developer-crud-app

CONTAINER_TARGETS = container_tag container_push
CONTAINER_CTL          = docker

# CONTAINER_REGISTRY = quay.io
# ORG_NAME = famargon

CONTAINER_REGISTRY = 172.30.1.1:5000
ORG_NAME = quarkus-msvcs

TAG             ?= latest
PROJECT_TAG_NAME = $(CONTAINER_REGISTRY)/$(ORG_NAME)/$(PROJECT_NAME):$(TAG)

container: build_jar container_build $(CONTAINER_TARGETS)

container_native: build_native container_build_native $(CONTAINER_TARGETS)

dev:
	mvn compile quarkus:dev

build_jar:
	mvn package -DskipTests

build_native: 
	mvn package -Pnative -DskipTests -Dnative-image.docker-build=true

container_build:
	if [ -f Dockerfile ]; then $(CONTAINER_CTL) build -t $(ORG_NAME)-$(PROJECT_NAME) . ; fi
	if [ -f Dockerfile ]; then docker images | grep $(ORG_NAME)-$(PROJECT_NAME) ; fi

container_build_native:
	$(CONTAINER_CTL) build -f src/main/docker/Dockerfile.native -t $(ORG_NAME)-$(PROJECT_NAME) .
	docker images | grep $(ORG_NAME)-$(PROJECT_NAME)

container_tag:
	if [ -f Dockerfile ]; then $(CONTAINER_CTL) tag $(ORG_NAME)-$(PROJECT_NAME) $(PROJECT_TAG_NAME) ; fi

container_push:
	if [ -f Dockerfile ]; then $(CONTAINER_CTL) push $(PROJECT_TAG_NAME); fi

clean_deployment_bundle:
	rm -rf deployment_bundle

prepare_deployment_bundle:
	mkdir -p deployment_bundle

deployment_bundle: prepare_deployment_bundle
	cp template/set_up_database.sh deployment_bundle/set_up_database.sh
	oc process -f template/deployment-template.yaml -p CONTAINER_IMAGE=$(PROJECT_TAG_NAME) -o yaml > deployment_bundle/bundle.yaml


.PHONY: clean_deployment_bundle prepare_deployment_bundle deployment_bundle container_build container_build_native $(CONTAINER_TARGETS) dev build_jar build_native container container_native
