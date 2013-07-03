

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


object CompileError {
    final val AnyError = "(?s).*"
    final val AbstractType = "(?s)Abstract type.*"
    final val AssertError = "(?s)Assertion failed.*"
    final val CannotProve = "(?s).*prove.*"
    final val UnexpectedCompile = "(?s)Compiles unexpectedly.*"
    final val UnexpectedError = "(?s)Error unexpectedly.*"
    final val IllegalArgument = "(?s)Illegal argument.*"
    final val NotFound = "(?s).*not found.*"
    final val NothingType = "(?s)Nothing type.*"
    final val TypeMismatch = "(?s).*type mismatch.*"

    def assertError(c: Context)(msg: String): Nothing = {
        c.abort(c.enclosingPosition, "Assertion failed: " + msg)
    }

    def illegalArgument(c: Context)(msg: String): Nothing = {
        c.abort(c.enclosingPosition, "Illegal argument: " + msg)
    }

    def abstractType(c: Context)(msg: String): Nothing = {
        c.abort(c.enclosingPosition, "Abstract type: " + msg)
    }

    def nothingType(c: Context)(msg: String): Nothing = {
        c.abort(c.enclosingPosition, "Nothing type: " + msg)
    }

    def unexpectedCompile(c: Context)(msg: String): Nothing = {
        c.abort(c.enclosingPosition, "Compiles unexpectedly:\n" + msg)
    }

    def unexpectedError(c: Context)(msg: String): Nothing = {
        c.abort(c.enclosingPosition, "Error unexpectedly:\n" + msg)
    }
}