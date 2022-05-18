package com.mhmdawad.unittestingplayground

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class Homework1Test {

    @Test
    fun `input 10 returns 55`(){
        val result = Homework1.fib(10)
        assertThat(result).isEqualTo(55)
    }

    @Test
    fun `input 15 returns 610`(){
        val result = Homework1.fib(15)
        assertThat(result).isEqualTo(610)
    }

    @Test
    fun `input 12 returns 144`(){
        val result = Homework1.fib(12)
        assertThat(result).isEqualTo(144)
    }

    @Test
    fun `input 20 returns 6765`(){
        val result = Homework1.fib(20)
        assertThat(result).isEqualTo(6765)
    }

    @Test
    fun `string (hello) returns true`(){
        val result = Homework1.checkBraces("(hello)")
        assertThat(result).isTrue()
    }

    @Test
    fun `string (hello)) returns false`(){
        val result = Homework1.checkBraces("(hello))")
        assertThat(result).isFalse()
    }

    @Test
    fun `string (hello))( returns false`(){
        val result = Homework1.checkBraces("(hello))(")
        assertThat(result).isFalse()
    }

    @Test
    fun `string )(hello))( returns false`(){
        val result = Homework1.checkBraces(")(hello))(")
        assertThat(result).isFalse()
    }

    @Test
    fun `string ))(hello))( returns false`(){
        val result = Homework1.checkBraces("))(hello))(")
        assertThat(result).isFalse()
    }

    @Test
    fun `string (((hello))) returns true`(){
        val result = Homework1.checkBraces("(((hello)))")
        assertThat(result).isTrue()
    }
}