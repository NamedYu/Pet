package ic.yao.pets.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ic.yao.pets.data.Pet

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetListScreen(
    modifier: Modifier = Modifier,
    petList: List<Pet>,
    onPetClick: (Int) -> Unit,
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        items(
            items = petList,
            key = { pet -> pet.id }
        ){ pet ->
            PetItem(
                pet = pet,
                onPetClick = onPetClick
            )
        }
    }
}

@Composable
fun PetItem(
    modifier: Modifier = Modifier,
    pet: Pet,
    onPetClick: (Int) -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onPetClick(pet.id) }
            .padding(vertical = 12.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Image(
            modifier = modifier
                .size(95.dp)
                .clip(CircleShape),
            painter = painterResource(id = pet.drawableId),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Column(
            modifier= modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = pet.name,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Age: ${pet.age}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}