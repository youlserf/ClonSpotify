package com.cardenas.clonspotify.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cardenas.clonspotify.R
import com.cardenas.clonspotify.SpotifyRepository
import com.cardenas.clonspotify.adapter.SpotifyAdapter
import com.cardenas.clonspotify.databinding.ActivityMainBinding
import com.cardenas.clonspotify.databinding.ItemSpotifyBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var spotifyListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        spotifyListRecyclerView = binding.musicsList
        spotifyListRecyclerView.layoutManager = LinearLayoutManager(this)
        val musics = SpotifyRepository()
        val spotifyAdapter = SpotifyAdapter(musics.getDataSpotify())
        spotifyListRecyclerView.adapter = spotifyAdapter
    }
}