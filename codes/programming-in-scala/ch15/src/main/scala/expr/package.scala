package object expr {
  def simplifyTop(expr: Expr): Expr = expr match { // pattern matching
    case UnOp("-", UnOp("-", e))  => e // double negation
    case BinOp("+", e, Number(0)) => e // adding zero
    case BinOp("*", e, Number(1)) => e // multiplying by one
    case _                        => expr // default case
  }

  def simplifyAll(expr: Expr): Expr = expr match { // case order matters
    case UnOp("-", UnOp("-", e)) => simplifyAll(e) // - is its own inverse
    case BinOp("+", e, Number(0)) =>
      simplifyAll(e) // 0 is a neutral element for +
    case BinOp("*", e, Number(1)) =>
      simplifyAll(e) // 1 is a neutral element for *
    case UnOp(op, e)     => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _               => expr
  }
}
