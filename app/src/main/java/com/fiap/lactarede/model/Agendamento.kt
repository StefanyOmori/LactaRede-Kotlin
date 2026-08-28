package com.fiap.lactarede.model

import androidx.compose.ui.graphics.Color

data class Agendamento(
    val id: Int,
    val local: String,
    val instituicao: String,
    val status: String,
    val data: String,
    val horario: String,
    val tipo: String,
    val endereco: String,
    val distancia: String,
    val corStatus: Color
)