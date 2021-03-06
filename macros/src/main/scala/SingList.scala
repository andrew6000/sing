

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.reflect.macros.whitebox.Context


// scala.::(t1, scala.::(t2, scala.Nil)) --> sing.Cons(t1, sing.Cons(t2, sing.Nil))

private object SingList {
    def inTerm(c: Context)(ns: scala.List[c.Tree]): c.Tree = {
        import c.universe._

        val vnil: c.Tree = q"${sing_(c)}.Nil"
        val vcons: c.Tree = q"${sing_(c)}.Cons"

        ns.foldRight(vnil) { (n, x) => Apply(vcons, scala.List(n, x)) }
    }

    def inType(c: Context)(ns: scala.List[c.Tree]): c.Tree = {
        import c.universe._

        val tnil: c.Tree = tq"${sing_(c)}.Nil"
        val tcons: c.Tree = tq"${sing_(c)}.Cons"

        ns.foldRight(tnil) { (n, x) => AppliedTypeTree(tcons, scala.List(n, x)) }
    }
}
