clean:
	mvn clean
	rm -f siakhooi-java-do-nothing_*_amd64.deb \
		siakhooi-java-do-nothing_*_amd64.deb.sha256sum \
		siakhooi-java-do-nothing_*_amd64.deb.sha512sum

build:
	mvn clean verify
	scripts/shellcheck.sh
	scripts/build-deb.sh

test-man:
test-man:
	pandoc src/deb/md/java-do-nothing.1.md -s -t man | man -l -
