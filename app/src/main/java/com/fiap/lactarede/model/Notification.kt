package com.fiap.lactarede.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Notification(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val detalhe: String = "",
    val tempo: String = "",
    val icone: ImageVector,
    val corIcone: Color,
    val lida: Boolean
)