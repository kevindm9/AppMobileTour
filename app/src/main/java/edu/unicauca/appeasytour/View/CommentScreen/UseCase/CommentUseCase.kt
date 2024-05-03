package edu.unicauca.appeasytour.View.CommentScreen.UseCase

data class CommentUseCase (
    val getComments:GetComments,
    val insertComments:InsertComments,
    val deleteComments: DeleteComments,
    val updateComments: UpdateComments,
    val getByIdComment: GetByIdComment

)