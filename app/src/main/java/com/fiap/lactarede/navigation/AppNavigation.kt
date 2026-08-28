package com.fiap.lactarede.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fiap.lactarede.ui.screens.CadastroScreen
import com.fiap.lactarede.ui.screens.DoarScreen
import com.fiap.lactarede.ui.screens.HelpScreen
import com.fiap.lactarede.ui.screens.LoginScreen
import com.fiap.lactarede.ui.screens.NotificationScreen
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
                }
            )
        }

        composable(Routes.CADASTRO) {

            CadastroScreen(
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.HELP) {

            HelpScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.NOTIFICATIONS) {
            NotificationScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.DOAR) {
            DoarScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onFinalizarClick = {
                    //navController.navigate(Routes.AGENDAMENTOS)
                }
            )
        }

    }
}