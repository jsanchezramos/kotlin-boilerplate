HASH ?= $(shell git rev-parse --short HEAD)
VERSION ?= $(shell git describe --tags 2> /dev/null)
PROJECT_NAME ?= kotlin-boilerplate

all:: help

help ::
	@grep -E '^[a-zA-Z_-]+\s*:.*?## .*$$' ${MAKEFILE_LIST} | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[32m%-30s\033[0m %s\n", $$1, $$2}'

run :: ## Run service
	@echo "  > Starting service"
	@./gradlew run --console plain

check :: ## Check everything is ok to move forward within next pipeline step
	@echo "  > Checking conventions and code standards"
	@./gradlew ktlintcheck --console plain

format :: ## Formats and standarizes code following conventions
	@echo "  > Formatting code"d
	@./gradlew ktlintformat --console plain

test :: ## Execute test suite (unit, acceptance, integration, benchmark, performance or whatever is needed)
	@echo "  > Executing tests"
	@./gradlew test --console plain

build :: ## Build a binary in current path
	@echo "  > Building jar"
	@./gradlew shadowJar --console plain

docker-build :: ## Build for docker
	@echo "  > Build"
	@docker build -f configs/Dockerfile . -t ${PROJECT_NAME}:${VERSION}

docker-run :: ## Run to build docker
	@echo "  > Docker run"
	@docker run -p 8080:8080 ${PROJECT_NAME}:${VERSION}
