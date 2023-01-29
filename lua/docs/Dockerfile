FROM --platform=linux/amd64 golang:1.15.3-alpine3.12 AS build-env

RUN apk update && apk add --no-cache \ 
	git \
	lua5.3 \
	&& rm -rf /var/cache/apk/*

COPY lua/docs/go /go
COPY lua/docs/content /www
COPY lua/docs/parser /parser
COPY lua/modules /modules

RUN cd /parser && ./parse.sh

WORKDIR /go/src/website

EXPOSE 80
ENTRYPOINT ["ash"]

#################################

FROM build-env AS builder

RUN go build

ENTRYPOINT ["./website"]

#################################

FROM --platform=linux/amd64 alpine:3.12 AS website

# first copy the resources
COPY --from=builder /www /www
# then the executable
COPY --from=builder /go/src/website/website /website

EXPOSE 80
WORKDIR /

ENV RELEASE=1

ENTRYPOINT ["/website"]

