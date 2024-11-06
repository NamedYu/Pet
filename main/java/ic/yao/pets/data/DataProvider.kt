package ic.yao.pets.data

import ic.yao.pets.R

object DataProvider {

    val petList = listOf(
        Pet(
            id = 1,
            name = "Monty",
            age = 14,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            drawableId = R.drawable.p1
        ),
        Pet(
            id = 2,
            name = "Jubilee",
            age = 6,
            description = "Jubilee enjoys thoughtful discussions by the campfire.",
            drawableId = R.drawable.p2
        ),
        Pet(
            id = 3,
            name = "Beezy",
            age = 8,
            description = "Beezy's favorite past-time is helping you choose your brand color.",
            drawableId = R.drawable.p3
        ),
        Pet(
            id = 4,
            name = "Mochi",
            age = 10,
            description = "Mochi is the perfect \"rubbery ducky\" debugging pup, always listening.",
            drawableId = R.drawable.p4
        ),
        Pet(
            id = 5,
            name = "Brewery",
            age = 12,
            description = "Brewery loves fetching you your favorite homebrew.",
            drawableId = R.drawable.p5
        ),
        Pet(
            id = 6,
            name = "Lucy",
            age = 8,
            description = "Picture yourself in a boat on a river, Lucy is a pup with kaleidoscope eyes.",
            drawableId = R.drawable.p6
        ),
        Pet(
            id = 7,
            name = "Astro",
            age = 10,
            description = "Is it a bird? A plane? No, it's Astro blasting off into your heart!",
            drawableId = R.drawable.p7
        ),
        Pet(
            id = 8,
            name = "Boo",
            age = 9,
            description = "Boo is just a teddy bear in disguise. What he lacks in grace, he makes up in charm.",
            drawableId = R.drawable.p8
        ),
        Pet(
            id = 9,
            name = "Pippa",
            age = 7,
            description = "Pippa likes to look out the window and write pup-poetry.",
            drawableId = R.drawable.p9
        ),
        Pet(
            id = 10,
            name = "Coco",
            age = 10,
            description = "Coco enjoys getting pampered at the local puppy spa.",
            drawableId = R.drawable.p10
        ),
        Pet(
            id = 11,
            name = "Brody",
            age = 13,
            description = "Brody is a good boy, waiting for your next command.",
            drawableId = R.drawable.p11
        ),
        Pet(
            id = 12,
            name = "Stella",
            age = 14,
            description = "Stella! Calm and always up for a challenge, she's the perfect companion.",
            drawableId = R.drawable.p12
        ),
    )

    fun getPetById(id: Int): Pet {
        return petList.first { it.id == id }
    }
}