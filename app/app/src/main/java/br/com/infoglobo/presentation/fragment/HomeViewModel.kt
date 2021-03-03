package br.com.infoglobo.presentation.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
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
                responseResult
            }
            is ContentResult.Failure ->{
                responseResult
            }
        }
    }

}