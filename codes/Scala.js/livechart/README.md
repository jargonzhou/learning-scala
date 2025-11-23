## Scala.js - Vite project template
* https://www.scala-js.org/doc/tutorial/scalajs-vite.html
* https://www.scala-js.org/doc/tutorial/basic/
* https://www.scala-js.org/doc/tutorial/laminar.html

----------------

## Usage

This is a sbt project configured specifically for Scala.js and Vite.

Setup
```shell
$ sbt new
 m) scala-js/vite.g8                  - A Scala.JS + Vite project

# additional materials: npm create vite@4.1.0
```

Dependencies
- Scala 3.7.3
- Vite 4.1.0+
- sbt plugin `"org.scala-js" % "sbt-scalajs" % "1.20.1"`
- `"org.scala-js" %%% "scalajs-dom" % "2.8.1"`
- `"@scala-js/vite-plugin-scalajs": "^1.0.0"`
- `"com.raquo" %%% "laminar" % "17.0.0"`
- ScalablyTyped
  - `"org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta44"`
```shell
npm install -S chart.js@2.9.4
npm install -D @types/chart.js@2.9.29 typescript@4.9.5
```

Dev
```shell
# Generate JavaScript: target\scala-3.7.3\livechart-fastopt\main.js
$ sbt ~fastLinkJS
```
```shell
$ npm run dev
```

Build
```shell
$ npm run build
$ npm run preview
```


### Starting dev server

First thing in order to run this project, is to install vite dependency. To do it run
`npm install`
To start Scala.js - Vite developement server, you first need to start incremental compilation for code.
It is done by running `sbt ~fastLinkJS` directly from shell of just `~fastLinkJS` from SBT shell instance.
The next step is to start the server. To do it, run `yarn dev` or if you use npm `npm run dev` in your terminal.

### Adding new dependencies

To add new dependencies, do it with 
`npm install ${dependencyName}`
