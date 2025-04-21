package dev.gersonchaev.labn3.CountryApp

data class Country(
    val id: Int,
    val name: String,
    val fifaRanking: Int,
    val imageUrl: String
)

val sampleCountries = listOf(
    Country(
        id = 1,
        name = "Argentina",
        fifaRanking = 1,
        imageUrl = "https://flagcdn.com/w160/ar.jpg"
    ),
    Country(
        id = 2,
        name = "Francia",
        fifaRanking = 2,
        imageUrl = "https://flagcdn.com/w160/fr.jpg"
    ),
    Country(
        id = 3,
        name = "Brasil",
        fifaRanking = 3,
        imageUrl = "https://flagcdn.com/w160/br.jpg"
    ),
    Country(
        id = 4,
        name = "Inglaterra",
        fifaRanking = 4,
        imageUrl = "https://flagcdn.com/w160/gb-eng.jpg"
    ),
    Country(
        id = 5,
        name = "Bélgica",
        fifaRanking = 5,
        imageUrl = "https://flagcdn.com/w160/be.jpg"
    )
)