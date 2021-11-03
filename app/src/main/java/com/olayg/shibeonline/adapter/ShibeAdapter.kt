package com.olayg.shibeonline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olayg.shibeonline.databinding.ItemImageBinding
import com.olayg.shibeonline.extensions.loadUrl

class ShibeAdapter : RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder>() {

    private val urls = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShibeViewHolder {
        return ShibeViewHolder.getInstance(parent)
    }

    override fun onBindViewHolder(holder: ShibeViewHolder, position: Int) {
        holder.loadUrl(urls[position])
    }

    override fun getItemCount(): Int {
        return urls.size
    }

    fun updateUrls(urls: List<String>) {
        val size = this.urls.size
        this.urls.clear()
        notifyItemRangeRemoved(0, size)

        this.urls.addAll(urls)
        notifyItemRangeInserted(0, urls.size)
    }

    class ShibeViewHolder(
        private val binding: ItemImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun loadUrl(url: String) = with(binding) {
            ivImage.loadUrl(url)
            tvUrl.text = url
        }

        companion object {

            fun getInstance(parent: ViewGroup): ShibeViewHolder {
                val binding = ItemImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ShibeViewHolder(binding)
            }
        }
    }
}