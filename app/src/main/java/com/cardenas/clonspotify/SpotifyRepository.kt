package com.cardenas.clonspotify

import com.cardenas.clonspotify.modelo.Spotify


class SpotifyRepository(private val musics:MutableList<Spotify> = ArrayList()) {

    init {
        getDataSpotify()
    }
    fun getDataSpotify(): List<Spotify> {
        musics.add(Spotify(100, "Carol g", "bichota", "gato"))
        musics.add(Spotify(200, "Bad Bunny", "la cancion", "gato1"))
        musics.add(Spotify(300, "Ozuna", "solita", "gato2"))
        musics.add(Spotify(400, "Anuel brr", "brrr", "gato3"))
        musics.add(Spotify(500, "Beky g", "cuando te bese", "gato4"))
        return musics
    }

}