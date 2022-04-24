package com.example.notify.presentation.screens.worklist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notify.R
import com.example.notify.domain.worklist.model.Worklist

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WorklistTile(
    worklist: Worklist,
    onClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(all = 4.dp)
            .fillMaxSize()
            .heightIn(64.dp, 200.dp),
        onClick = { onClick() }
    ) {
        Column(
            modifier = Modifier
                .background(color = Color(worklist.color)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = worklist.title,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        }

        Box {
            Icon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clickable {
                        onDeleteClick()
                    },
                painter = painterResource(id = R.drawable.ic_outline_close_24),
                contentDescription = "delete note"
            )
        }
    }
}