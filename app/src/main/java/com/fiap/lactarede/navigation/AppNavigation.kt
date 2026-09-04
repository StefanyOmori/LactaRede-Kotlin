package com.fiap.lactarede.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fiap.lactarede.ui.components.AppDrawerContent
import com.fiap.lactarede.ui.components.MenuItem
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
import kotlinx.coroutines.launch

private val AzulLactaRede = Color(0xFF55B1DF)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {

    val navController: NavHostController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val mainRoutes = setOf(
        Routes.Home.route,
        Routes.MinhaConta.route,
        Routes.Informacoes.route,
        Routes.PontosColeta.route,
        Routes.Doar.route,
        Routes.DoarConclusao.route,
        Routes.MeusAgendamentos.route,
        Routes.AjudaSuporte.route,
        Routes.Notificacoes.route
    )

    val showMainLayout = currentRoute in mainRoutes

    val menuItems = listOf(
        MenuItem(
            "Minha Conta",
            Icons.Default.Person,
            Routes.MinhaConta.route
        ),
        MenuItem(
            "Início",
            Icons.Default.Home,
            Routes.Home.route
        ),
        MenuItem(
            "Informações",
            Icons.Default.Info,
            Routes.Informacoes.route
        ),
        MenuItem(
            "Doar",
            Icons.Default.WaterDrop,
            Routes.Doar.route
        ),
        MenuItem(
            "Meus Agendamentos",
            Icons.Default.CalendarMonth,
            Routes.MeusAgendamentos.route
        ),
        MenuItem(
            "Ajuda e Suporte",
            Icons.Default.HelpOutline,
            Routes.AjudaSuporte.route
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = showMainLayout,
        drawerContent = {

            if (showMainLayout) {
                AppDrawerContent(
                    userName = "Mariana Ribeiro",
                    userEmail = "mari.ribeiro@gmail.com",
                    menuItems = menuItems,
                    onItemClick = { item ->

                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate(item.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) {

        Scaffold(
            topBar = {

                if (showMainLayout) {
                    TopAppBar(
                        title = {
                            Text("LactaRede")
                        },

                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Abrir menu"
                                )
                            }
                        },

                        actions = {
                            IconButton(
                                onClick = {
                                    navController.navigate(
                                        Routes.Notificacoes.route
                                    )
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "Notificações"
                                )
                            }
                        },

                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = AzulLactaRede,
                            titleContentColor = Color.White,
                            navigationIconContentColor = Color.White,
                            actionIconContentColor = Color.White
                        )
                    )
                }
            }
        ) { innerPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        if (showMainLayout) {
                            innerPadding
                        } else {
                            androidx.compose.foundation.layout.PaddingValues()
                        }
                    )
            ) {

                NavHost(
                    navController = navController,
                    startDestination = Routes.Splash.route
                ) {

                    composable(Routes.Splash.route) {
                        SplashScreen(
                            onComecarClick = {
                                navController.navigate(
                                    Routes.login.route
                                ) {
                                    popUpTo(Routes.Splash.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }

                    composable(Routes.login.route) {
                        LoginScreen(
                            onCadastrarClick = {
                                navController.navigate(
                                    Routes.cadastro.route
                                )
                            },

                            onLoginClick = {
                                navController.navigate(
                                    Routes.Home.route
                                ) {
                                    popUpTo(Routes.login.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }

                    composable(Routes.cadastro.route) {
                        CadastroScreen(
                            onLoginClick = {
                                navController.popBackStack()
                            },

                            onCadastroClick = {
                                navController.navigate(
                                    Routes.Home.route
                                ) {
                                    popUpTo(Routes.cadastro.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }

                    composable(Routes.Home.route) {
                        HomeScreen(
                            onNavigateToDonate = {
                                navController.navigate(
                                    Routes.Doar.route
                                )
                            },

                            onNavigateToInfo = {
                                navController.navigate(
                                    Routes.Informacoes.route
                                )
                            },

                            onNavigateToPontosColeta = {
                                navController.navigate(
                                    Routes.PontosColeta.route
                                )
                            }
                        )
                    }

                    composable(Routes.MinhaConta.route) {
                        ContaScreen()
                    }

                    composable(Routes.Informacoes.route) {
                        InfoScreen()
                    }

                    composable(Routes.PontosColeta.route) {
                        PontosColetaScreen()
                    }

                    composable(Routes.Doar.route) {
                        DoarScreen(
                            onBackClick = {
                                navController.popBackStack()
                            },

                            onFinalizarClick = {
                                navController.navigate(
                                    Routes.DoarConclusao.route
                                )
                            }
                        )
                    }

                    composable(Routes.DoarConclusao.route) {
                        DoarConclusaoScreen(
                            onVerAgendamentoClick = {
                                navController.navigate(
                                    Routes.MeusAgendamentos.route
                                )
                            },

                            onVoltarInicioClick = {
                                navController.navigate(
                                    Routes.Home.route
                                ) {
                                    popUpTo(Routes.Home.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }

                    composable(Routes.MeusAgendamentos.route) {
                        AgendamentosScreen()
                    }

                    composable(Routes.AjudaSuporte.route) {
                        HelpScreen()
                    }

                    composable(Routes.Notificacoes.route) {
                        NotificationScreen()
                    }
                }
            }
        }
    }
}