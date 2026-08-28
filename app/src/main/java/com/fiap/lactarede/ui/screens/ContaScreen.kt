package com.fiap.lactarede.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.repository.MockData

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun ContaScreen(onBackClick: () -> Unit = {}) {
    val user = MockData.currentUser

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Avatar / Perfil
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = user.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = user.email, color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = AzulLactaRede),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Editar Perfil")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Opções da Conta
        ContaOptionItem(icon = Icons.Default.Person, label = "Meus Dados")
        ContaOptionItem(icon = Icons.Default.WaterDrop, label = "Minhas Doações")
        ContaOptionItem(icon = Icons.Default.Notifications, label = "Notificações")

        Spacer(modifier = Modifier.weight(1f))

        // Botões de Ação
        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text("Sair")
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text("Excluir Conta")
        }
    }
}

@Composable
fun ContaOptionItem(icon: ImageVector, label: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = AzulLactaRede)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = label, fontWeight = FontWeight.Medium)
        }
    }
}