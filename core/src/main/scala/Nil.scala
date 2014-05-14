

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


sealed abstract class Nil extends AsList {
    override type self = Nil

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    private[sing] lazy val _head = makro.NoSuchElement("Nil.head")
    override  def head: head = _head.self
    override type head       = _head.self

    private[sing] lazy val _tail = makro.NoSuchElement("Nil.tail")
    override  def tail: tail = _tail.self
    override type tail       = _tail.self

    def unapply(that: Nil) = true
}


private[sing]
object _TermOfNil {
    val apply: Nil = new Nil{}
}
