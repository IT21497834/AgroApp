package com.example.maddesign

import org.junit.Assert.assertEquals
import org.junit.Test

// SellerRegistration.kt
class SellerRegistration {
    fun register(sellerName: String, sellerEmail: String, sellerLocation: String, sellerMobile: String): String {
        // Registration logic goes here
        // Simulating a successful seller registration
        return "success"
     }
    }

// SellerRegistrationTest.kt


class SellerRegistrationTest {

    @Test
    fun testValidSellerRegistration() {
        val sellerRegistration = SellerRegistration()
        val result = sellerRegistration.register("John Doe", "johndoe@example.com", "City A", "0712265348")
        assertEquals("success", result)
    }

    @Test
    fun testInvalidSellerName() {
        val sellerRegistration = SellerRegistration()
        val result = sellerRegistration.register("", "johndoe@example.com", "City A", "555-1234")
        assertEquals("error", result)
    }

    @Test
    fun testInvalidSellerEmail() {
        val sellerRegistration = SellerRegistration()
        val result = sellerRegistration.register("John Doe", "invalidemail", "City A", "555-1234")
        assertEquals("error", result)
    }

    @Test
    fun testInvalidSellerLocation() {
        val sellerRegistration = SellerRegistration()
        val result = sellerRegistration.register("John Doe", "johndoe@example.com", "", "555-1234")
        assertEquals("error", result)
    }

    @Test
    fun testInvalidSellerMobile() {
        val sellerRegistration = SellerRegistration()
        val result = sellerRegistration.register("John Doe", "johndoe@example.com", "City A", "")
        assertEquals("error", result)
    }

    // Add similar test methods for any other validation scenarios you want to cover
}