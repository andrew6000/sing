

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
class Common extends CommonLiteral {
    @annotation.returnThis
    val Literal: CommonLiteral = this

    @annotation.equivalentTo("new Nil{}")
    val Nil: Nil = _Dense.Nil

    @annotation.aliasOf("Cons")
     val :: = Cons
    type ::[x <: Boolean, xs <: Dense] = Cons[x, xs]
}