package br.com.dio.businesscard.viewModel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dio.businesscard.binding.CardBinding
import br.com.dio.businesscard.binding.CardBinding.Companion.isNotBlank
import br.com.dio.businesscard.data.BusinessCardRepository
import br.com.dio.businesscard.util.Evento

class AddCardViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {
    private var colorText = "#0a0a0a"
    private var colorBack = "#91fff4"
    private var _cardBinding = MutableLiveData(CardBinding())
    private var _finish = MutableLiveData(Evento(false))
    private var _sampleList = MutableLiveData<List<CardBinding>>()
    val sampleList: LiveData<List<CardBinding>> = _sampleList
    val finish: LiveData<Evento<Boolean>> = _finish

    init {
        setDefaultColors()
    }

    fun card(): LiveData<CardBinding> = _cardBinding

    fun setTextColor(colorString: String) {
        val card = _cardBinding.value ?: CardBinding()
        card.textColor = colorString
        _cardBinding.value = card
        colorText = colorString
    }

    fun setBackColor(colorString: String) {
        val card = _cardBinding.value ?: CardBinding()
        card.backgroundColor = colorString
        _cardBinding.value = card
        colorBack = colorString
    }

    fun setCardType(type: Int) {
        _cardBinding.value?.tipoCard = type
    }

    fun fillSampleList(card: CardBinding) {
        val sampleCardList = mutableListOf<CardBinding>()
        sampleCardList.clear()
        for (i in 1..5) {
            val item = CardBinding().apply {
                id = i
                tipoCard = i
                nome = card.nome
                telefone = card.telefone
                empresa = card.empresa
                email = card.email
                textColor = card.textColor
                backgroundColor = card.backgroundColor
            }
            sampleCardList.add(item)
        }
        _sampleList.value = sampleCardList
    }

    fun getTextColor(): Int {
        return Color.parseColor(colorText)
    }

    fun getBackColor(): Int {
        return Color.parseColor(colorBack)
    }

    fun camposValidos(): Boolean {
        val card = _cardBinding.value
        return card != null && card.isNotBlank()
    }

    fun insert() {
        val card = _cardBinding.value
        if (card != null && card.isNotBlank()) {
            businessCardRepository.insert(card)
            _finish.value = Evento(true)
        }
    }

    private fun setDefaultColors() {
        _cardBinding.value?.textColor = colorText
        _cardBinding.value?.backgroundColor = colorBack
    }

}

class AddCardViewModelFactory(private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddCardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddCardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}