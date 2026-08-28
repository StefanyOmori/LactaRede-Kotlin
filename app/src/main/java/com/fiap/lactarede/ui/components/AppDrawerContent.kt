package com.fiap.lactarede.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val AzulLactaRede = Color(0xFF55B1DF)

data class MenuItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun AppDrawerContent(
    userName: String,
    userEmail: String,
    menuItems: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulLactaRede)
                .padding(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(userName, color = Color.White, fontWeight = FontWeight.Bold)
            Text(userEmail, color = Color.White.copy(alpha = 0.85f))
        }

        Spacer(modifier = Modifier.height(8.dp))

        menuItems.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = false,
                onClick = { onItemClick(item) },
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
    }
}