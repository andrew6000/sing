

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


/**
 * Helps to build a recursive grammar.
 */
trait Rule extends AbstractPeg {
    protected  def rule: rule
    protected type rule <: Peg

    private[this] lazy val p: p = rule.asPeg
    private[this]     type p    = rule#asPeg

    final override  def parse[xs <: List](xs: xs): parse[xs] = p.parse(xs)
    final override type parse[xs <: List]                    = p#parse[xs]

    final override  def width: width = p.width
    final override type width        = p#width
}
