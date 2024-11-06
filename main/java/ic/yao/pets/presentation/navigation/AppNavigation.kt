package ic.yao.pets.presentation.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ic.yao.pets.data.Pet
import ic.yao.pets.presentation.TopAppBar
import ic.yao.pets.presentation.screen.AdoptScreen
import ic.yao.pets.presentation.screen.AdoptViewModel
import ic.yao.pets.presentation.screen.PetDetailScreen
import ic.yao.pets.presentation.screen.PetDetailViewModel
import ic.yao.pets.presentation.screen.PetListScreen
import ic.yao.pets.presentation.screen.PetListViewModel

/**
 * This composable will be used to create the navigation graph of our app.
 * */
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController //= rememberNavController()
){
    // TODO 2: Create the NavHost composable and define the routes for our app.
    //  Use the Destination classes created in the previous step to define the routes.
    //  Remember to use the startDestination parameter to define the initial route of the app.
    //  Use the composable<T> inside the NavHost to define the content of each route.
    //  The content of each route are defined in the screen package.
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = PetList){
        composable<PetList> {
            val vs : PetListViewModel = viewModel()
            PetListScreen(
                petList = vs.petList.value,
                onPetClick = {id ->
                    navHostController.navigate(PetDetail(petID = id))
                }
            )

        }
        composable<PetDetail> {

            val vs : PetDetailViewModel = viewModel()
            PetDetailScreen(
                pet = vs.pet,
                onAdoptClick = {id ->
                    navHostController.navigate(Adopt(petID = id))
                }
            )
        }
        composable<Adopt> {
            val vs: AdoptViewModel = viewModel()
            AdoptScreen(
                pet = vs.pet,
                onTerminal = {
                    navHostController.navigateUp()
                }
            )
        }
    }
}