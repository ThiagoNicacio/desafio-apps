package br.com.infoglobo.domain.usecase

import br.com.infoglobo.domain.ContentResult
import br.com.infoglobo.domain.repository.NewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val getNewsRepository: NewsRepository){
    fun execute(): Observable<ContentResult> {
        return getNewsRepository.getNews()
            .toObservable()
            .map { ContentResult.Success(it) as ContentResult }
            .onErrorReturn { ContentResult.Failure(it)}
            .startWith(ContentResult.Loading)
    }
}