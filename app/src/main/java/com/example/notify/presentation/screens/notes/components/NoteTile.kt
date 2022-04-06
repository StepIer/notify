package com.example.notify.presentation.screens.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notify.R
import com.example.notify.domain.notes.model.Note
import com.example.notify.presentation.theme.NotifyTheme
import com.example.notify.presentation.theme.Orange400
import java.time.LocalDateTime

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NoteTile(
    note: Note,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(all = 4.dp)
            .fillMaxHeight()
            .heightIn(0.dp, 200.dp),
        onClick = { onClick() }
    ) {

        Column(
            modifier = Modifier
                .background(color = Color(note.color))
        ) {
            note.title?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            note.text?.let {
                Text(text = it, fontSize = 14.sp, textAlign = TextAlign.Justify)
            }
        }

        IconButton(onClick = {

        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_delete_forever_24),
                contentDescription = "delete note"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
    NotifyTheme {
        NoteTile(
            note = Note(
                title = "fsd",
                text = "sdc",
                date = LocalDateTime.now(),
                color = Orange400.toArgb()
            )
        ) {

        }
    }
}