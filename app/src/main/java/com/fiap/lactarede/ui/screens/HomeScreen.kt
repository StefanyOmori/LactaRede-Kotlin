@file:OptIn(ExperimentalMaterial3Api::class)

package com.fiap.lactarede.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.navigation.Routes
import com.fiap.lactarede.ui.components.AppDrawerContent
import com.fiap.lactarede.ui.components.MenuItem
import kotlinx.coroutines.launch

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun HomeScreen(
    onNavigateToDonate: () -> Unit,
    onNavigateToInfo: () -> Unit,
    onNavigateToPontosColeta: () -> Unit,
    onNavigate: (String) -> Unit
) {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    val menuItems = listOf(
        MenuItem(
            label = "Início",
            icon = Icons.Default.Home,
            route = Routes.HOME
        ),
        MenuItem(
            label = "Agendamentos",
            icon = Icons.Default.CalendarToday,
            route = Routes.AGENDAMENTOS
        ),
        MenuItem(
            label = "Notificações",
            icon = Icons.Default.Notifications,
            route = Routes.NOTIFICATIONS
        ),
        MenuItem(
            label = "Conta",
            icon = Icons.Default.Person,
            route = Routes.CONTA
        ),
        MenuItem(
            label = "Ajuda",
            icon = Icons.Default.Help,
            route = Routes.HELP
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            AppDrawerContent(
                userName = "Usuário LactaRede",
                userEmail = "usuario@email.com",
                menuItems = menuItems,
                onItemClick = { item ->

                    scope.launch {
                        drawerState.close()
                    }

                    if (item.route != Routes.HOME) {
                        onNavigate(item.route)
                    }
                }
            )
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "LactaRede",
                            fontWeight = FontWeight.Bold
                        )
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
                    }
                )
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp)
            ) {

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Bem-vindo ao LactaRede!",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Doe leite materno e ajude a transformar vidas.",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(28.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(AzulLactaRede)
                        .padding(20.dp)
                ) {

                    Column {

                        Text(
                            text = "Faça parte dessa corrente do bem",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Sua doação pode ajudar bebês que precisam de leite materno.",
                            fontSize = 14.sp,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        Button(
                            onClick = onNavigateToDonate,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            )
                        ) {

                            Text(
                                text = "Quero doar",
                                color = AzulLactaRede,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Acesse rapidamente",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    HomeOption(
                        icon = Icons.Default.Info,
                        title = "Informações",
                        modifier = Modifier.weight(1f),
                        onClick = onNavigateToInfo
                    )

                    HomeOption(
                        icon = Icons.Default.Recycling,
                        title = "Pontos de coleta",
                        modifier = Modifier.weight(1f),
                        onClick = onNavigateToPontosColeta
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    HomeOption(
                        icon = Icons.Default.CalendarToday,
                        title = "Agendamentos",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onNavigate(Routes.AGENDAMENTOS)
                        }
                    )

                    HomeOption(
                        icon = Icons.Default.Notifications,
                        title = "Notificações",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onNavigate(Routes.NOTIFICATIONS)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeOption(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier.height(110.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF2F8FB)
        )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = AzulLactaRede,
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 13.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}