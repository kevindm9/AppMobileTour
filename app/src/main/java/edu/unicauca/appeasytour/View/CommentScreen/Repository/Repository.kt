package edu.unicauca.appeasytour.View.CommentScreen.Repository
import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface Repository {
    @Insert
    suspend fun insertComment(comment:Comment )
    @Update
    suspend fun updateComment(comment: Comment)
    @Delete
    suspend fun deleteComment(comment: Comment)
    @Query("select * from comment")
    fun getComment():Flow<List<Comment>>
    @Query("select * from comment where id=:id")
    suspend fun getByIdComment(id:Int):Comment
}