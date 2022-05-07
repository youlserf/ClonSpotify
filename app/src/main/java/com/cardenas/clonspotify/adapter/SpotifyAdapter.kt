package com.cardenas.clonspotify.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.cardenas.clonspotify.databinding.ItemSpotifyBinding
import com.cardenas.clonspotify.modelo.Spotify
import android.widget.Toast
import com.cardenas.clonspotify.R


class SpotifyAdapter(private val dataSet: List<Spotify>): RecyclerView.Adapter<SpotifyAdapter.ViewHolder>() {

    /**
     * Proporciona una referencia al tipo de vistas que está utilizando
     * (custom ViewHolder).
     */


    class ViewHolder(private val binding: ItemSpotifyBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var nameSong: TextView = binding.nameSong
        var email: TextView = binding.description
        val estado: ImageButton = binding.playPausa
        val whats: ImageButton = binding.whats
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Crear una nueva vista, que define la interfaz de usuario del elemento de la lista
        val itemBinding = ItemSpotifyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    // Reemplazar el contenido de una vista (invocado por el administrador de diseño)
    override fun onBindViewHolder(binding: ViewHolder, position: Int) {
        val contact: ItemSpotifyBinding
        // Obtenga el elemento de su conjunto de datos en esta posición y reemplace el contenido de la vista con ese elemento

        val spotify: Spotify = this.dataSet[position]
        val context = binding.itemView.context

        val idRes = context.resources.getIdentifier(spotify.picture, "drawable", context.packageName)

        binding.nameSong.text = spotify.songName
        binding.email.text = spotify.description
        binding.picture.setImageResource(idRes)

        binding.picture.setOnClickListener {
            Toast.makeText(context, "Gatito $position", Toast.LENGTH_SHORT).show()
        }

        var es = false
        binding.estado.setOnClickListener {

            if (es == false) {
                Toast.makeText(context, "play ${spotify.description}", Toast.LENGTH_SHORT).show()
                binding.estado.setBackgroundResource(R.mipmap.pause)
                es = true
            }else{
                Toast.makeText(context, "pause ${spotify.description}", Toast.LENGTH_SHORT).show()
                binding.estado.setBackgroundResource(R.mipmap.play)
                es = false
            }
        }




        binding.whats.setOnClickListener{
            Toast.makeText(context, "whatsapp", Toast.LENGTH_SHORT).show()
                val message = spotify.songName

                val intent = Intent(Intent.ACTION_SEND)

                // Setting Intent type
                intent.type = "text/plain"

                // Setting whatsapp package name
                intent.setPackage("com.whatsapp")

                // Give your message here
                intent.putExtra(Intent.EXTRA_TEXT, message)

        }
    }
    //Devuelve el tamaño de tu conjunto de datos (invocado por el administrador de diseño)
    override fun getItemCount(): Int = dataSet.size
}







