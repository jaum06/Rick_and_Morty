package com.zlasher.rick_and_morty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlasher.rick_and_morty.adapter.CharacterAdapter
import com.zlasher.rick_and_morty.databinding.FragmentCharactersBinding
import com.zlasher.rick_and_morty.detail.CharacterDetail
import com.zlasher.rick_and_morty.model.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private lateinit var adapter: CharacterAdapter
    private val charactersList = mutableListOf<CharacterDetail>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        searchCharacters()
    }

    private fun initRecyclerView() {
        adapter = CharacterAdapter(charactersList)
        binding.characterRecycler.layoutManager = LinearLayoutManager(context)
        binding.characterRecycler.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun searchCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getCharacters()
            val character = call.body()


            activity?.runOnUiThread {
                if (call.isSuccessful) {
                    val images: List<CharacterDetail> =
                        (character?.character ?: emptyList())
                    charactersList.clear()
                    charactersList.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
    }
}