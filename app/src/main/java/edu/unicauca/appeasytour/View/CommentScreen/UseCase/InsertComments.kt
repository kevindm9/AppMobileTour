package edu.unicauca.appeasytour.View.CommentScreen.UseCase

import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment
import edu.unicauca.appeasytour.View.CommentScreen.data.RepositoryIpml

class InsertComments constructor(private val respository:RepositoryIpml) {
    suspend operator fun invoke(comment: Comment)=respository.insertComment(comment)
}