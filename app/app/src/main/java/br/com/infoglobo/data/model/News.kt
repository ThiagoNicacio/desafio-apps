package br.com.infoglobo.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class News(
    @SerializedName("autores") val authors : ArrayList<String>,
    @SerializedName("informePublicitario") val publicityReport: Boolean,
    @SerializedName("subTitulo") val subtitle : String,
    @SerializedName("texto") val text : String,
    @SerializedName("atualizadoEm") val updated : String,
    val id : Long,
    @SerializedName("publicadoEm") val publishedIn: String,
    @SerializedName("secao") val section : Section,
    @SerializedName("tipo") val type : String,
    @SerializedName("titulo") val title : String,
    val url : String,
    @SerializedName("urlOriginal") val originalUrl : String,
    @SerializedName("imagens") val images : ArrayList<Image>
) : Serializable