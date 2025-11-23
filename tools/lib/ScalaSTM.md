# ScalaSTM
* https://index.scala-lang.org/scala-stm/scala-stm
* https://github.com/scala-stm/scala-stm
* https://nbronson.github.io/scala-stm/


ScalaSTM is a single JAR with no dependencies, and includes
- An API that supports multiple STM implementations
- A reference implementation based on CCSTM
- Scalable concurrent sets and maps (with fast snapshots) that can be used inside or outside transactions

ScalaSTM provides a mutable cell called a `Ref`. If you build a shared data structure using immutable objects and `Ref`-s, then you can access it from multiple threads or actors. No `synchronized`, no deadlocks or race conditions, and good scalability. Included are concurrent sets and maps, and we also have an easier and safer replacement for `wait` and `notifyAll`.

# See Also
* [Multiverse Software Transactional Memory](https://github.com/pveentjer/Multiverse): Software Transactional Memory Implementation for the JVM
* [is akka stm deprecated? does Akka agent replaces it ?](https://groups.google.com/g/akka-user/c/3JWz-X5dbe8)
