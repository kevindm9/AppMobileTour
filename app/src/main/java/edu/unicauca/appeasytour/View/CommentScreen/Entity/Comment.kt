package edu.unicauca.appeasytour.View.CommentScreen.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment")
data class Comment(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val titulo:String="",
    val contenido:String=""
)