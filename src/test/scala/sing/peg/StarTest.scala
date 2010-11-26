

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._
import peg.fromList


class StarTest extends org.scalatest.junit.JUnit3Suite {

    def testNilInput {
        type xs    = Nil
        val xs: xs = Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#star
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).star
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        free.assert[r]
        assertTrue(r.unsing)
    }

    def testOneInput {
        type xs    = _3 :: _5 :: _9 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#star
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).star
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        free.assert[r]
        assertTrue(r.unsing)
    }

    def testLongInput {
        type xs    = _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#star
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).star
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        free.assert[r]
        assertTrue(r.unsing)
    }

    def testParseNoConsume {
        type xs    = _4 :: _3 :: _5 :: _9 :: Nil
        val xs: xs = _4 :: _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#star
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).star
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        free.assert[r#successful]
        assertTrue(r.successful.unsing)
        free.assertSame[Nil, r#get#force]
        assertEquals(Nil, r.get)
        free.assertSame[xs, r#next#force]
        assertEquals(xs, r.next)
    }

    def testParseConsume {
        type xs    = _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _10 :: _11 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _3 :: _5 :: _9 :: _10 :: _11 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#star
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).star
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        free.assert[r#successful]
        assertTrue(r.successful.unsing)
        free.assertSame[(_3 :: _5 :: _9 :: Nil) :: (_3 :: _5 :: _9 :: Nil) :: (_3 :: _5 :: _9 :: Nil) :: (_3 :: _5 :: _9 :: Nil) :: Nil, r#get#force]
        assertEquals((_3 :: _5 :: _9 :: Nil) :: (_3 :: _5 :: _9 :: Nil) :: (_3 :: _5 :: _9 :: Nil) :: (_3 :: _5 :: _9 :: Nil) :: Nil, r.get)
        free.assertSame[_10 :: _11 :: Nil, r#next#force]
        assertEquals(_10 :: _11 :: Nil, r.next)
    }

}
