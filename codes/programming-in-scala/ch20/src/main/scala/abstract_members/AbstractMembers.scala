package abstract_members

trait Abstract {
  // 抽象类型成员: abstract type
  type T
  // 抽象方法
  def transform(x: T): T
  // 抽象val
  val initial: T
  // 抽象var
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial
}
