package br.com.dio.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipoCard: Int = 1,
    val nome: String,
    val empresa: String,
    val telefone: String,
    val email: String,
    val textColor: String,
    val backgroundColor: String
)