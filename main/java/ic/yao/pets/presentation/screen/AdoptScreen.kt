package ic.yao.pets.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ic.yao.pets.data.Pet
import java.io.File

@Composable
fun AdoptScreen(
    modifier: Modifier = Modifier,
    pet: Pet,
    onTerminal: () -> Unit
)  {
    AdoptContent(
        modifier = modifier,
        pet = pet,
        onTerminal = onTerminal
    )
}

@Composable
fun AdoptContent(
    modifier: Modifier = Modifier,
    pet:Pet,
    onTerminal:()->Unit
){
    val context = LocalContext.current
    var nombre:String by remember { mutableStateOf("") }
    var direccion:String by remember { mutableStateOf("") }
    var telefono:String by remember { mutableStateOf("") }
    var telefonoTrabajo:String by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Adopt ${pet.name}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Enter all information to adopt.",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Enter Your Name") },
            singleLine = true
        )
        OutlinedTextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Enter your address") },
            singleLine = true
        )
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Enter your phone number") },
            singleLine = true
        )
        OutlinedTextField(
            value = telefonoTrabajo,
            onValueChange = { telefonoTrabajo = it },
            label = { Text("Enter your work phone number") },
            singleLine = true
        )
        Spacer(modifier = modifier.height(16.dp))

        Button(onClick = {
            val fileName = "${pet.id}.txt"
            val file = File(context.filesDir, fileName)
            file.writeText("")
            val entry = "-------------------------" +
                    "\nInformacion del adoptante \n" +
                    "Nombre: $nombre\nDireccion: $direccion\nTelefono: $telefono\nTelefono del trabajo: $telefonoTrabajo\n" +
                    "Informacion Mascota\n" +
                    "ID: ${pet.id}\nNombre: ${pet.name}\nEdad: ${pet.age}"

            file.appendText(entry)
            onTerminal()
        }) {
            Text(
                text = "Adopt"
            )
        }
    }
}