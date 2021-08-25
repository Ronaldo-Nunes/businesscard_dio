package br.com.dio.businesscard.data

import androidx.lifecycle.map
import br.com.dio.businesscard.binding.CardBinding
import br.com.dio.businesscard.data.Mapper.bCardToCardBinding
import br.com.dio.businesscard.data.Mapper.toBusinessCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val dao: BusinessCardDao) {

    fun insert(cardBinding: CardBinding) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(cardBinding.toBusinessCard())
        }
    }

    fun getAll() = dao.getAll().map { bCards ->
        bCards.map { businessCard -> bCardToCardBinding(businessCard) }
    }

}