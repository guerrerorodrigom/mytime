package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TimerFab(
    isVisible: Boolean,
    onClicked: () -> Unit
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        FloatingActionButton(
            modifier = Modifier
                .size(90.dp),
            onClick = { onClicked() },
            containerColor = MyTimeTheme.color.primary,
            contentColor = MyTimeTheme.color.background,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "",
                tint = MyTimeTheme.color.background
            )
        }
    }
}
