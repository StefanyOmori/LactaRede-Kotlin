package com.fiap.lactarede.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun CadastroScreen(
    onLoginClick: () -> Unit = {},
    onCadastroClick: () -> Unit = {}
) {

    var nome by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(86.dp))

        Text(
            text = "Bem-vindo!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Faça login ou cadastre-se\npara continuar",
            fontSize = 21.sp,
            color = Color(0xFF5F5F5F),
            lineHeight = 25.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {

            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextButton(
                    onClick = onLoginClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Entrar",
                        fontSize = 24.sp,
                        color = Color(0xFF5F5F5F)
                    )
                }

                androidx.compose.material3.HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFF777777)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Cadastrar",
                    fontSize = 24.sp,
                    color = AzulLactaRede
                )

                Spacer(modifier = Modifier.height(12.dp))

                androidx.compose.material3.HorizontalDivider(
                    thickness = 2.dp,
                    color = AzulLactaRede
                )
            }
        }

        Spacer(modifier = Modifier.height(70.dp))

        InputField(
            label = "Nome completo",
            placeholder = "Nome Completo",
            value = nome,
            onValueChange = { nome = it }
        )

        Spacer(modifier = Modifier.height(13.dp))

        InputField(
            label = "CPF",
            placeholder = "xxx.xxx.xxx-xx",
            value = cpf,
            onValueChange = { cpf = it }
        )

        Spacer(modifier = Modifier.height(13.dp))

        InputField(
            label = "Endereço",
            placeholder = "Endereço",
            value = endereco,
            onValueChange = { endereco = it }
        )

        Spacer(modifier = Modifier.height(13.dp))

        InputField(
            label = "CEP",
            placeholder = "xxxxx-xxx",
            value = cep,
            onValueChange = { cep = it }
        )

        Spacer(modifier = Modifier.height(13.dp))

        InputField(
            label = "Telefone",
            placeholder = "(xx) xxxxx-xxxx",
            value = telefone,
            onValueChange = { telefone = it }
        )

        Spacer(modifier = Modifier.height(13.dp))

        InputField(
            label = "E-mail",
            placeholder = "E-mail",
            value = email,
            onValueChange = { email = it }
        )

        Spacer(modifier = Modifier.height(13.dp))

        InputField(
            label = "Senha",
            placeholder = "Insira a senha",
            value = senha,
            onValueChange = { senha = it }
        )

        Spacer(modifier = Modifier.height(92.dp))

        Button(
            onClick = onCadastroClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp),
            shape = RoundedCornerShape(11.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulLactaRede
            )
        ) {
            Text(
                text = "Cadastrar",
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(92.dp))
    }
}

@Composable
private fun InputField(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = label,
            fontSize = 21.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(39.dp),
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 16.sp,
                    color = Color(0xFFAAAAAA)
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(13.dp)
        )
    }
}


@Preview
@Composable
private fun CadastroScreenPreview() {
    CadastroScreen {  }
}