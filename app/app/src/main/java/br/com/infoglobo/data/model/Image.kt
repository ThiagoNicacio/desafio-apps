package br.com.infoglobo.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Image(
    @SerializedName("autor") val author : String,
    @SerializedName("fonte")val source : String = "",
    @SerializedName("legenda")val subtitle : String = "",
    val url : String
) : Serializable{
    fun getSubtitleWithSource() : String{
        return "$subtitle: $source"
    }
}