package com.rodrigoguerrero.mytime.ui.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun TextButton(
    text: String,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 92.dp
) {
    AnimatedButton(
        size = size,
        background = MyTimeTheme.color.surface,
        modifier = modifier,
        onClicked = onClicked,
        backgroundPressed = MyTimeTheme.color.onBackground.copy(alpha = 0.25f)
    ) {
        Text(
            text = text,
            style = MyTimeTheme.typography.H2.copy(color = MyTimeTheme.color.onSurface)
        )
    }
}

@Composable
fun NumberButton(
    number: Int,
    onNumberClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 92.dp
) {
    AnimatedButton(
        size = size,
        background = MyTimeTheme.color.surface,
        modifier = modifier,
        onClicked = { onNumberClicked(number) },
        backgroundPressed = MyTimeTheme.color.onBackground.copy(alpha = 0.25f)
    ) {
        Text(
            text = number.toString(),
            style = MyTimeTheme.typography.H2.copy(color = MyTimeTheme.color.onSurface)
        )
    }
}

@Composable
fun IconAnimatedButton(
    icon: ImageVector,
    tint: Color,
    contentDescription: String,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 92.dp,
    background: Color = MyTimeTheme.color.surface
) {
    AnimatedButton(
        size = size,
        modifier = modifier,
        background = background,
        onClicked = onClicked,
        backgroundPressed = background
    ) {
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
    background: Color,
    backgroundPressed: Color,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val color = animateColorAsState(
        targetValue = if (isPressed) {
            backgroundPressed
        } else {
            background
        }
    )
    val cornerRadius = if (isPressed) {
        24.dp
    } else {
        size / 2
    }
    val cornerRadiusAnim = animateDpAsState(targetValue = cornerRadius)

    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(cornerRadiusAnim.value))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple()
            ) { onClicked() }
            .background(color.value),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewNumberButton() {
    MyTimeTheme {
        NumberButton(number = 1, onNumberClicked = { })
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewIconButton() {
    MyTimeTheme {
        IconAnimatedButton(
            icon = Icons.Filled.Backspace,
            contentDescription = "",
            tint = MyTimeTheme.color.onSurface,
            onClicked = { },
        )
    }
}