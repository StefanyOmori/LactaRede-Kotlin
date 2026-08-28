package com.fiap.lactarede.data
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.ui.graphics.Color
import com.fiap.lactarede.model.Notification

object NotificationData {

    val notificacoes = listOf(

        Notification(
            id = 1,
            titulo = "Agendamento confirmado",
            descricao = "Sua coleta foi agendada para",
            detalhe = "25/05/2025 às 14h00",
            tempo = "Agora",
            icone = Icons.Default.Schedule,
            corIcone = Color(0xFF5689D8),
            lida = false
        ),

        Notification(
            id = 2,
            titulo = "Triagem aprovada",
            descricao = "Você preenche os requisitos para doar\n" +
                    "leite materno. Agradecemos muito por\n" +
                    "querer ajudar! 💙",
            tempo = "2h atrás",
            icone = Icons.Default.CheckCircle,
            corIcone = Color(0xFF75AC5C),
            lida = false
        ),

        Notification(
            id = 3,
            titulo = "Sua doação faz a diferença",
            descricao = "O leite doado por você pode ajudar\n" +
                    "até 10 bebês prematuros por dia.",
            icone = Icons.Default.WaterDrop,
            corIcone = Color(0xFFA64D78),
            lida = true
        ),

        Notification(
            id = 4,
            titulo = "Pontos de coleta próximo",
            descricao = "Há um ponto de coleta novo perto de você.\n" +
                    "Confira a localização. ›",
            icone = Icons.Default.LocationOn,
            corIcone = Color(0xFFF1C94C),
            lida = true
        ),

        Notification(
            id = 5,
            titulo = "Atualização do aplicativo",
            descricao = "Uma nova versão do LactaRede está\n" +
                    "disponível. Atualize agora!",
            icone = Icons.Default.Info,
            corIcone = Color(0xFF999999),
            lida = true
        )
    )
}