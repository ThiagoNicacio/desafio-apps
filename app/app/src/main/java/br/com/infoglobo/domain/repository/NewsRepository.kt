package br.com.infoglobo.domain.repository

import br.com.infoglobo.data.model.Content

interface NewsRepository {
    fun getNews() : Content
}