

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class ToListTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = SortedMap.empty[Nat.naturalOrdering]#put[_4, _5]#put[_3, _4]#put[_1, _2]#put[_2, _3]#put[_5, _6]#put[_0, _1]
        val m: m = SortedMap.empty(Nat.naturalOrdering).put(_4, _5).put(_3, _4).put(_1, _2).put(_2, _3).put(_5, _6).put(_0, _1)

        type l   = Tuple2[_0, _1] :: Pair[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_3, _4] :: Tuple2[_4, _5] :: Tuple2[_5, _6] :: Nil
        val l: l = Pair(_0, _1) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_3, _4) :: Tuple2(_4, _5) :: Tuple2(_5, _6) :: Nil
        AssertEq[l, m#asList#force]
        assertEquals(l, m.asList)

        type kl    = _0 :: _1 :: _2 :: _3 :: _4 :: _5 :: Nil
        val kl: kl = _0 :: _1 :: _2 :: _3 :: _4 :: _5 :: Nil
        AssertEq[kl, m#keyList#force]
        assertEquals(kl, m.keyList)

        type vl    = _1 :: _2 :: _3 :: _4 :: _5 :: _6 :: Nil
        val vl: vl = _1 :: _2 :: _3 :: _4 :: _5 :: _6 :: Nil
        AssertEq[vl, m#valueList#force]
        assertEquals(vl, m.valueList)
   }

}
