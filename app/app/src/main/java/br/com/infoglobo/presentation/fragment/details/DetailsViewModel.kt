package br.com.infoglobo.presentation.fragment.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.infoglobo.data.model.News

class DetailsViewModel @ViewModelInject internal constructor(): ViewModel() {

    val news = MutableLiveData<News>().apply { value = null }

    fun bound(news : News) {
        this.news.value = news
    }
}