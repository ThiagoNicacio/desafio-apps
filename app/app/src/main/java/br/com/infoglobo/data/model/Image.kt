package br.com.infoglobo.data.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("autor") val author : String,
    @SerializedName("fonte")val source : String,
    @SerializedName("legenda")val subtitle : String,
    val url : String
)