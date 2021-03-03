package br.com.infoglobo.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Section(
    @SerializedName("nome") val name : String,
    val url : String
) : Serializable