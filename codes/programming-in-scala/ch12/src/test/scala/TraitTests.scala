class TraitTests extends munit.FunSuite {
  test("Philosophical") {
    val frog = new Frog
    frog.philosophize()

    val phil: Philosophical = frog
    phil.philosophize()
  }

  test("Rectangular") {
    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
    assertEquals(rect.left, 1)
    assertEquals(rect.right, 10)
    assertEquals(rect.width, 9)
  }

  test("Ordered") {
    val half = new Rational(1, 2)
    val third = new Rational(1, 3)
    assert(!(half < third))
    assert(half > third)
  }

  test("Stackable Modifications") {
    val queue = new BasicIntQueue
    queue.put(10)
    queue.put(20)
    assertEquals(queue.get(), 10)

    class MyQueue extends BasicIntQueue with Doubling
    val myQueue = new MyQueue
    myQueue.put(10)
    assertEquals(myQueue.get(), 20)
    val myQueue2 = new BasicIntQueue with Doubling // directly new
    myQueue2.put(10)
    assertEquals(myQueue2.get(), 20)
  }

  test("order of trait is significant") {
    val queue = new BasicIntQueue with Incrementing with Filtering
    // traits futher to the right take effect first
    // 1 2
    queue.put(-1); queue.put(0); queue.put(1)
    assertEquals(queue.get(), 1)
    assertEquals(queue.get(), 2)
    intercept[IndexOutOfBoundsException] {
      queue.get()
    }

    val queue2 = new BasicIntQueue with Filtering with Incrementing
    // 0 1 2
    queue2.put(-1); queue2.put(0); queue2.put(1)
    assertEquals(queue2.get(), 0)
    assertEquals(queue2.get(), 1)
    assertEquals(queue2.get(), 2)

    // define classes with these traits
    // with 1 trait: 3
    // with 2 trait2: 6
    // with 3 trait2: 6
  }

  test("Linearization") {
    class Animal
    trait Furry extends Animal
    trait HasLegs extends Animal
    trait FourLegged extends HasLegs
    class Cat extends Animal with Furry with FourLegged

    // steps
    // 1: Animal, AnyRef, Any
    // 2: Furry, Animal, AnyRef, Any
    // 3: FourLegged, HasLegs, Furry, Animal, AnyRef, Any
    // 4: Cat, FourLegged, HasLegs, Furry, Animal, AnyRef, Any
  }
}
