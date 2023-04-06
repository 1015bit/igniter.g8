# Igniter

![Scala CI](https://github.com/1015bit/igniter.g8/workflows/Scala%20CI/badge.svg?branch=main)

A [Giter8](http://www.foundweekends.org/giter8/) template for kickstarting a new opinionated Scala project with the following features:

* a tidy `build.sbt`
* [cats-effect](https://github.com/typelevel/cats-effect)
* logging with [scribe](https://github.com/outr/scribe)
* formatting with [scalafmt](https://scalameta.org/scalafmt/)
* formatting rules loosely based on Typelevel [Cats](https://github.com/typelevel/cats)
* [sbt-tpolecat](https://github.com/typelevel/sbt-tpolecat) for compiler options
* [MUnit](https://scalameta.org/munit/) as test framework
* CI using GitHub actions (optional)
* no IDE/OS specfic clutter in `.gitignore`

Its main use case are personal projects, so it currently doesn't support production-related functionality like

* release management
* logging/metrics suitable for production
* more sophisticated header/license management

## Usage

```
sbt new 1015bit/igniter.g8
```

## Template license

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.
