package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.theme.MytimeTheme

@Composable
fun NumberButton(
    number: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .size(64.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(text = number)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNumberButton() {
    MytimeTheme {
        NumberButton(number = "1")
    }
}