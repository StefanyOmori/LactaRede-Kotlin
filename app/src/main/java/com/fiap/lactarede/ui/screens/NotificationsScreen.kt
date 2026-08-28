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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.data.NotificationData
import com.fiap.lactarede.model.Notification

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit = {}
) {

    val notificacoes = NotificationData.notificacoes

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
                text = "Notificações",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = "Notificações",
                tint = AzulLactaRede,
                modifier = Modifier.size(31.dp)
            )
        }

        Spacer(modifier = Modifier.height(70.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),

            contentPadding = PaddingValues(
                start = 34.dp,
                end = 34.dp,
                bottom = 30.dp
            ),

            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {

            items(notificacoes) { notificacao ->

                NotificationCard(
                    notification = notificacao
                )
            }
        }
    }
}

@Composable
private fun NotificationCard(
    notification: Notification
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(10.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 15.dp,
                    vertical = 11.dp
                ),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = notification.icone,
                contentDescription = null,
                tint = notification.corIcone,
                modifier = Modifier.size(38.dp)
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = notification.titulo,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = notification.descricao,
                    fontSize = 12.sp,
                    lineHeight = 15.sp,
                    color = Color(0xFF222222),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                if (notification.detalhe.isNotEmpty()) {

                    Text(
                        text = notification.detalhe,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00529B)
                    )
                }
            }

            if (notification.tempo.isNotEmpty()) {

                Spacer(modifier = Modifier.width(5.dp))

                Column(
                    horizontalAlignment = Alignment.End
                ) {

                    Text(
                        text = notification.tempo,
                        fontSize = 11.sp,
                        color = Color(0xFF777777)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    if (!notification.lida) {

                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .background(
                                    AzulLactaRede,
                                    RoundedCornerShape(50)
                                )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun NotificationScreenPreview() {
    NotificationScreen {  }
}