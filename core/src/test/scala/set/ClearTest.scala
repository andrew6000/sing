

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class ClearTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m1    = SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m1: m1 = SortedSet.empty(Nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type n = m1#clear
        val n: n = m1.clear

        AssertTrue[n#isEmpty]
        assertTrue(n.isEmpty.unsing)
    }

}
