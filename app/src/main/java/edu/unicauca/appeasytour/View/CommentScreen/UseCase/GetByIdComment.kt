package edu.unicauca.appeasytour.View.CommentScreen.UseCase

import edu.unicauca.appeasytour.View.CommentScreen.data.RepositoryIpml
import javax.inject.Inject

class GetByIdComment @Inject constructor(private val  repository: RepositoryIpml){
        suspend operator fun invoke(id:Int)= repository.getByIdComment(id)

}