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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.repository.MockData

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun PontosColetaScreen(
    onBackClick: () -> Unit = {}
) {
    val points = MockData.collectionPoints

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
    ) {
        // Área Mockada do Mapa (Simulação do Mapa com Pins)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFE0F2F1)), // Fundo verde claro simulando mapa
            contentAlignment = Alignment.Center
        ) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = AzulLactaRede, modifier = Modifier.size(36.dp))
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = AzulLactaRede, modifier = Modifier.size(36.dp))
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = AzulLactaRede, modifier = Modifier.size(36.dp))
            }
            Text("Mapa Simulado", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.align(Alignment.BottomStart).padding(8.dp))
        }

        // Lista e Botão "Ver no mapa"
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(points) { point ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = AzulLactaRede,
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = point.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = point.subtitle,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 12.sp,
                                    color = Color.DarkGray
                                )
                                Text(
                                    text = point.address,
                                    fontSize = 11.sp,
                                    color = Color.Gray
                                )
                                Text(
                                    text = point.distance,
                                    fontSize = 11.sp,
                                    color = Color.Gray
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Ver detalhes",
                                tint = Color.Gray
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botão Principal "Ver no mapa"
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AzulLactaRede)
            ) {
                Text(text = "Ver no mapa", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}