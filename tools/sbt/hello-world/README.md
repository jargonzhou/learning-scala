# hello-world
* https://www.scala-sbt.org/1.x/docs/sbt-by-example.html

# Setup
```shell
$ sbt new scala/hello-world.g8
[info] [launcher] getting org.scala-sbt sbt 1.11.7  (this may take some time)...
[info] [launcher] getting Scala 2.12.20 (for sbt)...
[info] resolving Giter8 0.18.0...
A template to demonstrate a minimal Scala application 

name [Hello World template]: hello-world

Template applied in D:\workspace\github\learning-scala\tools\sbt\.\hello-world
```

# Usage
```shell
$ sbt compile

$ sbt
sbt:hello-world> compile

sbt:hello-world> run
[info] running Main
Hello sbt!

# custom tasks
sbt:hello-world> sampleStringTask
starting...
sum: 3
s: 3                           
stopping...
sbt:hello-world> sampleIntTask2
starting...
sum: 3
stopping...
```