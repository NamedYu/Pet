package ic.yao.pets.presentation

import androidx.annotation.StringRes
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ic.yao.pets.R
import ic.yao.pets.data.Pet
import ic.yao.pets.presentation.navigation.AppNavigation

/**
 * This composable will be used to create the main structure of our app.
 * The content in the scaffold will be the top bar and the navigation graph.
 * */
@Composable
fun PetsApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
){
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                titleId = R.string.app_name,
                canBack = true,
                onBack = {
                    navHostController.navigateUp()
                }
            )
        },
    ) { innerPadding ->
        AppNavigation(
            modifier = Modifier.padding(innerPadding),
            navHostController = navHostController
        )
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    @StringRes titleId: Int,
    canBack: Boolean = false,
    onBack: () -> Unit = {}
){
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { Text(text = stringResource(id = titleId), style = MaterialTheme.typography.headlineMedium)},
        navigationIcon = {
            if (canBack){
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}