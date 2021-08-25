package br.com.dio.businesscard.binding

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("app:tintImage")
    fun ImageView.setImageTint(hexColorString: String?) {
        if (!hexColorString.isNullOrBlank()) {
            val intColor = Color.parseColor(hexColorString)
            setColorFilter(intColor)
        }
    }

    @JvmStatic
    @BindingAdapter("app:colorText")
    fun TextView.setColorText(hexColorString: String?) {
        if (!hexColorString.isNullOrBlank()) {
            val intColor = Color.parseColor(hexColorString)
            setTextColor(intColor)
        }
    }

    @JvmStatic
    @BindingAdapter("app:colorBack")
    fun View.setBackColor(hexColorString: String?) {
        if (!hexColorString.isNullOrBlank()) {
            val intColor = Color.parseColor(hexColorString)
            setBackgroundColor(intColor)
        }
    }

    @JvmStatic
    @BindingAdapter("app:colorCard")
    fun CardView.setCardColor(hexColorString: String?) {
        if (!hexColorString.isNullOrBlank()) {
            val intColor = Color.parseColor(hexColorString)
            setCardBackgroundColor(intColor)
        }
    }
}