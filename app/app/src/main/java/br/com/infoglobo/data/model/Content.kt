package br.com.infoglobo.data.model

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("conteudos") val content : ArrayList<News>,
    val product : String
)