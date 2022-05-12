package com.zlasher.rick_and_morty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zlasher.rick_and_morty.R.layout.character_view
import com.zlasher.rick_and_morty.adapter.CharacterAdapter.ViewHolder
import com.zlasher.rick_and_morty.databinding.CharacterViewBinding
import com.zlasher.rick_and_morty.detail.CharacterDetail

class CharacterAdapter(
    private val characters: List<CharacterDetail>,
    private val onItemClicked: (CharacterDetail) -> Unit
) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(character_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.itemView.setOnClickListener { onItemClicked(characters[position]) }
        holder.bind(character)
    }

    override fun getItemCount(): Int = characters.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CharacterViewBinding.bind(view)

        fun bind(character: CharacterDetail) {
            with(binding) {

                nameText.text = character.name

                Glide.with(characterImage)
                    .load(character.image)
                    .into(characterImage)
            }

        }

    }
}