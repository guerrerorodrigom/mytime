package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.theme.MytimeTheme

@Composable
fun NumberButton(
    number: String,
    modifier: Modifier = Modifier,
    size: Dp = 64.dp
) {
    AnimatedButton(size = size, modifier = modifier) {
        Text(text = number)
    }
}

@Composable
fun IconAnimatedButton(
    icon: ImageVector,
    tint: Color,
    contentDescription: String,
    modifier: Modifier = Modifier,
    size: Dp = 64.dp
) {
    AnimatedButton(size = size, modifier = modifier) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}

@Composable
private fun AnimatedButton(
    size: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val cornerRadius = if (isPressed) {
        12.dp
    } else {
        size / 2
    }
    val cornerRadiusAnim = animateDpAsState(targetValue = cornerRadius)
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadiusAnim.value))
            .size(size)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple()
                ) {}
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNumberButton() {
    MytimeTheme {
        NumberButton(number = "1")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIconButton() {
    MytimeTheme {
        IconAnimatedButton(
            icon = Icons.Filled.Backspace,
            contentDescription = "",
            tint = MaterialTheme.colors.onSecondary
        )
    }
}