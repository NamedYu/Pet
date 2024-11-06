package ic.yao.pets.presentation.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ic.yao.pets.data.DataProvider
import ic.yao.pets.data.Pet
import ic.yao.pets.presentation.TopAppBar
import ic.yao.pets.ui.theme.PetsTheme
import java.io.File

@Composable
fun PetDetailScreen(
    modifier: Modifier = Modifier,
    pet: Pet,
    onAdoptClick: (Int) -> Unit
) {
    PetDetailContent(
        modifier = modifier,
        pet = pet,
        onAdoptClick = onAdoptClick
    )
}

@Composable
fun PetDetailContent(
    modifier: Modifier = Modifier,
    pet: Pet,
    onAdoptClick: (Int) -> Unit
){
    val context = LocalContext.current
    val adoptInfo = readArchive(context,pet.id)
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            Image(
                modifier = modifier
                    .size(200.dp)
                    .clip(shape = CircleShape),
                painter = painterResource(id = pet.drawableId),
                contentDescription = "Pet cover image",
                contentScale = ContentScale.Crop
            )
        }
        item {
            Text(
                text = pet.name,
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            Text(
                text = "Age: ${pet.age}",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            Text(
                modifier = modifier.padding(15.dp),
                text = pet.description,
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            Spacer(modifier = modifier.height(16.dp))
        }
        item {
            Button(onClick = { onAdoptClick(pet.id) }) {
                Text(text = "Adopt ${pet.name}")
            }
        }
        item {
            Spacer(modifier = modifier.height(16.dp))
            Text(adoptInfo)
        }
    }
}
fun readArchive(context: Context,id:Int): String {
    val fileName = "$id.txt"
    val file = File(context.filesDir, fileName)
    if(file.exists()){
        return file.readText()
    }
    return ""
}
@Preview(showBackground = true)
@Composable
fun PetDetailPreview() {
    val pet = DataProvider.petList.random()
    PetsTheme {
        PetDetailScreen(pet = pet, onAdoptClick = {})
    }
}