

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok
import okomok.sing._
import Dense.Literal._


class StrongTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        final class myMap extends map.Strong(Map.sorted(Nat.naturalOrdering).put(_3, _13).put(_5, _15).put(_1, _11)) {
            type self = myMap
        }
        val myMap = new myMap

        Weak.assert(myMap.get(_3).get.equal(_13))
    }

}
