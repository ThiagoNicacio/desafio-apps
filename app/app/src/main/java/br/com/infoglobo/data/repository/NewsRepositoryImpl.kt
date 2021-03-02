package br.com.infoglobo.data.repository

import br.com.infoglobo.data.api.ApiService
import br.com.infoglobo.data.model.Content
import br.com.infoglobo.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : NewsRepository{
    override fun getNews(): Content {
        return apiService.getNews()
    }
}