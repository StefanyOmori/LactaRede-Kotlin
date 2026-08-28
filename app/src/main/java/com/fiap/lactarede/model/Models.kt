package com.fiap.lactarede.model

data class UserProfile(
    val name: String,
    val email: String,
    val totalDonatedLiters: String,
    val donorsCount: Int,
    val babiesBenefited: Int
)

data class Campaign(
    val id: String,
    val title: String,
    val date: String,
    val description: String
)

data class Info(
    val id: String,
    val title: String,
    val iconName: String,
    val description: String = "Saiba mais"
)

data class PontosColeta(
    val id: String,
    val name: String,
    val subtitle: String,
    val address: String,
    val distance: String
)