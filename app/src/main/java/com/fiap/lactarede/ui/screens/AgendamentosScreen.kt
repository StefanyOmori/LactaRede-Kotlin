package com.fiap.lactarede.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.data.AgendamentoData
import com.fiap.lactarede.model.Agendamento

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun AgendamentosScreens(
    onBackClick: () -> Unit = {},
    onDetailsClick: (Agendamento) -> Unit = {},
    onCancelClick: (Agendamento) -> Unit = {}
) {

    val agendamentos = AgendamentoData.agendamentos

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    top = 25.dp,
                    end = 20.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBackClick,
                modifier = Modifier.size(40.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.Black,
                    modifier = Modifier.size(31.dp)
                )
            }

            Text(
                text = "Meus agendamentos",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFBDBDBD)
                )
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TabItem(
                texto = "Próximos",
                selecionado = true,
                modifier = Modifier.weight(1f)
            )

            TabItem(
                texto = "Anteriores",
                selecionado = false,
                modifier = Modifier.weight(1f)
            )

            TabItem(
                texto = "Cancelados",
                selecionado = false,
                modifier = Modifier.weight(1f)
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),

            contentPadding = PaddingValues(
                start = 27.dp,
                end = 27.dp,
                top = 32.dp,
                bottom = 30.dp
            ),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(agendamentos) { agendamento ->

                AgendamentoCard(
                    agendamento = agendamento,
                    onDetailsClick = {
                        onDetailsClick(agendamento)
                    },
                    onCancelClick = {
                        onCancelClick(agendamento)
                    }
                )
            }
        }
    }
}

@Composable
private fun TabItem(
    texto: String,
    selecionado: Boolean,
    modifier: Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = texto,
            fontSize = 15.sp,
            color = if (selecionado) {
                AzulLactaRede
            } else {
                Color(0xFF555555)
            },
            fontWeight = if (selecionado) {
                FontWeight.Normal
            } else {
                FontWeight.Normal
            }
        )

        if (selecionado) {

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(AzulLactaRede)
            )
        }
    }
}

@Composable
private fun AgendamentoCard(
    agendamento: Agendamento,
    onDetailsClick: () -> Unit,
    onCancelClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color(0xFFD0D0D0),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 16.dp,
                    bottom = 15.dp
                )
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = agendamento.local,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        lineHeight = 21.sp
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = agendamento.instituicao,
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(agendamento.corStatus)
                        .padding(
                            horizontal = 14.dp,
                            vertical = 4.dp
                        )
                ) {

                    Text(
                        text = agendamento.status,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (agendamento.status == "Confirmado") {
                            Color(0xFF159447)
                        } else {
                            Color(0xFFE99A00)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(9.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFBDBDBD))
            )

            Spacer(modifier = Modifier.height(23.dp))

            InfoRow(
                icon = Icons.Default.CalendarToday,
                text = agendamento.data
            )

            Spacer(modifier = Modifier.height(13.dp))

            InfoRow(
                icon = Icons.Default.Schedule,
                text = "${agendamento.horario} - ${agendamento.tipo}"
            )

            Spacer(modifier = Modifier.height(13.dp))

            InfoRow(
                icon = Icons.Default.LocationOn,
                text = "${agendamento.endereco} · ${agendamento.distancia}"
            )

            Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                TextButton(
                    onClick = onDetailsClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(AzulLactaRede),
                    contentPadding = PaddingValues(0.dp)
                ) {

                    Text(
                        text = "Ver detalhes",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = onCancelClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFFF4D4D),
                            shape = RoundedCornerShape(5.dp)
                        ),
                    contentPadding = PaddingValues(0.dp)
                ) {

                    Text(
                        text = "Cancelar",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFD90000)
                    )
                }
            }
        }
    }
}

@Composable
private fun InfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = AzulLactaRede,
            modifier = Modifier.size(21.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(0xFF666666)
        )
    }
}