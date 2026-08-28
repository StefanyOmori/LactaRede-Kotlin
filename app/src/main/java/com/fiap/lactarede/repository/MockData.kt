package com.fiap.lactarede.repository

import com.fiap.lactarede.model.Campaign
import com.fiap.lactarede.model.Info
import com.fiap.lactarede.model.PontosColeta
import com.fiap.lactarede.model.UserProfile

object MockData {
    val currentUser = UserProfile(
        name = "Mariana Ribeiro",
        email = "mari.ribeiro@gmail.com",
        totalDonatedLiters = "1.250L",
        donorsCount = 125,
        babiesBenefited = 340
    )

    val campaigns = listOf(
        Campaign(
            id = "1",
            title = "Campanha de Maio",
            date = "19/05 - Dia Mundial e Nacional de Doação de Leite Humano",
            description = "Juntos, podemos salvar mais vidas! Participe e compartilhe."
        ),
        Campaign(
            id = "2",
            title = "Compartilhe a Causa",
            date = "Mês Vigente",
            description = "Indique a rede para quem também está na fase de amamentação. A divulgação ajuda a multiplicar as vidas beneficiadas."
        )
    )

    val infoTopics = listOf(
        Info("1", "Benefícios do leite humano", "heart"),
        Info("2", "Como é feita a doação", "sun"),
        Info("3", "Armazenamento e transporte", "truck"),
        Info("4", "Mitos e verdades sobre a doação", "check"),
        Info("5", "Orientações de amamentação", "chat"),
        Info("6", "Pré-requisitos para doar", "clipboard")
    )

    val collectionPoints = listOf(
        PontosColeta(
            "1",
            "Banco de Leite Humano",
            "Hospital Santa Maria",
            "Av. Central, 123 - Centro",
            "2,3 km"
        ),
        PontosColeta("2", "Posto de Coleta - Maternidade", "Maternidade Esperança", "Rua das Flores, 45 - Centro", "3,1 km"),
        PontosColeta("3", "Banco de Leite Humano", "Hospital Infantil", "Av. Central, 123 - Centro", "2,3 km"),
        PontosColeta("4", "Posto de Coleta", "Hospital São Paulo", "Av. Paulista, 700 - Centro", "3,3 km")
    )

}