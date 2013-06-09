

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Drop {
     def apply[xs <: List, n <: Nat](xs: xs, n: n) =
        `if`(xs.isEmpty.or(n.isZero), Const(xs), Else(xs, n)).apply.asList.asInstanceOf[apply[xs, n]]
    type apply[xs <: List, n <: Nat] =
        `if`[xs#isEmpty#or[n#isZero], Const[xs], Else[xs, n]]#apply#asList

    case class Else[xs <: List, n <: Nat](xs: xs, n: n) extends AsFunction0 {
        override type self = Else[xs, n]
        override  def apply: apply = Drop.apply(xs.tail, n.decrement)
        override type apply        = Drop.apply[xs#tail, n#decrement]
    }
}


private[sing]
object DropWhile {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] =
        `if`(xs.isEmpty, Const(xs), Else(xs, f)).apply.asList
    type apply[xs <: List, f <: Function1] =
        `if`[xs#isEmpty, Const[xs], Else[xs, f]]#apply#asList

    case class Else[xs <: List, f <: Function1](xs: xs, f: f) extends AsFunction0 {
        override type self = Else[xs, f]
        override  def apply: apply = `if`(f.apply(xs.head).asBoolean, ElseThen(xs, f), Const(xs)).apply.asInstanceOf[apply]
        override type apply        = `if`[f#apply[xs#head]#asBoolean, ElseThen[xs, f], Const[xs]]#apply
    }

    case class ElseThen[xs <: List, f <: Function1](xs: xs, f: f) extends AsFunction0 {
        override type self = ElseThen[xs, f]
        override  def apply: apply = DropWhile.apply(xs.tail, f)
        override type apply        = DropWhile.apply[xs#tail, f]
    }
}
