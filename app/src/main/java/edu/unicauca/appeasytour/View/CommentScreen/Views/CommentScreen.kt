package edu.unicauca.appeasytour.View.CommentScreen.Views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.unicauca.appeasytour.View.CommentScreen.Navigation.Screens
import edu.unicauca.appeasytour.View.CommentScreen.Views.CommentScreen.CommentScreenViewModel

/*@Composable
fun CommentsScreen(navController: NavHostController,
                   viewModel: CommentScreenViewModel= hiltViewModel()){
    val  comment=viewModel.comment.collectAsState(initial= emptyList())
   Scaffold (
        floatingActionButton = { FloatingActionButton(onClick = {
            navController.navigate(Screens.AddScreen.route) },
            modifier = Modifier.padding(bottom = 70.dp)) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }},
                floatingActionButtonPosition = FabPosition.Center
    ){
LazyColumn(modifier = Modifier.padding(6.dp)){
    items(comment.value){
        Box(modifier = Modifier
            .padding(16.dp)
            .border(1.dp, color = Color.Gray)){
            Column(modifier = Modifier.padding(20.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Text(text = "Reseña # ${comment.value.indexOf(it)+1}")
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        navController.navigate(Screens.UpdateScreen.getById(it.id))
                    }) {
                        Icon(
                            tint=Color.Blue.copy(0.5f),
                            imageVector = Icons.Default.Edit, contentDescription ="" )
                    }
                    IconButton(onClick = {
                        viewModel.deleteComment(comment=it)
                    }) {

                        Icon(
                            tint=Color.Red.copy(0.5f),
                            imageVector = Icons.Default.Delete, contentDescription ="" )
                    }
                }
                Text(text=it.titulo)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text=it.contenido)
            }
        }
    }

}
}
}*/

@Composable
fun CommentsScreen(
    navController: NavHostController,
    viewModel: CommentScreenViewModel = hiltViewModel()
) {
    val comment = viewModel.comment.collectAsState(initial = emptyList())
     Surface {


    LazyColumn(modifier = Modifier.padding(6.dp)) {
        items(comment.value) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .border(1.dp, color = Color.Gray)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Reseña #${comment.value.indexOf(it) + 1}")
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = {
                                navController.navigate(Screens.UpdateScreen.getById(it.id))
                            }
                        ) {
                            Icon(
                                tint = Color.Blue.copy(0.5f),
                                imageVector = Icons.Default.Edit,
                                contentDescription = ""
                            )
                        }
                        IconButton(
                            onClick = {
                                viewModel.deleteComment(comment = it)
                            }
                        ) {
                            Icon(
                                tint = Color.Red.copy(0.5f),
                                imageVector = Icons.Default.Delete,
                                contentDescription = ""
                            )
                        }
                    }
                    Text(text = it.titulo)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = it.contenido)
                }
            }
        }
    }

    // Botón en la esquina inferior derecha
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Button(
            onClick = {
                navController.navigate(Screens.AddScreen.route)
            }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = "Agregar")
        }
    }
     }
}

