package com.example.notify.presentation.screens.tablet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.notify.R
import com.example.notify.domain.notes.model.Note
import com.example.notify.presentation.components.NotifyTextField
import com.example.notify.presentation.screens.tablet.model.ScreenMode
import com.example.notify.route.NavigationRoute

@Composable
fun TabletScreen(
    navController: NavController,
    noteId: Int?,
    photoUri: String?
) {

    val tabletViewModel: TabletViewModel = hiltViewModel()
    val note = (noteId?.let {
        tabletViewModel.getNoteById(it).collectAsState(initial = Note())
    } as? MutableState<Note>) ?: remember {
        mutableStateOf(Note())
    }
    val screenMode = remember { mutableStateOf(ScreenMode.Text) }

    Scaffold(
        topBar = {
            TopBarTabletScreen(
                note = note,
                noteId = noteId,
                tabletViewModel = tabletViewModel,
                navController = navController
            )
        },
        bottomBar = {
            BottomBarTabletScreen(
                screenMode = screenMode
            )
        }
    ) {
        when (screenMode.value) {
            ScreenMode.Text -> {
                TextContentTableScreen(note = note, photoUri = photoUri)
            }
            ScreenMode.Paint -> {
                PaintContentTableScreen()
            }
            ScreenMode.Photo -> {
                screenMode.value = ScreenMode.Text
                navController.navigate(NavigationRoute.ROUTE_CAMERA)
            }
        }
        PaintContentTableScreen()
    }
}

@Composable
fun TextContentTableScreen(
    note: MutableState<Note>,
    photoUri: String?,
) {
    Box(
        modifier = Modifier
            .background(Color(note.value.color))
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = rememberAsyncImagePainter(photoUri),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 52.dp)
        )
        NotifyTextField(
            placeholder = stringResource(id = R.string.tap_to_start_write),
            value = note.value.text ?: "",
            onValueChange = {
                note.value = note.value.copy(
                    text = it
                )
            },
            textSize = 24.sp,
            isNeedFocusPadding = true
        )
    }
}

@Composable
fun PaintContentTableScreen() {
    PaintScreen()
}

@Composable
fun BottomBarTabletScreen(
    screenMode: MutableState<ScreenMode>
) {
    BottomAppBar {
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { screenMode.value = ScreenMode.Text }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_text_format_24),
                contentDescription = "text format"
            )
        }
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { screenMode.value = ScreenMode.Paint }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_brush_24),
                contentDescription = "brush format"
            )
        }
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { screenMode.value = ScreenMode.Photo }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_monochrome_photos_24),
                contentDescription = "photo format"
            )
        }
    }
}




