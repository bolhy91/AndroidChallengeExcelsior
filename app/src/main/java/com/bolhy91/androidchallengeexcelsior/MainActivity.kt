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
import com.bolhy91.androidchallengeexcelsior.ui.theme.AndroidChallengeExcelsiorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


//    fun llamado() {
//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(Api.BASE_URL)
//            .build()
//        val excelsiorApi = retrofit.create<ExcelsiorApi>()
//        runBlocking {
//            val response = excelsiorApi.searchSong("in+utero", limit = 50)
//            val reader = InputStreamReader(response.byteStream())
//
//            val result = Gson().fromJson(reader, SearchResponse::class.java)
//
//            println("respuesta: ${result}")
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //llamado()
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