package br.com.dio.businesscard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.businesscard.binding.CardBinding
import br.com.dio.businesscard.databinding.*

class CardOneHolder(private val binding: BusinessCardModelOneBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardBinding, isSelected: Boolean = false, listener: View.OnClickListener) {
        binding.infoCard = item
        binding.isSelected = isSelected
        binding.click = listener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): CardOneHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BusinessCardModelOneBinding.inflate(layoutInflater, parent, false)
            return CardOneHolder(binding)
        }
    }
}

class CardTwoHolder(private val binding: BusinessCardModelTwoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardBinding, isSelected: Boolean = false, listener: View.OnClickListener) {
        binding.infoCard = item
        binding.isSelected = isSelected
        binding.click = listener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): CardTwoHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BusinessCardModelTwoBinding.inflate(layoutInflater, parent, false)
            return CardTwoHolder(binding)
        }
    }
}

class CardThreeHolder(private val binding: BusinessCardModelThreeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardBinding, isSelected: Boolean = false, listener: View.OnClickListener) {
        binding.infoCard = item
        binding.isSelected = isSelected
        binding.click = listener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): CardThreeHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BusinessCardModelThreeBinding.inflate(layoutInflater, parent, false)
            return CardThreeHolder(binding)
        }
    }
}

class CardFourHolder(private val binding: BusinessCardModelFourBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardBinding, isSelected: Boolean = false, listener: View.OnClickListener) {
        binding.infoCard = item
        binding.isSelected = isSelected
        binding.click = listener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): CardFourHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BusinessCardModelFourBinding.inflate(layoutInflater, parent, false)
            return CardFourHolder(binding)
        }
    }
}

class CardFiveHolder(private val binding: BusinessCardModelFiveBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardBinding, isSelected: Boolean = false, listener: View.OnClickListener) {
        binding.infoCard = item
        binding.isSelected = isSelected
        binding.click = listener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): CardFiveHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BusinessCardModelFiveBinding.inflate(layoutInflater, parent, false)
            return CardFiveHolder(binding)
        }
    }
}