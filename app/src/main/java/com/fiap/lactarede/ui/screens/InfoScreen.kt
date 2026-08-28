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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.repository.MockData

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun InfoScreen(onBackClick: () -> Unit = {}) {
    var searchQuery by remember { mutableStateOf("") }
    val topics = MockData.infoTopics

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(16.dp)
    ) {
        // Barra de busca
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Buscar conteúdo...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFEEEEEE),
                    focusedContainerColor = Color(0xFFEEEEEE),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { }) {
                Icon(Icons.Default.Tune, contentDescription = "Filtro", tint = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de Cards de Informação
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(topics) { topic ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Ícone com fundo colorido
                        val (bgColor, iconVector) = getTopicStyle(topic.iconName)
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .background(bgColor, RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = iconVector,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        // Textos do card
                        Column {
                            Text(
                                text = topic.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = topic.description,
                                fontSize = 12.sp,
                                color = AzulLactaRede
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun getTopicStyle(iconName: String): Pair<Color, ImageVector> {
    return when (iconName) {
        "heart" -> Pair(Color(0xFFFFCDD2), Icons.Default.Favorite)
        "sun" -> Pair(Color(0xFFFFF9C4), Icons.Default.WbSunny)
        "truck" -> Pair(Color(0xFFC5CAE9), Icons.Default.LocalShipping)
        "check" -> Pair(Color(0xFFC8E6C9), Icons.Default.Verified)
        "chat" -> Pair(Color(0xFFFFCCBC), Icons.Default.ChatBubble)
        "clipboard" -> Pair(Color(0xFFE1BEE7), Icons.Default.Assignment)
        else -> Pair(Color.LightGray, Icons.Default.Info)
    }
}