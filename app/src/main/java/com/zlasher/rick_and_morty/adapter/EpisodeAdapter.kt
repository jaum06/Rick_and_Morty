package com.zlasher.rick_and_morty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zlasher.rick_and_morty.R.layout.episode_view
import com.zlasher.rick_and_morty.databinding.EpisodeViewBinding
import com.zlasher.rick_and_morty.detail.EpisodeDetail

class EpisodeAdapter(
    private val episodes: List<EpisodeDetail>
) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(episode_view, parent, false)
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    override fun getItemCount(): Int = episodes.size

    class EpisodeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val episodeBinding = EpisodeViewBinding.bind(view)

        fun bind(episode: EpisodeDetail) {
            with(episodeBinding) {
                nameText.text = episode.name
                airDateText.text = episode.air_date
                episodeText.text = episode.episode
            }
        }
    }
}