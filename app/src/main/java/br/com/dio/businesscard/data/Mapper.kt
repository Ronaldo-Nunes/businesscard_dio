package br.com.dio.businesscard.data

import br.com.dio.businesscard.binding.CardBinding

object Mapper {

    fun CardBinding.toBusinessCard(): BusinessCard {
        return BusinessCard(
            //id = id,
            tipoCard = tipoCard,
            nome = nome,
            empresa = empresa,
            telefone = telefone,
            email = email,
            textColor = textColor,
            backgroundColor = backgroundColor
        )
    }

    fun bCardToCardBinding(source: BusinessCard): CardBinding {
        return CardBinding().apply {
            id = source.id
            tipoCard = source.tipoCard
            nome = source.nome
            empresa = source.empresa
            telefone = source.telefone
            email = source.email
            textColor = source.textColor
            backgroundColor = source.backgroundColor
        }
    }
}