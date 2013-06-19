

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Abandon {
    def apply(x: _): scala.Unit = macro impl

    def impl(c: Context)(x: c.Tree): c.Expr[scala.Unit] = {
        import c.universe._
        reify(())
    }
}