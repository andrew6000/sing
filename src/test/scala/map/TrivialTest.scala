

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class TrivialTest extends org.scalatest.junit.JUnit3Suite {

    def testSingle {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering
        type s = map.sorted[o]#put[_3, Box[Int]]
        val s: s = map.sorted(o).put(_3, Box(3))

        AssertInvariant(s)

        free.assertSame[nat.dense._1, s#size]
        free.assertSame[_3, s#key]
        free.assertSame[Box[Int], s#value]
        free.assertSame[map.sorted[o], s#left]
        free.assertSame[map.sorted[o], s#right]
        free.assertSame[o, s#ord]
        ()
    }

    def testPut {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = map.sorted[o]#put[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted(o).put(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        AssertInvariant(m)

        free.assertSame[nat.dense._3, m#size]

        type v8 = m#get[_8]
        val v8: v8 = m.get(_8)
        free.assertSame[None, v8]

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        free.assertSame[Box[Char], v5]
        assertEquals('c', v5.unsing)
    }

    def testContains {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = map.sorted[o]#put[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted(o).put(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        free.assertSame[`false`, m#contains[_9]]
        free.assertSame[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = map.sorted1[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted1(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        free.assertSame[`false`, m#contains[_9]]
        free.assertSame[`true`, m#contains[_5]]
    }

    def testUnsing {
        type m   = map.sorted[nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_5, _6]
        val m: m = map.sorted(nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_5, _6)
        assertEquals(Predef.Map(1 -> 2, 3 -> 4, 5 -> 6), m.unsing)
    }

    def testDupePut {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = map.sorted[o]#put[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted(o).put(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        free.assertSame[Box[Char], v5]
        assertEquals('c', v5.unsing)

        type m2 = m.put[_5, Box[String]]
        val m2: m2 = m.put(_5, Box("hw"))
        free.assertSame[Box[String], m2#get[_5]#get]
        assertEquals("hw", m2.get(_5).get.unsing)
    }

}