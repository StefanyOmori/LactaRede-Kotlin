package com.fiap.lactarede.data

import androidx.compose.ui.graphics.Color
import com.fiap.lactarede.model.Agendamento

object AgendamentoData {

    val agendamentos = listOf(

        Agendamento(
            id = 1,
            local = "Banco de Leite Humano",
            instituicao = "Hospital Santa Maria",
            status = "Confirmado",
            data = "Segunda-feira, 26 de maio de 2025",
            horario = "9:00",
            tipo = "Entrega em ponto de coleta",
            endereco = "Av. Central, 123 - Centro",
            distancia = "2,3 km",
            corStatus = Color(0xFFE2F5EC)
        ),

        Agendamento(
            id = 2,
            local = "Posto de Coleta -\nMaternidade",
            instituicao = "Maternidade Esperança",
            status = "Pendente",
            data = "Quarta-feira, 28 de maio de 2025",
            horario = "14:30",
            tipo = "Coleta domiciliar",
            endereco = "Rua das Flores, 45 - Centro",
            distancia = "3,1 km",
            corStatus = Color(0xFFFFF1D9)
        )
    )
}