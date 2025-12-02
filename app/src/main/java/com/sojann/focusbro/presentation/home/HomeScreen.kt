package com.sojann.focusbro.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.sojann.focusbro.R
import com.sojann.focusbro.presentation.components.AutoResizedText
import com.sojann.focusbro.presentation.components.BorederedIcon
import com.sojann.focusbro.presentation.components.CircleDot
import com.sojann.focusbro.presentation.components.CustomButtom
import com.sojann.focusbro.presentation.components.InformationItem
import com.sojann.focusbro.presentation.components.TimerTypeItem
import com.sojann.focusbro.ui.theme.FocusBroTheme
import java.nio.file.WatchEvent

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(FocusBroTheme.dimens.paddingMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                modifier = Modifier.size(FocusBroTheme.dimens.iconSizeSmall),
                painter = painterResource(id = R.drawable.ic_menu),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = "Menu",


                )
        }

        AutoResizedText(
            text = "Focus Bro",
            textStyle = MaterialTheme.typography.displayMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(FocusBroTheme.dimens.spacerMedium))

        Row(

        ) {
            CircleDot()
            Spacer(modifier = Modifier.width(FocusBroTheme.dimens.spacerNormal))
            CircleDot()
            Spacer(modifier = Modifier.width(FocusBroTheme.dimens.spacerNormal))
            CircleDot(
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.width(FocusBroTheme.dimens.spacerNormal))
            CircleDot(
                color = MaterialTheme.colorScheme.tertiary
            )

        }
        Spacer(modifier = Modifier.width(FocusBroTheme.dimens.spacerNormal))

        TimerSection(timer = "5:00")

        Spacer(modifier = Modifier.width(FocusBroTheme.dimens.spacerNormal))
        TimerTypeSection()

        Spacer(modifier = Modifier.width(FocusBroTheme.dimens.spacerNormal))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomButtom(
                text = "Start",
                btnColor = MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.surface,
                onTap = {
                    TODO()
                }
            )

            CustomButtom(
                text = "RESET",
                btnColor = MaterialTheme.colorScheme.surface,
                textColor = MaterialTheme.colorScheme.primary,
                onTap = {
                    TODO()
                }
            )
        }

        Spacer(modifier = Modifier.width(FocusBroTheme.dimens.spacerNormal))

        InformationSection(round = "10", time = "45:00", modifer = Modifier.weight(1f))
    }
}

@Composable
fun TimerSection(
    modifier: Modifier = Modifier,
    timer: String,
    onIncresedTap: () -> Unit = {},
    onDecresedTap: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorederedIcon(icon = R.drawable.ic_minus, onTap = onDecresedTap)
            Spacer(modifier = Modifier.height(FocusBroTheme.dimens.spacerMedium))
        }


        AutoResizedText(
            text = timer,
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .align(Alignment.CenterVertically),
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )


        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorederedIcon(icon = R.drawable.ic_plus, onTap = onIncresedTap)
            Spacer(modifier = Modifier.height(FocusBroTheme.dimens.spacerMedium))
        }

    }
}

@Composable
fun TimerTypeSection(
    modifier: Modifier = Modifier,
    ontap: () -> Unit = {}
) {
    val GRIDCOUNT = 3
    val ITEMSPCAING = Arrangement.spacedBy(FocusBroTheme.dimens.paddingNormal)

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .height(FocusBroTheme.dimens.spacerLarge),
        columns = GridCells.Fixed(GRIDCOUNT),
        horizontalArrangement = ITEMSPCAING,
        verticalArrangement = ITEMSPCAING,

        ) {
        item(
            key = "FB"
        ) {
            TimerTypeItem(
                text = "Focus Brake",
                textColor = MaterialTheme.colorScheme.primary
            )
        }

        item(
            key = "SB"
        ) {
            TimerTypeItem(
                text = "Short Brake",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }

        item(
            key = "LB"
        ) {
            TimerTypeItem(
                text = "Long Brake",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
    }


}

@Composable
fun InformationSection(
    modifer: Modifier = Modifier,
    round: String,
    time: String,

    ) {
    Box(
        modifer.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,

        ) {
        Row(
            modifer.align(Alignment.BottomCenter)
        ) {
            InformationItem(
                modifer = modifer
                    .fillMaxWidth()
                    .weight(1f),
                text = round,
                label = "rounds"
            )
            Spacer(modifer
                .fillMaxWidth()
                .weight(1f))
            InformationItem(
                modifer = modifer
                    .fillMaxWidth()
                    .weight(1f),
                text = time,
                label = "time"
            )
        }

    }
}

@Preview(
    name = "HomePreview",
    showBackground = true
)
@Composable
fun HomeScreenPre() {
    FocusBroTheme {
        HomeScreen()
    }
}