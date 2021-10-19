package com.sophia.movieapp_simple.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sophia.movieapp_simple.databinding.TvShowLayoutAdapterItemBinding
import com.sophia.movieapp_simple.models.TvShowItem

class TvShowAdapter : ListAdapter<TvShowItem, TvShowAdapter.MyViewHolder>(

    object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean =
            oldItem == newItem

    }

) {
    inner class MyViewHolder(val binding: TvShowLayoutAdapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(tvShowItem: TvShowItem) {
                binding.textView.text = tvShowItem.name
                binding.imageView.load(tvShowItem.image.original) {
                    crossfade(true)
                    crossfade(1000)
                }
            }

    }
//    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<TvShowItem>
    get() = currentList
    set(value) {
        submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            TvShowLayoutAdapterItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.bind(currentTvShow)
    }
}