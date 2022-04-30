package com.example.notify.presentation.screens.camera

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notify.R
import com.example.notify.domain.notes.model.Note
import com.example.notify.presentation.screens.tablet.TabletViewModel
import com.example.notify.route.NavigationArguments
import com.example.notify.route.NavigationRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Composable
fun CameraScreen(
    navController: NavController,
    noteId: Int?,
) {

    val tabletViewModel: TabletViewModel = hiltViewModel()
    val note = (noteId?.let {
        tabletViewModel.getNoteById(it).collectAsState(initial = Note())
    } as? MutableState<Note>) ?: remember {
        mutableStateOf(Note())
    }
    Log.e("rawr", "CameraScreen: $noteId")
    val context = LocalContext.current
    val mediaDir = context.externalMediaDirs.firstOrNull()?.let {
        File(it, stringResource(R.string.app_name)).apply { mkdirs() }
    }
    val outputDirectory: File =
        if (mediaDir != null && mediaDir.exists()) mediaDir else context.filesDir
    val cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()

    TakePhotoCameraScreen(
        outputDirectory = outputDirectory,
        executor = cameraExecutor,
        onImageCaptured = { uri ->

            tabletViewModel.saveNote(
                note = note.value.copy(
                    photo = uri.toString()
                ), isNeedUpdate = noteId != null
            )

            runBlocking {
                launch(Dispatchers.Main) {
                    navController.navigate(
                        NavigationRoute.ROUTE_TABLET +
                                "?${NavigationArguments.ARGUMENT_NOTE_ID}=${noteId}" +
                                ",?${NavigationArguments.ARGUMENT_PHOTO_URI}=${uri}"
                    ) {
                        popUpTo(NavigationRoute.ROUTE_MAIN)
                    }
                }
            }
        },
        onError = { }
    )
}

