
package com.example.alieskotlin.wordManagement

data class Word(
        val id: Long = counter++,
        val name: String
) {
    companion object {
        private var counter = 0L
    }
}