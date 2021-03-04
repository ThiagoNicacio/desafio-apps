package br.com.infoglobo.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

data class News(
    @SerializedName("autores") val authors : ArrayList<String> = arrayListOf(),
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
) : Serializable{

    fun getFormattedDate() : String{
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault())
        val date = df.parse(updated)
        val calendar = Calendar.getInstance()
        date?.let { calendar.time = it }
        return SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(calendar.time)
    }

    fun getAuthors() : String{
        if (authors.isNullOrEmpty())
            return ""
        var authors = ""
        var i = 0
        val size = this.authors.size
        while(i < size){
            authors += if (i + 1 == size) this.authors[i] else "${this.authors[i]}, "
            i++
        }
        return authors
    }
}