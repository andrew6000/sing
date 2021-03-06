

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class EqualWithTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_5, _6] :: Tuple2[_0, _1] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_5, _6) :: Tuple2(_0, _1) :: Nil
        type m   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs2)

        AssertEq[`true`, m#equalWith[m, Nat.naturalOrdering]]
        AssertEq[`true`, m#equalWith[m2, Nat.naturalOrdering]]
        AssertEq[`true`, m2#equalWith[m, Nat.naturalOrdering]]
        assertEquals(`true`, m.equalWith(m2, Nat.naturalOrdering))
    }

    def testTrivialDifferentKey {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_15, _6] :: Tuple2[_0, _1] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_15, _6) :: Tuple2(_0, _1) :: Nil
        type m   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs2)

        AssertEq[`true`, m#equalWith[m, Nat.naturalOrdering]]
        AssertEq[`false`, m#equalWith[m2, Nat.naturalOrdering]]
        AssertEq[`false`, m2#equalWith[m, Nat.naturalOrdering]]
        assertEquals(`false`, m.equalWith(m2, Nat.naturalOrdering))
    }

    def testTrivialDifferentValue {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _12] :: Tuple2[_2, _3] :: Tuple2[_5, _6] :: Tuple2[_0, _1] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _12) :: Tuple2(_2, _3) :: Tuple2(_5, _6) :: Tuple2(_0, _1) :: Nil
        type m   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs2)

        AssertEq[`true`, m#equalWith[m, Nat.naturalOrdering]]
        AssertEq[`false`, m#equalWith[m2, Nat.naturalOrdering]]
        AssertEq[`false`, m2#equalWith[m, Nat.naturalOrdering]]
        assertEquals(`false`, m.equalWith(m2, Nat.naturalOrdering))
    }

    def testTrivialDifferentSize {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_5, _6] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_5, _6) :: Nil
        type m   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = SortedMap.empty[Nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = SortedMap.empty(Nat.naturalOrdering).put(_8, _9).putList(xs2)

        AssertEq[`true`, m#equalWith[m, Nat.naturalOrdering]]
        AssertEq[`false`, m#equalWith[m2, Nat.naturalOrdering]]
        AssertEq[`false`, m2#equalWith[m, Nat.naturalOrdering]]
        assertEquals(`false`, m.equalWith(m2, Nat.naturalOrdering))
    }

    def testTrivialNil {
        type m   = SortedMap.empty[Nat.naturalOrdering]
        val m: m = SortedMap.empty(Nat.naturalOrdering)
        type m2   = SortedMap.empty[Nat.naturalOrdering]
        val m2: m2 = SortedMap.empty(Nat.naturalOrdering)

        AssertEq[`true`, m#equalWith[m, Nat.naturalOrdering]]
        AssertEq[`true`, m#equalWith[m2, Nat.naturalOrdering]]
        AssertEq[`true`, m2#equalWith[m, Nat.naturalOrdering]]
        assertEquals(`true`, m.equalWith(m2, Nat.naturalOrdering))
   }

}
