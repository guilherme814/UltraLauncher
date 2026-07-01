package com.ultra.launcher.joke

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Joke API Service
 * Uses JokeAPI (https://v2.jokeapi.dev)
 */
interface JokeApiService {
    @GET("joke/Any?format=json")
    suspend fun getRandomJoke(): JokeResponse
}

/**
 * Response model for JokeAPI
 */
data class JokeResponse(
    val error: Boolean,
    val category: String,
    val type: String,
    val joke: String? = null,
    val setup: String? = null,
    val delivery: String? = null
) {
    fun getFullJoke(): String {
        return when {
            type == "single" && joke != null -> joke
            type == "twopart" && setup != null && delivery != null -> "$setup\n\n$delivery"
            else -> "Could not parse joke"
        }
    }
}

/**
 * Joke Repository
 */
class JokeRepository {
    companion object {
        private const val TAG = "JokeRepository"
        private const val BASE_URL = "https://v2.jokeapi.dev/"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(JokeApiService::class.java)

    suspend fun getRandomJoke(): Result<JokeResponse> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = apiService.getRandomJoke()
            if (!response.error) {
                Result.success(response)
            } else {
                Result.failure(Exception("API returned error"))
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching joke", e)
            Result.failure(e)
        }
    }
}
