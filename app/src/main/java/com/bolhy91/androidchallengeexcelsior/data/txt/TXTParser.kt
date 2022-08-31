package com.bolhy91.androidchallengeexcelsior.data.txt

interface TXTParser<T> {
    suspend fun parse(response: String): List<T>
}