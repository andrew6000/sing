

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


private[sing]
object Plus {
     def apply[p <: Peg](p: p): apply[p] = Impl(p)
    type apply[p <: Peg]                 = Impl[p]

    final case class Impl[p <: Peg](p: p) extends AbstractPeg {
        type self = Impl[p]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs))
        override type parse[xs <: List]                    = _aux[p#parse[xs]]

        private  def _aux[r <: Result](r: r): _aux[r] =
            `if`(r.successful, Star.Then(p, r), const0(r)).apply.asPegResult.asInstanceOf[_aux[r]]
        private type _aux[r <: Result] =
            `if`[r#successful, Star.Then[p, r], const0[r]]#apply#asPegResult
    }
}
