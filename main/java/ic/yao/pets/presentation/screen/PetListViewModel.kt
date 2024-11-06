package ic.yao.pets.presentation.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ic.yao.pets.data.DataProvider

class PetListViewModel:ViewModel() {
    val petList = mutableStateOf(DataProvider.petList)
}