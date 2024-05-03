package edu.unicauca.appeasytour.View.CommentScreen.Views.UpdateScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.CommentUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateScreenViewModel @Inject constructor(
    private val useCase: CommentUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

        var titulo by mutableStateOf("")
        var contenido by mutableStateOf("")

        val id=savedStateHandle.get<Int>(key = "id")

        init {
            viewModelScope.launch {
                val nota= id?.let { useCase.getByIdComment(it) }
                if (nota!=null){
                    contenido=nota.contenido
                    titulo=nota.titulo
                }
            }
        }

        fun updateComment()=viewModelScope.launch {
            useCase.updateComments(Comment(id!!,titulo, contenido = contenido))
        }
    }