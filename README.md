# purescript-node-http

## JVM tests

`./bin/test` delegates to the [common runner](../javapurs/docs/testing.md#port-particulier) as `node-http`, but currently exits **1** with an unsupported-completion diagnostic: `Test.Main` starts HTTP/HTTPS servers, timers and `launchAff_` without a joined completion action.
`./bin/test --help` is read-only. Even with `--clean`, this unsupported protocol is rejected before build/workspace creation; the checkout and its outputs are preserved. See the [protocol inventory](../javapurs/docs/port-launchers.md).

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
