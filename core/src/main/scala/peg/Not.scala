

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object Not {
     def apply[p <: Peg](p: p): apply[p] = Impl(p)
    type apply[p <: Peg]                 = Impl[p]

    final case class Impl[p <: Peg](p: p) extends AbstractPeg with ZeroWidth {
        type self = Impl[p]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs), xs)
        override type parse[xs <: List]                    = _aux[p#parse[xs], xs]

        private[this]  def _aux[r <: Result, xs <: List](r: r, xs: xs): _aux[r, xs] =
            `if`(r.successful, const0(Failure(xs)), const0(Success(Nil, xs))).apply.asPegResult.asInstanceOf[_aux[r, xs]]
        private[this] type _aux[r <: Result, xs <: List] =
            `if`[r#successful, const0[Failure[xs]], const0[Success[Nil, xs]]]#apply#asPegResult
    }
}
