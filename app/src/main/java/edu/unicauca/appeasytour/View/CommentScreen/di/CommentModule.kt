package edu.unicauca.appeasytour.View.CommentScreen.di

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.unicauca.appeasytour.View.CommentScreen.CommentsDataBase
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.CommentUseCase
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.DeleteComments
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.GetByIdComment
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.GetComments
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.InsertComments
import edu.unicauca.appeasytour.View.CommentScreen.UseCase.UpdateComments
import edu.unicauca.appeasytour.View.CommentScreen.data.RepositoryIpml

@Module
@InstallIn(SingletonComponent::class)
object CommentModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):CommentsDataBase= Room.databaseBuilder(
        context=context,
        klass=CommentsDataBase::class.java,
        name="CommentDB"
    ).build()

    @Provides
    fun provideDao(dao: CommentsDataBase)=dao.commentDao()

    @Provides
    fun provideCommentUseCase(repository: RepositoryIpml)= CommentUseCase(
        getComments = GetComments(repository),
        insertComments = InsertComments(repository),
        deleteComments = DeleteComments(repository),
        updateComments = UpdateComments(repository),
        getByIdComment = GetByIdComment(repository)
    )
}