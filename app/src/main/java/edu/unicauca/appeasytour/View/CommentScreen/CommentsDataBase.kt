package edu.unicauca.appeasytour.View.CommentScreen

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.unicauca.appeasytour.View.CommentScreen.Entity.Comment
import edu.unicauca.appeasytour.View.CommentScreen.Repository.Repository

@Database(entities=[Comment::class], exportSchema = false, version = 1)
abstract class CommentsDataBase:RoomDatabase() {
    abstract fun commentDao(): Repository
}