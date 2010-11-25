

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat


object Nat extends Common


/**
 * The sing natural number
 */
trait Nat extends Any {
    type self <: Nat
    type unsung = scala.Int

     def asDense: asDense
    type asDense <: Dense

     def asPeano: asPeano
    type asPeano <: Peano

    @constantTime
     def isZero: isZero
    type isZero <: Boolean

    @constantTime
     def increment: increment
    type increment <: Nat

    @constantTime
     def decrement: decrement
    type decrement <: Nat

     def plus[that <: Nat](that: that): plus[that]
    type plus[that <: Nat] <: Nat

     def minus[that <: Nat](that: that): minus[that]
    type minus[that <: Nat] <: Nat

     def times[that <: Nat](that: that): times[that]
    type times[that <: Nat] <: Nat

     def quotRem[that <: Nat](that: that): quotRem[that]
    type quotRem[that <: Nat] <: Product2

     def exp[that <: Nat](that: that): exp[that]
    type exp[that <: Nat] <: Nat

     def equal[that <: Nat](that: that): equal[that]
    type equal[that <: Nat] <: Boolean

     def nequal[that <: Nat](that: that): nequal[that]
    type nequal[that <: Nat] <: Boolean

     def lteq[that <: Nat](that: that): lteq[that]
    type lteq[that <: Nat] <: Boolean

     def lt[that <: Nat](that: that): lt[that]
    type lt[that <: Nat] <: Boolean

     def quot[that <: Nat](that: that): quot[that]
    type quot[that <: Nat] <: Nat

     def rem[that <: Nat](that: that): rem[that]
    type rem[that <: Nat] <: Nat

     def gt[that <: Nat](that: that): gt[that]
    type gt[that <: Nat] <: Boolean

     def gteq[that <: Nat](that: that): gteq[that]
    type gteq[that <: Nat] <: Boolean

     def bitAnd[that <: Nat](that: that): bitAnd[that]
    type bitAnd[that <: Nat] <: Nat

     def bitOr[that <: Nat](that: that): bitOr[that]
    type bitOr[that <: Nat] <: Nat
}
