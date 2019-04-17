# Welcome to igniter

A [Giter8](http://www.foundweekends.org/giter8/) template for kickstarting a new opinionated Scala project with the following features:

* a tidy `build.sbt` inspired by [sbt-fresh](https://github.com/sbt/sbt-fresh)
* slim base: almost all (upcoming) features are optional
* clear and colorful logging on the console when running in dev mode (upcoming)
* an empty `.gitignore` (read more [here](#why-is-gitignore-empty))

## Configuration Options

| Property | Required | Default             | Description                              | Example         |
| -------- | -------- | ------------------- | ---------------------------------------- | --------------- |
| name     | true     | -                   | The project name.                        | awesome-project |
| package  | false    | value of `$package` | The base package name.                   | io.awesome      |

## Roadmap

Have a look at the [project board](https://github.com/ontherocks-io/igniter/projects/2).

## Why is `.gitignore` empty?

Trying to create and maintain a `.gitignore` file that covers all IDEs, build tools and operating systems out there doesn't seem like the right approach to me. Instead, everybody should create a personal `.gitignore` covering their personal setup and put those rules into their (personal) global `.gitignore`.

You can usually find that global `.gitignore` file at `$HOME/.gitignore`.

What should go into the project-specific `.gitignore`? For example, files that are created by this specific project (like log files) that you don't want to put under version control.

## Template license

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.
