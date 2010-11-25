

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


private[sing]
final case class MakeCons[a <: Any](a: a) extends Function1 {
    type self = MakeCons[a]
    override  def apply[b <: Any](b: b): apply[b] = a :: b.asList
    override type apply[b <: Any]                 = a :: b#asList
}
