package com.example.tugasjetpackcompose.Screen

import com.example.tugasjetpackcompose.R

class JenisHewan (
    var name : String,
    var namaIlmiah : String,
    var image : Int,
)

fun AllJenisHewan(): List<JenisHewan> {
    return listOf(
        JenisHewan(
            name = "Verreaux's Eagle",
            namaIlmiah = "Aquila verreauxii",
            image = R.drawable.verreauxs_eagle
        ),
        JenisHewan(
            name = "kingfisher",
            namaIlmiah = "Alcedo atthis",
            image = R.drawable.kingfisher
        ),
        JenisHewan(
            name = "Red-Tailed Hawk",
            namaIlmiah = "Buteo jamaicensis",
            image = R.drawable.red_tailed_hawk
        ),
        JenisHewan(
            name = "Eastern Red Bat",
            namaIlmiah = "Lasiurus borealis",
            image = R.drawable.eastern_red_bat
        ),
        JenisHewan(
            name = "Carrion Crow",
            namaIlmiah = "Corvus corone",
            image = R.drawable.carrion_crow
        ),
        JenisHewan(
            name = "Robin bird",
            namaIlmiah = "Erithacus rubecula",
            image = R.drawable.robin
        ),
        JenisHewan(
            name = "Harpy Eagle",
            namaIlmiah = "Harpia harpyja",
            image = R.drawable.harpy_eagle
        ),
        JenisHewan(
            name = "Mute Swan",
            namaIlmiah = "Cygnus olor",
            image = R.drawable.mute_swan
        ),
        JenisHewan(
            name = "Bald Eagle",
            namaIlmiah = "Haliaeetus leucocephalus",
            image = R.drawable.bald_eagle
        ),
        JenisHewan(
            name = "Siberian Tiger",
            namaIlmiah = "Panthera tigris altaica",
            image = R.drawable.siberia_tiger
        ),
        JenisHewan(
            name = "Lammergeier",
            namaIlmiah = "Gypaetus barbatus",
            image = R.drawable.lammergeier
        ),
        JenisHewan(
            name = "Common Raven",
            namaIlmiah = "Corvus corax",
            image = R.drawable.common_raven
        ),
        JenisHewan(
            name = "Peacock Bird",
            namaIlmiah = "Pavo cristatus",
            image = R.drawable.peacock_bird
        ),
        JenisHewan(
            name = "White Tail Eagle",
            namaIlmiah = "Haliaeetus albicilla",
            image = R.drawable.white_tail_eagle
        ),
        JenisHewan(
            name = "Magpie Bird",
            namaIlmiah = "Pica pica",
            image = R.drawable.magpie
        ),
    )
}