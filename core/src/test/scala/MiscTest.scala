

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing._
import com.github.okomok.sing.Test.CompileError._


trait MiscTest {

    def depfoo[n <: Nat](n: n) {
        val x = n.plus(Dense._1)
        val y = id(n).plus(Dense._1)

        val _x = typeOf(x)
        type x = _x.apply

        val _y = typeOf(y)
        type y = _y.apply
        type r = n#plus[Dense._1]


        // x <:< r, but not r <:< x
        val rx: r = x

        Test.expectError(AnyError) {"""
            val xr: x = null.asInstanceOf[r]
        """}

        // y =:= x
        val ry: r = y
        val yr: y = null.asInstanceOf[r]

        ()
    }

    trait Foo[T] {
        val _self = typeOf(this)
        type self = _self.apply
        type self_ = this.type
        val _self__ = typeOf(id(null.asInstanceOf[this.type]))
        type self__ = _self__.apply

        implicitly[self =:= self__ ]

        implicitly[self_ <:< self]

        Test.expectError(CannotProve) {"""
            implicitly[self <:< self_]
        """}
    }
}



