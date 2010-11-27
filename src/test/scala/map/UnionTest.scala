

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class UnionTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = map.sorted[nat.naturalOrdering]#put[_4, _5]#put[_5, _6]#put[_0, _1]
        val m: m = map.sorted(nat.naturalOrdering).put(_4, _5).put(_5, _6).put(_0, _1)

        type m2 =    map.sorted[nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_2, _3]
        val m2: m2 = map.sorted(nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_2, _3)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[`true`, map.sorted[nat.naturalOrdering]#put[_4, _5]#put[_3, _4]#put[_5, _6]#put[_0, _1]#put[_1, _2]#put[_2, _3]#equalWith[um, nat.naturalOrdering]]
        assertEquals(map.sorted(nat.naturalOrdering).put(_4, _5).put(_3, _4).put(_5, _6).put(_0, _1).put(_1, _2).put(_2, _3), um)
   }

    def testEmpty {
        type m   = map.sorted[nat.naturalOrdering]
        val m: m = map.sorted(nat.naturalOrdering)

        type m2 = map.sorted[nat.naturalOrdering]
        val m2: m2 = map.sorted(nat.naturalOrdering)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[map.sorted[nat.naturalOrdering], um]
        assertEquals(map.sorted(nat.naturalOrdering), um)
   }

    def testEmpty2 {
        type m   = map.sorted[nat.naturalOrdering]
        val m: m = map.sorted(nat.naturalOrdering)

        type m2 =    map.sorted[nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_2, _3]
        val m2: m2 = map.sorted(nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_2, _3)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[`true`,  map.sorted[nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_2, _3]#equalWith[um, nat.naturalOrdering]]
        assertEquals(map.sorted(nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_2, _3), um)
   }

   def testLeftBiased {
        type m   = map.sorted[nat.naturalOrdering]#put[_4, _5]#put[_5, _6]#put[_0, _1]
        val m: m = map.sorted(nat.naturalOrdering).put(_4, _5).put(_5, _6).put(_0, _1)

        type m2 =    map.sorted[nat.naturalOrdering]#put[_3, _4]#put[_4, _9]#put[_2, _3]
        val m2: m2 = map.sorted(nat.naturalOrdering).put(_3, _4).put(_4, _9).put(_2, _3)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[`true`,  map.sorted[nat.naturalOrdering]#put[_4, _5]#put[_3, _4]#put[_5, _6]#put[_0, _1]#put[_2, _3]#equalWith[um, nat.naturalOrdering]]
        assertEquals(map.sorted(nat.naturalOrdering).put(_4, _5).put(_3, _4).put(_5, _6).put(_0, _1).put(_2, _3), um)
   }

}