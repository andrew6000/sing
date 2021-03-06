

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


private[sing]
object Equal {
     def apply[xs <: List, ys <: List, ee <: Option](xs: xs, ys: ys, ee: ee): apply[xs, ys, ee] =
        `if`(id(xs).isEmpty.and(id(ys).isEmpty), Const(`true`), `if`(id(xs).isEmpty.nequal(id(ys).isEmpty), Const(`false`), Else(xs, ys, ee))).apply.asBoolean
    type apply[xs <: List, ys <: List, ee <: Option] =
        `if`[id[xs]#isEmpty#and[id[ys]#isEmpty], Const[`true`], `if`[id[xs]#isEmpty#nequal[id[ys]#isEmpty], Const[`false`], Else[xs, ys, ee]]]#apply#asBoolean

    case class Else[xs <: List, ys <: List, ee <: Option](xs: xs, ys: ys, ee: ee) extends AsFunction0 {
        override type self = Else[xs, ys, ee]
        private[this] lazy val _ee: _ee = ee.getOrNaturalEquiv(xs.head)
        private[this]     type _ee      = ee#getOrNaturalEquiv[xs#head]
        override  def apply: apply = `if`(id(_ee).equiv(id(xs).head, id(ys).head), Then(xs, ys, ee), Const(`false`)).apply
        override type apply        = `if`[id[_ee]#equiv[id[xs]#head, id[ys]#head], Then[xs, ys, ee], Const[`false`]]#apply
    }

    case class Then[xs <: List, ys <: List, ee <: Option](xs: xs, ys: ys, ee: ee) extends AsFunction0 {
        override type self = Then[xs, ys, ee]
        override  def apply: apply = Equal.apply(xs.tail, ys.tail, ee)
        override type apply        = Equal.apply[xs#tail, ys#tail, ee]
    }
}
