package br.com.infoglobo.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.infoglobo.data.model.Image
import com.squareup.picasso.Picasso

class BindingAdapters {

    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(view: ImageView, images : ArrayList<Image>?) {
            if (images.isNullOrEmpty())
                return
            else if (images[0].url.isEmpty())
                return
            Picasso.get().load(images[0].url).into(view)
        }
    }
}