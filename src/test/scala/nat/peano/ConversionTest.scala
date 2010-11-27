

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package nattest; package peanotest


import com.github.okomok

import okomok.sing.assert
import okomok.sing.free
import okomok.sing.nat._


class ConversionTest extends org.scalatest.junit.JUnit3Suite {

    def testToDense {
        import junit.framework.Assert._
        free.assertSame[dense._0, peano._0#asNat#asDense]
        free.assertSame[dense._1, peano._1#asNat#asDense]
        free.assertSame[dense._6, peano._6#asNat#asDense]
        free.assertSame[dense._5, peano._2#plus[peano._3]#asNat#asDense]

        type x = peano._5
         val x: x = peano._5
        type y = x#asNat#asDense
         val y: y = x.asNat.asDense
        okomok.sing.assert(dense._5 equal y)
    }

}