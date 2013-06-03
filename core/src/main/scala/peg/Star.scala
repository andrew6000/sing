

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object Star {
     def apply[p <: Peg](p: p): apply[p] = Impl(p)
    type apply[p <: Peg]                 = Impl[p]

    final case class Impl[p <: Peg](p: p) extends AsPeg {
        override type self = Impl[p]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs))
        override type parse[xs <: List]                    = _aux[p#parse[xs]]

        private[this]  def _aux[r <: PegResult](r: r): _aux[r] =
            `if`(r.successful, Then(p, r), const0(PegSuccess(Nil, r.next))).apply.asPegResult.asInstanceOf[_aux[r]]
        private[this] type _aux[r <: PegResult] =
            `if`[r#successful, Then[p, r], const0[PegSuccess[Nil, r#next]]]#apply#asPegResult
    }

    final case class Then[p <: Peg, r <: PegResult](p: p, r: r) extends AsFunction0 {
        override type self = Then[p, r]
        override  def apply: apply = Star.apply(p).parse(r.next).map(MakeCons(r.get)).asInstanceOf[apply]
        override type apply        = Star.apply[p]#parse[r#next]#map[MakeCons[r#get]]
    }
}
