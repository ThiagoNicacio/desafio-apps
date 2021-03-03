package br.com.infoglobo.presentation.fragment.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.infoglobo.data.model.News
import br.com.infoglobo.domain.ContentResult
import br.com.infoglobo.domain.usecase.GetNewsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class HomeViewModel @ViewModelInject internal constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val _news = MutableLiveData<List<News>>().apply { value = arrayListOf() }
    val news : LiveData<List<News>> = _news
    val singleNews = MutableLiveData<News>().apply { value = null }

    init {
        getNewsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {handleGetNewsResult(it)}
            .addTo(disposables)
    }

    private fun handleGetNewsResult(responseResult: ContentResult){
        when(responseResult){
            is ContentResult.Success ->{
                val news = responseResult.content[0].content
                _news.postValue(news)
                if (news.size > 0)
                    singleNews.postValue(news[0])
            }
            is ContentResult.Failure ->{  }
        }
    }

}