

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package nattest; package peanotest


import com.github.okomok

import okomok.sing._
import okomok.sing.free.{assert, assertNot}
//import okomok.sing.nat.Operator._
import okomok.sing.nat.peano.Literal._
import okomok.sing.nat.Peano


/*
class OperatorTezt {

    trait testTrivial {
        assert[_0 === _0]

        assert[_0 !== _1]
        assert[_1 !== _0]

        assert[_1 === _1]

        assert[_1 !== _2]
        assert[_1 !== _3]
        assert[_2 !== _1]
        assert[_3 !== _1]

        assert[_7 === _7]
        assert[_2 !== _7]
        assert[_7 !== _2]
        assert[_6 !== _7]
        assert[_7 !== _6]
        assert[_0 !== _7]
        assert[_7 !== _0]
        assert[_1 !== _7]
        assert[_7 !== _1]

        assert[_1#increment === _2]
        assert[_1#increment#increment === _3]

        assert[_1#decrement === _0]
        assert[_3#decrement#decrement === _1]
        assert[_4#decrement === _3]
        assert[_7#increment#decrement#decrement === _6]
    }

    trait testAdd {
        assert[_0 + _0 === _0]
        assert[_0 + _3 === _3]
        assert[_4 + _3 === _7]
        assert[_1 + _8 === _9]
        assert[_5 + _2 === _7]
    }

    trait testSubtract {
        assert[_0 - _0 === _0]
        assert[_3 - _0 === _3]
        assert[_4 - _3 === _1]
        assert[_8 - _1 === _7]
        assert[_5 - _2 === _3]
    }

    trait testComparison {
        assert[_0 < _2]
        assert[_3 < _5]
        assert[_3 <= _3]
        assert[_5 > _3]
        assert[_4 > _0]
        assert[_4 >= _2]
        assert[_0 <= _0]
        assert[_0 >= _0]
        assertNot[_3 > _5]
        assertNot[_0 < _0]
        assertNot[_0 > _0]
        assertNot[_4 >= _5]
        assertNot[_4 <= _2]
        assertNot[_4 < _4]
        assertNot[_4 > _4]
    }
/* still crash.
    trait testPropagation {
        type plusPlus[n <: Peano] = n#increment#increment
        type id[n <: Peano] = n#increment#decrement
        type equaL[n <: Peano, m <: Peano] = plusPlus[n] === id[m]

        assert[plusPlus[_4] === _6]
        assert[plusPlus[_7] === _9]
        assert[id[_9] === _9]
        assert[id[_7] === _7]

        assert[equaL[_3, _5]]
        assert[equaL[_4, _6]]

        // Must work; Visitor is no longer used.
        type subsub[n <: Peano, m <: Peano] = n#subtract[m]#subtract[m]
        assert[subsub[_9, _2] === _5]
    }
*/
}
*/