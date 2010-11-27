

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import okomok.sing.{assert => dassert}
import nat.dense.Literal._
import junit.framework.Assert._


class RepeatTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type rs = list.repeat[_3]
        val rs: rs = list.repeat(_3)
        free.assert[rs#take[_4]#equalWith[_3 :: _3 :: _3 :: _3 :: Nil, nat.naturalOrdering]]
        assertEquals(_3 :: _3 :: _3 :: _3 :: Nil, rs.take(_4))
    }

}