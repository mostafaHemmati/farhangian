package com.hemmati.farhangian.presentation.videolist.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hemmati.farhangian.R
import com.hemmati.farhangian.domain.model.content.VideoData
import kotlinx.android.synthetic.main.list_item_video.view.*

class VideoListAdapter(
    private val onItemClicked: (VideoData) -> Unit
) : ListAdapter<VideoData, VideoListAdapter.VideoViewHolder>(DiffItemUtil()) {

    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(
            position: Int,
            data: VideoData,
            onItemClicked: (VideoData) -> Unit
        ) {
            itemView.txtVideoName.text = (position + 1).toString()
            itemView.setOnClickListener {
                onItemClicked.invoke(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_video, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(position, getItem(position), onItemClicked)
    }

    private class DiffItemUtil : DiffUtil.ItemCallback<VideoData>() {
        override fun areItemsTheSame(oldItem: VideoData, newItem: VideoData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: VideoData, newItem: VideoData): Boolean {
            return oldItem == newItem
        }
    }

}