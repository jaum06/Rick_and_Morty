package com.zlasher.rick_and_morty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlasher.rick_and_morty.adapter.EpisodeAdapter
import com.zlasher.rick_and_morty.databinding.FragmentEpisodesBinding
import com.zlasher.rick_and_morty.detail.EpisodeDetail
import com.zlasher.rick_and_morty.model.APIService
import com.zlasher.rick_and_morty.model.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EpisodesFragment : Fragment(), Retrofit {

    private lateinit var episodeBinding: FragmentEpisodesBinding
    private lateinit var adapter: EpisodeAdapter
    private val episodesList = mutableListOf<EpisodeDetail>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        episodeBinding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return episodeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        searchEpisodes()
    }

    private fun initRecyclerView() {
        adapter = EpisodeAdapter(episodesList)
        episodeBinding.episodeRecycler.layoutManager = LinearLayoutManager(context)
        episodeBinding.episodeRecycler.adapter = adapter
    }

    private fun searchEpisodes() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getEpisodes()
            val episode = call.body()

            activity?.runOnUiThread {
                if (call.isSuccessful) {
                    val episodeList: List<EpisodeDetail> = (episode?.episodeList ?: emptyList())
                    episodesList.clear()
                    episodesList.addAll(episodeList)
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