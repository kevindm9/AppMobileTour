package edu.unicauca.appeasytour.View.CommentScreen.Views.AddScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.CommentUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(private val useCase: CommentUseCase): ViewModel(){

    var titulo by mutableStateOf("")
    var contenido by mutableStateOf("")

    fun addComment()=viewModelScope.launch {
        useCase.insertComments(Comment(titulo= titulo, contenido = contenido))
    }

}