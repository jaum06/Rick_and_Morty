package com.zlasher.rick_and_morty.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zlasher.rick_and_morty.databinding.FragmentCharacterDetailBinding
import com.zlasher.rick_and_morty.model.Retrofit

open class CharacterDetailFragment : Fragment(), Retrofit {

    private lateinit var characterBinding: FragmentCharacterDetailBinding
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        characterBinding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return characterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildCharacter()
    }

    private fun buildCharacter() {
        val character = args.character
        with(characterBinding) {

            Log.d("test1", "character.image")
            Log.d("test", character.image)

            Glide.with(characterDetailImage)
                .load(character.image)
                .apply(RequestOptions.circleCropTransform())
                .into(characterDetailImage)

            nameCharacterDetailText.text = character.name
            statusText.text = character.status
            speciesText.text = character.species
            genderText.text = character.gender
            originText.text = character.origin.name
            locationText.text = character.location.name
        }
    }
}