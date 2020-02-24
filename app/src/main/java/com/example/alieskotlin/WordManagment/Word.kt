
package com.example.alieskotlin.WordManagment

data class Word(
        val id: Long = counter++,
        val name: String
) {
    companion object {
        private var counter = 0L
    }
}