FROM debian:stretch-20200607

ARG JDK
RUN \
	apt-get update && \
	apt-get install --no-install-recommends --assume-yes \
		${JDK}-jdk-headless \
		ant \
		ant-optional && \
	rm -rf /var/lib/apt/lists/*

RUN \
	mkdir /var/dependencies-cache && \
	chown 1001:1001 /var/dependencies-cache

LABEL purpose=jenkins
LABEL jdk=${JDK}
LABEL ant=yes
LABEL ant-optional=yes
