

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _peano


private[sing]
object Plus {
    // fold in y, for `+` is left-associative.
     def apply[x <: Peano, y <: Peano](x: x, y: y): apply[x, y] = y.foldRight(x, Step).asNat.asPeano
    type apply[x <: Peano, y <: Peano]                          = y#foldRight[x, Step]#asNat#asPeano

    val Step = new Step
    class Step extends AsFunction2 {
        override type self = Step
        override  def apply[a <: Any, b <: Any](a: a, b: b): apply[a, b] = b.asNat.asPeano.increment
        override type apply[a <: Any, b <: Any]                          = b#asNat#asPeano#increment
    }
}
