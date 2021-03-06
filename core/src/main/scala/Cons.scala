

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


final case class Cons[x <: Any, xs <: List](override val head: x, override val tail: xs) extends AsList {
    override type self = Cons[x, xs]

    override  def isEmpty: isEmpty = `false`
    override type isEmpty          = `false`

    override type head = x
    override type tail = xs
}
