package com.nyt.articles.core.common.extentions

import kotlin.test.Test
import kotlin.test.assertEquals

class StringExtKtTest {
    @Test
    fun `return the same value in case not null`() {
        val input = "test string"
        val expected = input
        val actual = input.emptyIfNull()
        assertEquals(actual, expected)
    }

    @Test
    fun `return empty value in case null`() {
        val input: String? = null
        val expectedOutput = ""
        val actualOutput = input.emptyIfNull()
        assertEquals(expectedOutput, actualOutput)
    }
}