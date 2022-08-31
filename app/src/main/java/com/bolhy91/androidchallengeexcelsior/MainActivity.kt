package com.bolhy91.androidchallengeexcelsior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bolhy91.androidchallengeexcelsior.common.Api
import com.bolhy91.androidchallengeexcelsior.data.remote.ExcelsiorApi
import com.bolhy91.androidchallengeexcelsior.ui.theme.AndroidChallengeExcelsiorTheme
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

data class SearchResponse(
    val resultCount: Long,
    val results: List<Result>
)

data class Result(
    val wrapperType: String,
    val kind: Kind,
    val artistID: Long,
    val collectionID: Long,
    val trackID: Long,
    val artistName: ArtistName,
    val collectionName: CollectionName,
    val trackName: String,
    val collectionCensoredName: CollectionCensoredName,
    val trackCensoredName: String,
    val artistViewURL: String,
    val collectionViewURL: String,
    val trackViewURL: String,
    val previewURL: String,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val collectionPrice: Double,
    val trackPrice: Double,
    val collectionHDPrice: Double? = null,
    val trackHDPrice: Double? = null,
    val releaseDate: String,
    val collectionExplicitness: Explicitness,
    val trackExplicitness: Explicitness,
    val discCount: Long,
    val discNumber: Long,
    val trackCount: Long,
    val trackNumber: Long,
    val trackTimeMillis: Long,
    val country: Country,
    val currency: Currency,
    val primaryGenreName: PrimaryGenreName,
    val contentAdvisoryRating: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val isStreamable: Boolean? = null
)

enum class ArtistName {
    Californication,
    Nirvana
}

enum class CollectionCensoredName {
    CalifornicationSeason2,
    InUtero,
    InUtero20ThAnniversaryEdition
}

enum class Explicitness {
    NotExplicit
}

enum class CollectionName {
    CalifornicationSeason2,
    InUtero20ThAnniversaryEdition,
    InUtero20ThAnniversarySuperDeluxeEdition
}

enum class Country {
    Usa
}

enum class Currency {
    Usd
}

enum class Kind {
    Song,
    TvEpisode
}

enum class PrimaryGenreName {
    Alternative,
    Comedy,
    Grunge
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    fun llamado() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Api.BASE_URL)
            .build()
        val excelsiorApi = retrofit.create<ExcelsiorApi>()
        runBlocking {
            val response = excelsiorApi.searchSong("", limit = 100)
            val result = Gson().fromJson(response.string(), SearchResponse::class.java)
            println("respuesta: ${result.results}")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        llamado()
        setContent {
            AndroidChallengeExcelsiorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidChallengeExcelsiorTheme {
        Greeting("Android")
    }
}