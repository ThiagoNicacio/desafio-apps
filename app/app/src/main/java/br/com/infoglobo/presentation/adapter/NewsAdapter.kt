package br.com.infoglobo.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.infoglobo.data.model.News
import br.com.infoglobo.databinding.ItemNewsBinding

class NewsAdapter (private var news : List<News>) : RecyclerView.Adapter<NewsAdapter.Holder>(), AdapterContract{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount(): Int {
        return news.size
    }

    class Holder(private val binding : ItemNewsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : News){
            binding.apply {
                news = item
            }
        }
    }

    override fun replaceItems(items: List<*>) {
        this.news = items.filterIsInstance<News>() as ArrayList<News>
        notifyDataSetChanged()
    }
}