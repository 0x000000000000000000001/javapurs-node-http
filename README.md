# purescript-node-http

Java port of the PureScript `node-http` package. See the
[port maintenance guide](../javapurs/docs/port-maintenance.md)
for source layout, local dependency selection and JVM validation.

## JVM tests

`./bin/test` delegates to the [common runner](../javapurs/docs/testing.md#port-particulier) as `node-http`. The wrapper awaits `testHttp`, covering local HTTP/HTTPS servers, the 426 upgrade response and the WebSocket 101 handshake with its client socket. The two upstream external-URL checks are opt-in with `JAVAPURS_HTTP_EXTERNAL=1`; the default suite is hermetic.
`./bin/test --help` is read-only and `--clean` rebuilds the backend first. See the [protocol inventory](../javapurs/docs/port-launchers.md) and [M31](../javapurs/docs/testing.md#validation-m31).

[![Latest release](http://img.shields.io/github/release/purescript-node/purescript-node-http.svg)](https://github.com/purescript/purescript-node-http/releases)
[![Build status](https://github.com/purescript-node/purescript-node-http/workflows/CI/badge.svg?branch=master)](https://github.com/purescript-node/purescript-node-http/actions?query=workflow%3ACI+branch%3Amaster)
[![Pursuit](https://pursuit.purescript.org/packages/purescript-node-http/badge)](https://pursuit.purescript.org/packages/purescript-node-http)

A wrapper for Node's [HTTP](https://nodejs.org/dist/latest-v18.x/docs/api/http.html) and [HTTPS](https://nodejs.org/dist/latest-v18.x/docs/api/https.html) APIs.

## Installation

```
spago install node-http
```

## Documentation

Module documentation is [published on Pursuit](http://pursuit.purescript.org/packages/purescript-node-http).
