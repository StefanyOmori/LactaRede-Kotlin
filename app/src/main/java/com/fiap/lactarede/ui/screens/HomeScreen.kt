@file:OptIn(ExperimentalMaterial3Api::class)

package com.fiap.lactarede.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.navigation.Routes
import com.fiap.lactarede.repository.MockData
import com.fiap.lactarede.ui.components.AppDrawerContent
import com.fiap.lactarede.ui.components.MenuItem
import kotlinx.coroutines.launch

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun HomeScreen(
    onNavigateToDonate: () -> Unit,
    onNavigateToInfo: () -> Unit,
    onNavigateToPontosColeta: () -> Unit
) {
    val user = MockData.currentUser
    val campaigns = MockData.campaigns

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA5D6A7).copy(alpha = 0.05f)) // Fundo suave
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Saudação
        item {
            Column {
                Text(
                    text = "Olá, ${user.name.split(" ")[0]}!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Que bom ter você por aqui 💙",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        // Card Nosso Impacto
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Nosso Impacto",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        ImpactItem(value = "${user.donorsCount}", label = "Doadores\ncadastrados")
                        ImpactItem(value = user.totalDonatedLiters, label = "Leite doado")
                        ImpactItem(value = "${user.babiesBenefited}", label = "Bebês\nbeneficiados")
                    }
                }
            }
        }

        // Ações Rápidas
        item {
            Column {
                Text(
                    text = "Ações Rápidas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuickActionButton(
                        icon = Icons.Default.WaterDrop,
                        label = "Quero Doar",
                        onClick = onNavigateToDonate
                    )
                    QuickActionButton(
                        icon = Icons.Default.Info,
                        label = "Informações",
                        onClick = onNavigateToInfo
                    )
                    QuickActionButton(
                        icon = Icons.Default.LocationOn,
                        label = "Pontos de Coleta",
                        onClick = onNavigateToPontosColeta
                    )
                }
            }
        }

        // Seção Fique por dentro
        item {
            Text(
                text = "Fique por dentro",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        // Lista de Campanhas Mockadas
        items(campaigns) { campaign ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = campaign.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = campaign.date,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = campaign.description,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ImpactItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = label, fontSize = 11.sp, color = Color.Gray)
    }
}

@Composable
fun QuickActionButton(icon: ImageVector, label: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.size(100.dp, 90.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, contentDescription = label, tint = AzulLactaRede)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = label, fontSize = 11.sp, color = Color.Black)
        }
    }
}