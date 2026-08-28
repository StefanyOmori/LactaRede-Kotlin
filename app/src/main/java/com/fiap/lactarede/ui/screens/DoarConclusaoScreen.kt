package com.fiap.lactarede.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun DoarConclusaoScreen(
    onBackClick: () -> Unit = {},
    onVerAgendamentoClick: () -> Unit,
    onVoltarInicioClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título centralizado
        Text(
            text = "Agendamento\nrealizado",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            lineHeight = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mensagem de agradecimento
        Text(
            text = "O LactaRede agradece sua contribuição. Continue sendo parte dessa corrente do bem!",
            fontSize = 13.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botão "Ver Agendamento"
        Button(
            onClick = onVerAgendamentoClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AzulLactaRede)
        ) {
            Text(
                text = "Ver Agendamento",
                fontSize = 15.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botão "Voltar para a tela inicial"
        Button(
            onClick = onVoltarInicioClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AzulLactaRede)
        ) {
            Text(
                text = "Voltar para a tela inicial",
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }
}