# Scala.js
* https://www.scala-js.org/
* https://github.com/scala-js/scala-js

> Harness the Scala and JavaScript ecosystems together.
> 
> Develop robust apps for browsers, Node.js, and serverless.

# Tutorials

Prerequisites
```shell
$ node -v
v18.20.8
$ npm -v
10.8.2
$ sbt -version
sbt runner version: 1.11.7
```

IDE: recommend VS Code with the Metals extension.

## Getting Started with Scala.js and Vite
* [LiveChart_Vite.scala](../codes/Scala.js/livechart/src/main/scala/livechart/LiveChart_Vite.scala)

## Build UIs with Laminar
* [LiveChart_Laminar.scala](../codes/Scala.js/livechart/src/main/scala/livechart/LiveChart_Laminar.scala)

Functional Reactive Programming(FPR)
- `Var`: read-write container
- `Signal`: read-only view of some time-varying value
```scala
val intVar: Var[Int] = Var(1)
val intSignal: Signal[Int] = intVar.signal
val times2Signal: Signal[Int] = intSignal.map(_ * 2)
```

## Integrate JavaScript libraries with ScalablyTyped

## Older tutorials
Here are some older tutorials, which may still provide value:
- The old [basic tutorial](https://www.scala-js.org/doc/tutorial/basic/)
- [Hands-on Scala.js](https://lihaoyi.github.io/hands-on-scala-js), an extensive tutorial in eBook format
- [SPA tutorial](https://github.com/ochrons/scalajs-spa-tutorial) for writing a Single-Page-Application using React

Additionally, take a look at the available [Project Skeletons](#project-skeletons) to start with a pre-existing template.

### Basic tutorial
* https://www.scala-js.org/doc/tutorial/basic/

# Scala.js for JavaScript developers
## From ES6 to Scala: Basics
## From ES6 to Scala: Collections
## From ES6 to Scala: Advanced

# Project setup
* [Scala.js sbt Plugin](https://www.scala-js.org/doc/sbt-plugin.html)

## Building the application
## Dependencies
## Emitting modules

```scala
import scala.scalajs.js.annotation.{JSImport, JSExportTopLevel, JSExport}

@JSExportTopLevel
@JSExport

@JSImport
```

## JavaScript Environments
## Emitting WebAssembly
## Cross-building
## Testing
## Linking errors

# JavaScript interoperability

# Scala.js API

# Semantics of Scala.js

# Internals

# Libraries
## JavaScript facades
Interact with JavaScript libraries in a safe, strongly-typed manner.

## Scala libraries
Libraries traditionally running on the JVM, now running on JS as well!

## Testing
Make sure your code starts correct and stays correct.

## Project Skeletons
Get started quickly.

# Tools
* [sbt ScalaJSPlugin](https://github.com/scala-js/scala-js/blob/main/sbt-plugin/src/main/scala/org/scalajs/sbtplugin/ScalaJSPlugin.scala)
* [scala-js-dom](https://github.com/scala-js/scala-js-dom): Statically typed DOM API for Scala.js.
* [vite-plugin-scalajs](https://github.com/scala-js/vite-plugin-scalajs): A Vite plugin for Scala.js.

# See Also
* [Is there any book or course about Scala front-end development?](https://www.reddit.com/r/scala/comments/173jznv/is_there_any_book_or_course_about_scala_frontend/) - Reddit 2023-10-09
* [Scala 3 — Book - Scala for JavaScript Developers](../books/Scala3Book.md#scala-for-javascript-developers)
* [Hands-on Scala.js](https://www.lihaoyi.com/hands-on-scala-js/#Hands-onScala.js): Writing client-side web applications in Scala
* [Typelevel Rite of Passage](https://rockthejvm.com/courses/typelevel-rite-of-passage): Create a full-stack Scala application using the Typelevel stack in our comprehensive course: learn to integrate features like credit card checkout and emails. Perfect for hands-on, real-world development experience.
  * The Tech Stack
    * **Cats**: The functional programming library for Scala. We will use it to make our code modular, expressed in terms of capabilities.
    * **Cats Effect**: The Scala library that allows us to write composable and high-performance applications with pure functional programming. Every action we perform is built with Cats Effect.
    * **Doobie**: The Typelevel library that allows us to work with databases, using type-safe queries. We will use PostgreSQL as an actual database.
    * **Http4s**: With this Typelevel library we'll build our REST APIs with JSON payloads, automatic validation, incremental content loading with pagination etc., as well as manage authentication, authorization with JWTs and role-based access control.
    * **Tyrian**: A lightweight Scala 3 library for single-page applications in a purely functional way, Elm-style. While not "officially" a Typelevel project, it is based on Cats Effect and FS2 to manage application state. Our entire frontend is built with Tyrian (routing, authentication flow, checkout, error/success UI state, fetching data from backend)
    * Honorable Mentions
      * **PureConfig** for configuration
      * **FS2** for incremental loading on the backend
      * **FS2** for SPA history management on the frontend
      * **TSec** for JWT authorization and RBAC
      * **Circe** for JSON
      * **Log4Cats** for purely-functional logging
      * **ScalaTest** with TestContainers wrapped in Cats Effect


## Tools
- Vite: Next Generation Frontend Tooling
- [Chart.js](https://www.chartjs.org/): Simple yet flexible JavaScript charting library for the modern web
- [SCRiBBLE](https://scribble.ninja/): Try Scala.js in your browser.
* [Laminar](https://laminar.dev/): Native Scala.js library for building user interfaces
  * [raquo/Laminar](https://github.com/raquo/Laminar): Laminar is a small library that lets you build web application interfaces, keeping UI state in sync with the underlying application state. Its simple yet expressive patterns build on a rock solid foundation of **Airstream** observables and the Scala.js platform.
  * [Laminar bindings for the SAP ui5 web components library](https://github.com/sherpal/LaminarSAPUI5Bindings)
  * [Full Stack Scala JVM on fly.io demo](https://github.com/sherpal/FlyIOScalaJVMDemo): [doc](https://itnext.io/deploying-a-full-stack-scala-application-on-fly-io-f80ca9de9b13)
- [ScalablyTyped](https://scalablytyped.org/docs/readme.html): ScalablyTyped enables you use any Javascript project with Typescript types and use it from Scala.js.