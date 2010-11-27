

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package map


abstract class Strong[m <: Map](final override protected val delegate: m) extends Forwarder {
    final override protected type delegate = m

    final override  def asMap: asMap = self
    final override type asMap        = self

    final override  def asList: asList = delegate.asList
    final override type asList         = delegate#asList
}