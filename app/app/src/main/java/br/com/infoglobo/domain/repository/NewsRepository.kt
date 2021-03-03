package br.com.infoglobo.domain.repository

import br.com.infoglobo.data.model.Content
import io.reactivex.Single

interface NewsRepository {
    fun getNews() : Single<ArrayList<Content>>
}