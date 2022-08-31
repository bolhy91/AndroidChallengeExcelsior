package com.bolhy91.androidchallengeexcelsior.data.txt

import java.io.InputStream

interface TXTParser<T> {
    suspend fun parse(response: InputStream): List<T>
}