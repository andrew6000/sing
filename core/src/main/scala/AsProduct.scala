

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct extends Product with AsAny with UnsingEquals {
    override  def asProduct: asProduct = self
    override type asProduct            = self

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product]
}