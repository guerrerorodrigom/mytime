package com.rodrigoguerrero.mytime.ui.timer.numberpad

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.R
import com.rodrigoguerrero.mytime.ui.timer.models.TotalTime
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun TotalTime(
    totalTime: TotalTime,
    hasHours: Boolean,
    hasMinutes: Boolean,
    hasSeconds: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TimeUnit(time = totalTime.displayHours, unit = R.string.hours_unit, hasValue = hasHours)
        TimeUnit(
            time = totalTime.displayMinutes,
            unit = R.string.minutes_unit,
            hasValue = hasMinutes
        )
        TimeUnit(
            time = totalTime.displaySeconds,
            unit = R.string.seconds_unit,
            hasValue = hasSeconds
        )
    }
}

@Composable
private fun TimeUnit(
    time: String,
    hasValue: Boolean,
    @StringRes unit: Int,
    modifier: Modifier = Modifier,
) {
    val color = if (hasValue) {
        MyTimeTheme.color.primary
    } else {
        MyTimeTheme.color.onBackground
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = time,
            style = MyTimeTheme.typography.H1.copy(color = color)
        )
        Text(
            text = stringResource(id = unit),
            style = MyTimeTheme.typography.H3.copy(color = color),
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTimeUnit() {
    MyTimeTheme {
        TimeUnit(time = "00", unit = R.string.hours_unit, hasValue = false)
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTotalTime() {
    MyTimeTheme {
        TotalTime(
            totalTime = TotalTime(0, 0, 0),
            hasSeconds = false,
            hasMinutes = false,
            hasHours = false
        )
    }
}
