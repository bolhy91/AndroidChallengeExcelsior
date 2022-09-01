package com.bolhy91.androidchallengeexcelsior.presentation.search_track.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.bolhy91.androidchallengeexcelsior.ui.theme.PurpleGrey40

@Composable
fun TrackItem(track: Track, itemClick: (Long) -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(Color.White)
            .clickable { itemClick(track.id) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .background(Color.Transparent)
                        .border(1.dp, PurpleGrey40, RoundedCornerShape(16.dp))
                ) {
                    AsyncImage(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(track.banner)
                            .crossfade(true)
                            .build(),
                        contentDescription = track.name,
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                            .shadow(
                                0.dp,
                                shape = RoundedCornerShape(16.dp),
                                true
                            ),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = track.name,
                        modifier = Modifier
                            .align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Black,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis

                    )
                    Text(
                        text = "Price: ${track.price}",
                        modifier = Modifier
                            .align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black,
                    )
                    Text(
                        text = "Country: ${track.country}",
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TrackItemPreview() {
    val track = Track(
        1,
        "Frances Farmer Will Have Her Revenge On Seattle",
        2,
        "Nirvana",
        "test",
        price = 1.29,
        country = "USA",
        banner = "https://is4-ssl.mzstatic.com/image/thumb/Music125/v4/e3/20/03/e32003a4-99bc-1c70-40ba-001882f35dba/00602537526840.rgb.jpg/100x100bb.jpg",
        publish = "",
        preview = ""
    )
    TrackItem(track, itemClick = {})
}