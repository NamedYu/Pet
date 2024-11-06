package ic.yao.pets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ic.yao.pets.presentation.PetsApp
import ic.yao.pets.ui.theme.PetsTheme

// TODO: 1. Create the PetDetail view
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetsTheme {
                PetsApp()
            }
        }
    }
}

