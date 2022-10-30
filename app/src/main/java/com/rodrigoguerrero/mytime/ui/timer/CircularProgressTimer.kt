package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun CircularTimer(
    remainingTime: Int,
    totalTime: Int,
    modifier: Modifier = Modifier,
    size: Dp = 256.dp,
    foregroundIndicatorColor: Color = MyTimeTheme.color.primary,
    backgroundColor: Color = Color.Transparent,
    shadowColor: Color = MyTimeTheme.color.primary.copy(alpha = 0.25f),
    fontColor: Color = MyTimeTheme.color.onBackground,
    indicatorThickness: Dp = 8.dp
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(size)) {
            // For shadow
            drawArc(
                color = shadowColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (size - indicatorThickness).toPx(),
                    height = (size - indicatorThickness).toPx()
                ),
                topLeft = Offset(
                    x = (indicatorThickness / 2).toPx(),
                    y = (indicatorThickness / 2).toPx()
                )
            )

            // This is the white circle that appears on the top of the shadow circle
            drawCircle(
                color = backgroundColor,
                radius = (size / 2 - indicatorThickness).toPx(),
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // 360 - total time
            //     - current
            // Convert the dataUsage to angle
            val sweepAngle = remainingTime * 360 / totalTime

            // Foreground indicator
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle.toFloat(),
                useCenter = false,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (size - indicatorThickness).toPx(),
                    height = (size - indicatorThickness).toPx()
                ),
                topLeft = Offset(
                    x = (indicatorThickness / 2).toPx(),
                    y = (indicatorThickness / 2).toPx()
                )
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Text that shows the number inside the circle
            Text(
                text = remainingTime.toString(),
                style = MyTimeTheme.typography.H4.copy(color = fontColor)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Remaining",
                style = MyTimeTheme.typography.H4.copy(color = fontColor)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewCircularProgressTimer() {
    MyTimeTheme {
        CircularTimer(remainingTime = 15, totalTime = 60)
    }
}