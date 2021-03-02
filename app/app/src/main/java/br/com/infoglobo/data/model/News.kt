package br.com.infoglobo.data.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("autores") val authors : List<String>,
    @SerializedName("informePublicitario") val publicityReport: Boolean,
    @SerializedName("subTitulo") val subtitle : String,
    @SerializedName("atualizadoEm") val updated : String,
    val id : Long,
    @SerializedName("publicadoEm") val publishedIn: String,
    @SerializedName("secao") val section : Section,
    @SerializedName("tipo") val type : String,
    @SerializedName("titulo") val title : String,
    val url : String,
    @SerializedName("urlOriginal") val originalUrl : String,
    @SerializedName("imagens") val images : List<Image>
)