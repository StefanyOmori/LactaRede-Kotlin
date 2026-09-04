package com.fiap.lactarede.navigation

import kotlinx.serialization.Serializable

//object Routes {
//    const val SPLASH = "splash"
//    const val LOGIN = "login"
//    const val CADASTRO = "cadastro"
//    const val HOME = "home"
//
//    const val CONTA = "conta"
//    const val HELP = "help"
//    const val NOTIFICATIONS = "notifications"
//
//    const val AGENDAMENTOS = "agendamentos"
//    const val DOAR = "doar"
//
//    const val DOAR_CONCLUSAO = "doar_conclusao"
//
//    const val INFO = "info"
//
//    const val PONTOS_COLETA = "pontos_coleta"
//
//}

sealed class Routes(val route: String) {
    object Splash: Routes("splash")
    object login: Routes("login")
    object cadastro: Routes("cadastro")
    object Notificacoes : Routes("notificacoes")
    object Home : Routes("home")
    object MinhaConta : Routes("minha_conta")
    object Informacoes : Routes("informacoes")
    object Doar : Routes("doar")
    object DoarConclusao : Routes("doar_conclusao")
    object MeusAgendamentos : Routes("meus_agendamentos")
    object AjudaSuporte : Routes("ajuda_suporte")
    object PontosColeta : Routes("pontos_coleta")
}