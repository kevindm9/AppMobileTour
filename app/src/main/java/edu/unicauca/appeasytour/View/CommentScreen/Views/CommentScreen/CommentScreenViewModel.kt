package edu.unicauca.appeasytour.View.CommentScreen.Views.CommentScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.CommentUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentScreenViewModel @Inject constructor(private val useCase: CommentUseCase): ViewModel(){
    val  comment= useCase.getComments()

    fun deleteComment(comment: Comment)=viewModelScope.launch {
        useCase.deleteComments(comment)
    }

}