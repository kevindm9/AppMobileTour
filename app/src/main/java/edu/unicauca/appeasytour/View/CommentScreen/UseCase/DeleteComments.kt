package edu.unicauca.appeasytour.View.CommentScreen.UseCase

import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment
import edu.unicauca.appeasytour.View.CommentScreen.data.RepositoryIpml

class DeleteComments constructor(private val respository: RepositoryIpml) {
    suspend operator fun invoke(comment: Comment)=respository.deleteComment(comment)
}