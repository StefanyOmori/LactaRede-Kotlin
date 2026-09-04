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
            data = "Segunda-feira, 14 de setembro de 2026",
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
            data = "Quarta-feira, 16 de setembro de 2026",
            horario = "14:30",
            tipo = "Coleta domiciliar",
            endereco = "Rua das Flores, 45 - Centro",
            distancia = "3,1 km",
            corStatus = Color(0xFFFFF1D9)
        ),
        Agendamento(
            id = 3,
            local = "Banco de Leite Humano",
            instituicao = "Hospital São Lucas",
            status = "Confirmado",
            data = "Sexta-feira, 18 de setembro de 2026",
            horario = "10:00",
            tipo = "Entrega em ponto de coleta",
            endereco = "Rua das Palmeiras, 210 - Vila Nova",
            distancia = "4,2 km",
            corStatus = Color(0xFFE2F5EC)
        ),
        Agendamento(
            id = 4,
            local = "Ponto de Coleta Central",
            instituicao = "Hospital Vida",
            status = "Pendente",
            data = "Segunda-feira, 21 de setembro de 2026",
            horario = "15:00",
            tipo = "Coleta domiciliar",
            endereco = "Av. Brasil, 560 - Centro",
            distancia = "1,8 km",
            corStatus = Color(0xFFFFF1D9)
        ),
        Agendamento(
            id = 5,
            local = "Banco de Leite Humano",
            instituicao = "Hospital Santa Maria",
            status = "Concluído",
            data = "Segunda-feira, 24 de agosto de 2026",
            horario = "9:30",
            tipo = "Entrega em ponto de coleta",
            endereco = "Av. Central, 123 - Centro",
            distancia = "2,3 km",
            corStatus = Color(0xFFE8E8E8)
        ),
        Agendamento(
            id = 6,
            local = "Posto de Coleta -\nMaternidade",
            instituicao = "Maternidade Esperança",
            status = "Concluído",
            data = "Quarta-feira, 26 de agosto de 2026",
            horario = "13:00",
            tipo = "Coleta domiciliar",
            endereco = "Rua das Flores, 45 - Centro",
            distancia = "3,1 km",
            corStatus = Color(0xFFE8E8E8)
        ),
        Agendamento(
            id = 7,
            local = "Ponto de Coleta Central",
            instituicao = "Hospital Vida",
            status = "Cancelado",
            data = "Sexta-feira, 28 de agosto de 2026",
            horario = "11:00",
            tipo = "Entrega em ponto de coleta",
            endereco = "Av. Brasil, 560 - Centro",
            distancia = "1,8 km",
            corStatus = Color(0xFFFFE0E0)
        ),
        Agendamento(
            id = 8,
            local = "Banco de Leite Humano",
            instituicao = "Hospital São Lucas",
            status = "Cancelado",
            data = "Segunda-feira, 31 de agosto de 2026",
            horario = "16:00",
            tipo = "Coleta domiciliar",
            endereco = "Rua das Palmeiras, 210 - Vila Nova",
            distancia = "4,2 km",
            corStatus = Color(0xFFFFE0E0)
        ),
        Agendamento(
            id = 9,
            local = "Banco de Leite Humano",
            instituicao = "Hospital Santa Maria",
            status = "Concluído",
            data = "Sexta-feira, 21 de agosto de 2026",
            horario = "10:30",
            tipo = "Entrega em ponto de coleta",
            endereco = "Av. Central, 123 - Centro",
            distancia = "2,3 km",
            corStatus = Color(0xFFE8E8E8)
        )
    )
}