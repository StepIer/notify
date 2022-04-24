package com.example.notify.presentation.screens.worklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notify.domain.worklist.model.Worklist
import com.example.notify.domain.worklist.usecase.DeleteWorklistByTitleUseCase
import com.example.notify.domain.worklist.usecase.GetAllWorklistUseCase
import com.example.notify.domain.worklist.usecase.InsertWorklistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorklistViewModel @Inject constructor(
    private val getAllWorklistUseCase: GetAllWorklistUseCase,
    private val insertWorklistUseCase: InsertWorklistUseCase,
    private val deleteWorklistByTitleUseCase: DeleteWorklistByTitleUseCase,
) : ViewModel() {

    fun getWorklists(): Flow<List<Worklist>> {
        return getAllWorklistUseCase.invoke()
    }

    fun insertWorklist(worklist: Worklist) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                insertWorklistUseCase.invoke(worklist)
            } catch (e: Exception) {
            }
        }
    }

    fun deleteWorklist(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteWorklistByTitleUseCase.invoke(title)
        }
    }
}