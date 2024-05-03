package edu.unicauca.appeasytour.View.CommentScreen.UseCase

import edu.unicauca.appeasytour.View.CommentScreen.data.RepositoryIpml
import javax.inject.Inject

class GetComments @Inject constructor(private val  repository: RepositoryIpml){
    operator fun invoke()= repository.getComment()
}