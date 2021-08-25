package br.com.dio.businesscard.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.businesscard.binding.CardBinding

class BusinessCardAdapter :
    ListAdapter<CardBinding, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val TYPE_1 = 1
        const val TYPE_2 = 2
        const val TYPE_3 = 3
        const val TYPE_4 = 4
        const val TYPE_5 = 5

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CardBinding>() {
            override fun areItemsTheSame(oldItem: CardBinding, newItem: CardBinding) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: CardBinding, newItem: CardBinding) =
                oldItem.id == newItem.id
        }
    }

    var clickListener: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_1 -> CardOneHolder.from(parent)
            TYPE_2 -> CardTwoHolder.from(parent)
            TYPE_3 -> CardThreeHolder.from(parent)
            TYPE_4 -> CardFourHolder.from(parent)
            TYPE_5 -> CardFiveHolder.from(parent)
            else -> throw ClassCastException("ViewType desconhecido: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CardOneHolder -> {
                val item = getItem(position)
                holder.bind(item, false, clickListener)
            }
            is CardTwoHolder -> {
                val item = getItem(position)
                holder.bind(item, false, clickListener)
            }
            is CardThreeHolder -> {
                val item = getItem(position)
                holder.bind(item, false, clickListener)
            }
            is CardFourHolder -> {
                val item = getItem(position)
                holder.bind(item, false, clickListener)
            }
            is CardFiveHolder -> {
                val item = getItem(position)
                holder.bind(item, false, clickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).tipoCard) {
            1 -> SampleCardAdapter.TYPE_1
            2 -> SampleCardAdapter.TYPE_2
            3 -> SampleCardAdapter.TYPE_3
            4 -> SampleCardAdapter.TYPE_4
            5 -> SampleCardAdapter.TYPE_5
            else -> throw IllegalArgumentException("Tipo de dado inválido: $position")
        }
    }

}