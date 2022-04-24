package com.example.notify.presentation.screens.entry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notify.domain.worklist.model.Entry
import com.example.notify.domain.worklist.usecase.DeleteEntryByIdUseCase
import com.example.notify.domain.worklist.usecase.GetAllEntryByWorklistNameUseCase
import com.example.notify.domain.worklist.usecase.InsertEntryUseCase
import com.example.notify.domain.worklist.usecase.UpdateEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EntryViewModel @Inject constructor(
    private val getAllEntryByWorklistNameUseCase: GetAllEntryByWorklistNameUseCase,
    private val insertEntryUseCase: InsertEntryUseCase,
    private val deleteEntryByIdUseCase: DeleteEntryByIdUseCase,
    private val updateEntryUseCase: UpdateEntryUseCase
) : ViewModel() {

    fun getEntries(worklistName: String): Flow<List<Entry>> {
        return getAllEntryByWorklistNameUseCase.invoke(worklistName)
    }

    fun addEntry(entry: Entry) {
        viewModelScope.launch(Dispatchers.IO) {
            insertEntryUseCase.invoke(entry)
        }
    }

    fun deleteEntry(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteEntryByIdUseCase.invoke(id)
        }
    }

    fun updateEntry(entry: Entry) {
        viewModelScope.launch(Dispatchers.IO) {
            updateEntryUseCase.invoke(entry)
        }
    }
}