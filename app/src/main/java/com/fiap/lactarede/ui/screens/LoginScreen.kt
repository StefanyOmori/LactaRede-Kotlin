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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.lactarede.repository.MockData

private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun LoginScreen(
    onCadastrarClick: () -> Unit,
    onLoginClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var erroLogin by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 17.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(90.dp))

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
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(102.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Entrar",
                    fontSize = 24.sp,
                    color = AzulLactaRede
                )

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(
                    thickness = 2.dp,
                    color = AzulLactaRede
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextButton(
                    onClick = onCadastrarClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Cadastrar",
                        fontSize = 24.sp,
                        color = Color(0xFF5F5F5F)
                    )
                }

                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFF777777)
                )
            }
        }

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "E-mail",
                fontSize = 21.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "E-mail",
                        color = Color(0xFFAAAAAA),
                        fontSize = 16.sp
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(13.dp),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = AzulLactaRede
                )
            )
        }

        Spacer(modifier = Modifier.height(13.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Senha",
                fontSize = 21.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Insira a senha",
                        color = Color(0xFFAAAAAA),
                        fontSize = 16.sp
                    )
                },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(13.dp),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = AzulLactaRede
                )
            )
        }

        TextButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 0.dp)
        ) {
            Text(
                text = "Esqueci minha senha",
                fontSize = 16.sp,
                color = Color(0xFF007AFF)
            )
        }

        erroLogin?.let { mensagem ->
            Text(
                text = mensagem,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                erroLogin = null
                when {
                    email.isBlank() || senha.isBlank() -> {
                        erroLogin = "Preencha e-mail e senha."
                    }
                    email == MockData.currentUser.email && senha == MockData.mockPassword -> {
                        onLoginClick()
                    }
                    else -> {
                        erroLogin = "E-mail ou senha inválidos."
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp),
            shape = RoundedCornerShape(11.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulLactaRede
            )
        ) {
            Text(
                text = "Entrar",
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(60.dp))
    }
}

@Composable
private fun SocialButton(
    backgroundColor: Color,
    text: String,
    textColor: Color
) {

    Box(
        modifier = Modifier
            .width(45.dp)
            .height(45.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            fontSize = 29.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}
