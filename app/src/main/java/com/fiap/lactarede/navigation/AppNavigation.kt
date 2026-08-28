package com.fiap.lactarede.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fiap.lactarede.ui.screens.AgendamentosScreen
import com.fiap.lactarede.ui.screens.CadastroScreen
import com.fiap.lactarede.ui.screens.ContaScreen
import com.fiap.lactarede.ui.screens.DoarConclusaoScreen
import com.fiap.lactarede.ui.screens.DoarScreen
import com.fiap.lactarede.ui.screens.HelpScreen
import com.fiap.lactarede.ui.screens.HomeScreen
import com.fiap.lactarede.ui.screens.InfoScreen
import com.fiap.lactarede.ui.screens.LoginScreen
import com.fiap.lactarede.ui.screens.NotificationScreen
import com.fiap.lactarede.ui.screens.PontosColetaScreen
import com.fiap.lactarede.ui.screens.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {

        composable(Routes.SPLASH) {

            SplashScreen(
                onComecarClick = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.LOGIN) {

            LoginScreen(
                onCadastrarClick = {
                    navController.navigate(Routes.CADASTRO)
                },
                onLoginClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.CADASTRO) {

            CadastroScreen(
                onLoginClick = {
                    navController.popBackStack()
                },
                onCadastroClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // HOME
        composable(Routes.HOME) {
            HomeScreen(
                onNavigateToDonate = {
                    navController.navigate(Routes.DOAR)
                },

                onNavigateToInfo = {
                    navController.navigate(Routes.INFO)
                },

                onNavigateToPontosColeta = {
                    navController.navigate(Routes.PONTOS_COLETA)
                },

                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        // AJUDA
        composable(Routes.HELP) {

            HelpScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // NOTIFICAÇÕES
        composable(Routes.NOTIFICATIONS) {

            NotificationScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // DOAR
        composable(Routes.DOAR) {

            DoarScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onFinalizarClick = {
                    navController.navigate(Routes.DOAR_CONCLUSAO)
                }
            )
        }

        // AGENDAMENTOS
        composable(Routes.AGENDAMENTOS) {

            AgendamentosScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // CONTA
        composable(Routes.CONTA) {

            ContaScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // INFORMAÇÕES
        composable(Routes.INFO) {

            InfoScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // PONTOS DE COLETA
        composable(Routes.PONTOS_COLETA) {

            PontosColetaScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // CONCLUSÃO DA DOAÇÃO
        composable(Routes.DOAR_CONCLUSAO) {

            DoarConclusaoScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onVerAgendamentoClick = {
                    navController.navigate(Routes.AGENDAMENTOS)
                },
                onVoltarInicioClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.DOAR_CONCLUSAO) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}