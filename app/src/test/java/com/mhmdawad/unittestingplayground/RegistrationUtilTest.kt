package com.mhmdawad.unittestingplayground

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegistrationUtilTest{

    @Test
    fun `empty username returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "mohamed",
            "",
            "123"
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `username taken returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `confirmedPassword not equal password returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "carl",
            "123",
            "1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contain less than 2 digits`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "carl",
            "12a",
            "12a"
        )
        assertThat(result).isFalse()
    }
}