# Android Challenge Excelsior - Nisum

The layers of the clean architecture are implemented, the application offers the user the search for tracks through a search engine where the user must type the track they want to search for, once they have entered what they want to search for, the application performs a search on the api of iTunes where it returns us a .txt file, the file is captured and transformed into a readable format for our code; At the same time, the information is stored in a local database using Room as a tool. If the track the user is looking for exists on our premises, the HTTP request to the iTunes service is not made, we return the value found in our database. if we click on a track it will direct us to the track detail where we show basic information.

## Tools or Libraries
* Retrofit - https://square.github.io/retrofit/
* Room - https://developer.android.com/jetpack/androidx/releases/room?hl=es-419
* Navigation Compose - https://developer.android.com/guide/navigation/navigation-getting-started
* Hilt - https://developer.android.com/training/dependency-injection/hilt-android
* Shimmer - https://github.com/valentinilk/compose-shimmer
* Coil - https://coil-kt.github.io/coil/compose/

## Preview
* ##### Search Screen
![Design travel app ui](https://raw.githubusercontent.com/bolhy91/AndroidChallengeExcelsior/main/preview/search.png)

* ##### Detail Track Screen
![Design travel app ui](https://raw.githubusercontent.com/bolhy91/AndroidChallengeExcelsior/main/preview/detail.png)
