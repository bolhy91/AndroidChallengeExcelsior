package com.bolhy91.androidchallengeexcelsior.presentation.detail_track.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import com.bolhy91.androidchallengeexcelsior.R
@Composable
fun TopBarSectionDetail(pressOnBack: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 15.dp,
                end = 15.dp,
                top = 30.dp,
                bottom = 20.dp
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = "arrow left",
            tint = Color.Black,
            modifier = Modifier
                .size(32.dp)
                .clickable { pressOnBack() }
        )
        Text(
            text = "TRACK DETAIL",
            color = Color.Black,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}