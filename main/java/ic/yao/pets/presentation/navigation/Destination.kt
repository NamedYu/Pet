package ic.yao.pets.presentation.navigation

import kotlinx.serialization.Serializable

// In this file we define the destinations in our app

// TODO 1: Define the @Serializable classes for the destinations in our app.
//  We will have two destinations: PetList (Without args) and PetDetail (petID arg).

@Serializable
object  PetList

@Serializable
data class PetDetail(val petID: Int)

@Serializable
data class Adopt(val petID: Int)
