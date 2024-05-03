package edu.unicauca.appeasytour.View.CommentScreen.data

import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment
import edu.unicauca.appeasytour.View.CommentScreen.Repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryIpml @Inject constructor(private val  dao :Repository):Repository {
    override suspend fun insertComment(comment: Comment) =dao.insertComment(comment = comment)
    override suspend fun updateComment(comment: Comment) = dao.updateComment(comment=comment)
    override suspend fun deleteComment(comment: Comment)= dao.deleteComment(comment=comment)
    override fun getComment(): Flow<List<Comment>> = dao.getComment()
    override suspend fun getByIdComment(id: Int): Comment =dao.getByIdComment(id)

}