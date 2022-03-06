package com.bcoding.fooddeliveryappui

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun rest_isCorrect() {
        assertEquals(0, 2 - 2)
    }

    @Test
    fun multiple_isCorrect() {
        assertEquals(4, 2 * 2)
    }

    /**
     * Method division
     * @return void
     */
    @Test
    fun division_isCorrect() {
        assertEquals(2, 4 / 2)
    }

    /**
     * Method addition
     * @return void
     */
    @Test
    fun addition_isSumCorrect() {
        assertEquals(6, 4 + 2)
    }

}