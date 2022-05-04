package com.example.notify.data.notes.db

import androidx.room.TypeConverter
import com.example.notify.data.notes.model.PaintData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PaintDataConverters {

    @TypeConverter
    fun paintDataToJson(paintData: PaintData?): String {
        return Json.encodeToString(paintData)
    }

    @TypeConverter
    fun jsonToPaintData(json: String): PaintData? {
        return Json.decodeFromString(json)
    }
}