package ic.yao.pets.presentation.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import ic.yao.pets.data.DataProvider
import ic.yao.pets.data.Pet
import ic.yao.pets.presentation.navigation.Adopt
import ic.yao.pets.presentation.navigation.PetDetail

/**
 * This class will be used to define the ViewModel for the PetDetail screen.
 * This ViewModel will be used to manage the state of the PetDetail screen.
 * */
class AdoptViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // TODO 3: Create the ViewModel class for the PetDetail screen.
    //  This ViewModel will have a pet property that will hold the pet data.
    //  Add in the constructor the savedStateHandle parameter to get the petId from the arguments.
    //  Use the DataProvider to get the pet data from the petId.
    val petId: Int = savedStateHandle.toRoute<Adopt>().petID
    val pet : Pet = DataProvider.getPetById(petId)
}