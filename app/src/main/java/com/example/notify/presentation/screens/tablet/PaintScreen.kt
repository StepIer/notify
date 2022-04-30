package com.example.notify.presentation.screens.tablet

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import com.example.notify.domain.notes.model.Note
import com.example.notify.domain.notes.model.Paint

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PaintScreen(
    note: MutableState<Note>
) {
    val action: MutableState<Pair<Boolean, Pair<Float, Float>>?> = remember {
        mutableStateOf(null)
    }
    val path = remember {
        Path()
    }
    val collectList = remember {
        mutableListOf<Pair<Boolean, Pair<Float, Float>>>()
    }

    LaunchedEffect(key1 = null, block = {
        action.value = Pair(false, Pair(0f, 0f))
    })

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        action.value = Pair(true, Pair(it.x, it.y))
                        path.moveTo(it.x, it.y)
                        val x = note.value.paint.item
                        x.add(Pair(true, Pair(it.x, it.y)))
                        note.value = note.value.copy(
                            paint = Paint(x)
                        )
                    }
                    MotionEvent.ACTION_MOVE -> {
                        action.value = Pair(false, Pair(it.x, it.y))
                        path.lineTo(it.x, it.y)
                        val x = note.value.paint.item
                        x.add(Pair(false, Pair(it.x, it.y)))
                        note.value = note.value.copy(
                            paint = Paint(x)
                        )
                    }
                    MotionEvent.ACTION_UP -> {
                    }
                    else -> false
                }
                true
            }
    ) {
        action.value?.let {

            collectList.add(it)
            drawPath(
                path = note.value.paint.item.toPath(),
                color = Color.Red,
                alpha = 0.5f,
                style = Stroke(10f)
            )
        }
    }
}

fun List<Pair<Boolean, Pair<Float, Float>>>.toPath(): Path {
    val path = Path()
    forEach {
        if (it.first) {
            path.moveTo(it.second.first, it.second.second)
        } else {
            path.lineTo(it.second.first, it.second.second)
        }
    }

    return path
}