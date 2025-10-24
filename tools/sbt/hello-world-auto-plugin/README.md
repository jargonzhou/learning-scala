# hello-world-auto-plugin
* https://www.scala-sbt.org/1.x/docs/Plugins.html#Creating+an+auto+plugin

# Setup
```shell
$ sbt new scala/scala-seed.g8
A minimal Scala project.

name [Scala Seed Project]: hello-world-auto-plugin
```

# Usage
- [hello-world/project/hello-world-auto-plugin.sbt](../hello-world/project/hello-world-auto-plugin.sbt)

```shell
sbt:hello-world> plugins
    example.HelloPlugin
    example.ObfuscatePlugin

# HelloPlugin
sbt:hello-world> tasks -V hello     # task: hello
say hello
sbt:hello-world> hello / hello
[info] hi
[info] hi
sbt:hello-world> hello              # command: hello
Hi!
sbt:hello-world> helloGreeting      # setting: helloGreeting
[info] helloCore / helloGreeting
[info]  hi
[info] helloGreeting
[info]  hi

# ObfuscatePlugin
sbt:hello-world> tasks -V obfuscate              # task: obfuscate
obfuscate files.
sbt:hello-world> obfuscate
sbt:hello-world> settings -V obfuscateLiterals   # setting: obfuscateLiterals
obfuscate literals.
sbt:hello-world> obfuscate / obfuscateLiterals
[info] helloCore / Compile / obfuscate / obfuscateLiterals
[info]  false
[info] obfuscate / obfuscateLiterals
[info]  true
```
