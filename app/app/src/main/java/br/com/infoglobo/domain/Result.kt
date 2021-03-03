package br.com.infoglobo.domain

import br.com.infoglobo.data.model.Content

sealed class ContentResult{
    object Loading : ContentResult()
    data class Success(val content: ArrayList<Content>) : ContentResult()
    data class Failure(val throwable: Throwable) : ContentResult()
}