package com.nyt.popular.articles.presentation.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nyt.popular.articles.presentation.R
import com.nyt.popular.articles.presentation.model.Period


@Composable
fun PeriodsHeader(
    periodList: List<Period>,
    selectedPeriodId: Int,
    modifier: Modifier = Modifier,
    onPeriodSelected: (id: Int) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.periods),
            style = MaterialTheme.typography.titleMedium,
        )
        LazyRow(
            modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(periodList) { period ->
                PeriodChip(
                    period = period,
                    isSelected = selectedPeriodId == period.id,
                    onPeriodSelected = onPeriodSelected
                )

            }
        }

    }
}

@Composable
private fun PeriodChip(
    modifier: Modifier = Modifier,
    period: Period,
    isSelected: Boolean,
    onPeriodSelected: (id: Int) -> Unit
) {
    FilterChip(
        modifier = modifier,
        onClick = { onPeriodSelected(period.id) },
        label = {
            Text(
                text = stringResource(id = period.name),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        selected = isSelected,
        leadingIcon = if ((isSelected)) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )

}