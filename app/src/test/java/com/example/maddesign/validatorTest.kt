package com.example.maddesign

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)

class ValidatorTest {

    @Test
    fun whenInputIsValid() {

        val fertileName = ""
        val fertileAmount = "12"
        val fertilePrice = "2000"


        val result = Validator.validateInput(fertileName, fertileAmount, fertilePrice)

        assertThat(result).isEqualTo(true)
    }
}