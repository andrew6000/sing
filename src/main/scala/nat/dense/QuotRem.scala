

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object QuotRem {
     def apply[x <: Dense, y <: Dense](x: x, y: y): apply[x, y] =
        `if`(y.size.lt(x.size), Then(x, y), Else(x, y)).apply.asProduct2.asInstanceOf[apply[x, y]]
    type apply[x <: Dense, y <: Dense] =
        `if`[y#size#lt[x#size], Then[x, y], Else[x, y]]#apply#asProduct2

    case class Then[x <: Dense, y <: Dense](x: x, y: y) extends Function0 {
        type self = Then[x, y]

        lazy val count2: count2 = x.size.minus(y.size)
            type count2         = x#size#minus[y#size]

        lazy val count1: count1 = count2.decrement
            type count1         = count2#decrement

        lazy val canMinus1: canMinus1 = y.shiftLeftBy(count1)
            type canMinus1            = y#shiftLeftBy[count1]

        lazy val canMinus2: canMinus2 = canMinus1.shiftLeft
            type canMinus2            = canMinus1#shiftLeft

        lazy val quot1: quot1 = _1.shiftLeftBy(count1)
            type quot1        = _1#shiftLeftBy[count1]

        lazy val quot2: quot2 = _1.shiftLeftBy(count2)
            type quot2        = _1#shiftLeftBy[count2]

        override  def apply: apply =
            `if`(canMinus2.lteq(x), Next(x, y, quot2, canMinus2), Next(x, y, quot1, canMinus1)).apply.asInstanceOf[apply]
        override type apply =
            `if`[canMinus2#lteq[x], Next[x, y, quot2, canMinus2], Next[x, y, quot1, canMinus1]]#apply
    }

    case class Next[x <: Dense, y <: Dense, quot <: Dense, canMinus <: Dense](x: x, y: y, quot: quot, canMinus: canMinus) extends Function0 {
        type self = Next[x, y, quot, canMinus]

        lazy val r: r = x.minus(canMinus).quotRem(y)
            type r    = x#minus[canMinus]#quotRem[y]

        override  def apply: apply = Tuple2(quot.plus(r._1.asNat), r._2)
        override type apply        = Tuple2[quot#plus[r#_1#asNat], r#_2]
    }

    case class Else[x <: Dense, y <: Dense](x: x, y: y) extends Function0 {
        type self = Else[x, y]
        override  def apply: apply = `if`(x.lt(y), const0(Tuple2(Nil, x)), ElseElse(x, y)).apply
        override type apply        = `if`[x#lt[y], const0[Tuple2[Nil, x]], ElseElse[x, y]]#apply
    }

    case class ElseElse[x <: Dense, y <: Dense](x: x, y: y) extends Function0 {
        type self = ElseElse[x, y]
        override  def apply: apply = Tuple2(_1, x.minus(y))
        override type apply        = Tuple2[_1, x#minus[y]]
    }
}


private[sing]
object ConsShiftLeftBy {
     def apply[x <: Dense, n <: Peano](x: x, n: n): apply[x, n] = n.foldRight(x, Step).asNat.asDense
    type apply[x <: Dense, n <: Peano]                          = n#foldRight[x, Step]#asNat#asDense

    val Step = new Step
    class Step extends Function2 {
        type self = Step
        override  def apply[a <: Any, b <: Any](a: a, b: b): apply[a, b] = Cons(`false`, b.asNat.asDense)
        override type apply[a <: Any, b <: Any]                          = Cons[`false`, b#asNat#asDense]
    }
}