package br.com.dio.businesscard.util

import androidx.lifecycle.Observer

open class Evento<out T>(private val conteudo: T) {

    var foiManipulado = false
        private set // Allow external read but not write

    /**
     * Retorna o conteúdo e impede seu uso novamente.
     */
    fun obterConteudoSeNaoManipulado(): T? {
        return if (foiManipulado) {
            null
        } else {
            foiManipulado = true
            conteudo
        }
    }

    /**
     * Retorna o conteúdo, mesmo que já tenha sido tratado.
     */
    fun obterConteudo(): T = conteudo
}

class EventObserver<T>(private val onEventoConteudoNaoTratado: (T) -> Unit) : Observer<Evento<T>> {
    override fun onChanged(evento: Evento<T>?) {
        evento?.obterConteudoSeNaoManipulado()?.let { value ->
            onEventoConteudoNaoTratado(value)
        }
    }
}