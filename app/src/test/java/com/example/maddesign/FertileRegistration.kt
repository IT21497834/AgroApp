package com.example.maddesign

import org.junit.Assert.assertEquals
import org.junit.Test

// FertileRegistration.kt
class FertileRegistration {
    fun register(fertileName: String, fertileAmount: Int, fertilePrice: Double): String {
        // Registration logic goes here
        // Simulating a successful fertile registration
        return "success"
    }
}

// FertileRegistrationTest.kt


class FertileRegistrationTest {

    @Test
    fun testValidFertileRegistration() {
        val fertileRegistration = FertileRegistration()
        val result = fertileRegistration.register("Organic Fertilizer", 100, 15.99)
        assertEquals("success", result)
    }

    @Test
    fun testInvalidFertileName() {
        val fertileRegistration = FertileRegistration()
        val result = fertileRegistration.register("", 100, 15.99)
        assertEquals("error", result)
    }

    @Test
    fun testInvalidFertileAmount() {
        val fertileRegistration = FertileRegistration()
        val result = fertileRegistration.register("Organic Fertilizer", -5, 15.99)
        assertEquals("error", result)
    }

    @Test
    fun testInvalidFertilePrice() {
        val fertileRegistration = FertileRegistration()
        val result = fertileRegistration.register("Organic Fertilizer", 100, -10.0)
        assertEquals("error", result)
    }


}