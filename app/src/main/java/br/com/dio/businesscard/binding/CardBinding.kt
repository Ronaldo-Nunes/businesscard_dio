package br.com.dio.businesscard.binding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class CardBinding : BaseObservable() {
    @Bindable
    var id: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @Bindable
    var tipoCard: Int = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.tipoCard)
        }

    @Bindable
    var nome: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.nome)
        }

    @Bindable
    var empresa: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.empresa)
        }

    @Bindable
    var telefone: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.telefone)
        }

    @Bindable
    var email: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    @Bindable
    var textColor: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.textColor)
        }

    @Bindable
    var backgroundColor: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.backgroundColor)
        }

    companion object {
        fun CardBinding.isNotBlank(): Boolean {
            return nome.isNotBlank()
                    && empresa.isNotBlank()
                    && telefone.isNotBlank()
                    && email.isNotBlank()
                    && textColor.isNotBlank()
                    && backgroundColor.isNotBlank()
        }
    }
}