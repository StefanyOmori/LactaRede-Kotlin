package com.fiap.lactarede.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
private val AzulLactaRede = Color(0xFF55B1DF)

@Composable
fun DoarScreen(
    onBackClick: () -> Unit = {},
    onFinalizarClick: () -> Unit = {}
) {

    var etapaAtual by remember {
        mutableIntStateOf(1)
    }

    var nome by remember {
        mutableStateOf("")
    }

    var cpf by remember {
        mutableStateOf("")
    }

    var endereco by remember {
        mutableStateOf("")
    }

    var cep by remember {
        mutableStateOf("")
    }

    var telefone by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var usaMedicamento by remember {
        mutableStateOf(false)
    }

    var teveSintomas by remember {
        mutableStateOf(false)
    }

    var conviveDoente by remember {
        mutableStateOf(false)
    }

    var tipoColeta by remember {
        mutableStateOf("Entrega em ponto de coleta")
    }

    var diaSelecionado by remember {
        mutableStateOf("")
    }

    var horarioSelecionado by remember {
        mutableStateOf("")
    }

    var pontoSelecionado by remember {
        mutableStateOf("")
    }

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

//            IconButton(
//                onClick = {
//                    if (etapaAtual > 1) {
//                        etapaAtual--
//                    } else {
//                        onBackClick()
//                    }
//                },
//                modifier = Modifier.size(40.dp)
//            ) {
//
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Voltar",
//                    tint = Color.Black,
//                    modifier = Modifier.size(31.dp)
//                )
//            }

            Text(
                text = "Quero doar",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        StepIndicator(
            etapaAtual = etapaAtual
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {

            Spacer(modifier = Modifier.height(35.dp))

            when (etapaAtual) {

                1 -> {

                    Text(
                        text = "Pré-requisitos para doação",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(27.dp))

                    RequirementItem("Estar amamentando")
                    RequirementItem("Estar saudável")
                    RequirementItem("Não fazer uso de medicamentos\ncontraindicados")
                    RequirementItem("Não fumar ou ingerir álcool")
                    RequirementItem("Compromisso com higiene")

                    Spacer(modifier = Modifier.height(27.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(30.dp))
                            .border(
                                1.dp,
                                Color.Gray,
                                RoundedCornerShape(30.dp)
                            )
                            .background(Color(0xFFE9E9E9))
                            .padding(
                                horizontal = 20.dp,
                                vertical = 13.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(34.dp)
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Text(
                            text = "Em casos de dúvidas, fale com\nnossa equipe.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                }

                2 -> {

                    Text(
                        text = "Confirme seus dados",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Campo(
                        titulo = "Nome completo",
                        valor = nome,
                        placeholder = "Nome Completo",
                        onValueChange = {
                            nome = it
                        }
                    )

                    Campo(
                        titulo = "CPF",
                        valor = cpf,
                        placeholder = "xxx.xxx.xxx-xx",
                        onValueChange = {
                            cpf = it
                        }
                    )

                    Campo(
                        titulo = "Endereço",
                        valor = endereco,
                        placeholder = "Endereço",
                        onValueChange = {
                            endereco = it
                        }
                    )

                    Campo(
                        titulo = "CEP",
                        valor = cep,
                        placeholder = "xxxxx-xxx",
                        onValueChange = {
                            cep = it
                        }
                    )

                    Campo(
                        titulo = "Telefone",
                        valor = telefone,
                        placeholder = "(xx) xxxxx-xxxx",
                        onValueChange = {
                            telefone = it
                        }
                    )

                    Campo(
                        titulo = "E-mail",
                        valor = email,
                        placeholder = "E-mail",
                        onValueChange = {
                            email = it
                        }
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                }

                3 -> {

                    Text(
                        text = "Agora vamos avaliar sua\naptidão para doar",
                        fontSize = 24.sp,
                        lineHeight = 29.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    PerguntaTriagem(
                        pergunta = "Está usando algum medicamento\natualmente?",
                        selecionadoSim = usaMedicamento,
                        onSim = {
                            usaMedicamento = true
                        },
                        onNao = {
                            usaMedicamento = false
                        }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    PerguntaTriagem(
                        pergunta = "Teve febre ou sintomas gripais nos\núltimos 7 dias?",
                        selecionadoSim = teveSintomas,
                        onSim = {
                            teveSintomas = true
                        },
                        onNao = {
                            teveSintomas = false
                        }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    PerguntaTriagem(
                        pergunta = "Convive com alguém doente em casa?",
                        selecionadoSim = conviveDoente,
                        onSim = {
                            conviveDoente = true
                        },
                        onNao = {
                            conviveDoente = false
                        }
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Text(
                        text = "Últimos exames laboratoriais",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    UploadButton()

                    Spacer(modifier = Modifier.height(17.dp))

                    Text(
                        text = "Últimos exames sorológicos",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    UploadButton()

                    Spacer(modifier = Modifier.height(30.dp))
                }

                4 -> {

                    Text(
                        text = "Parabéns, você está apto para\ndoar!",
                        fontSize = 24.sp,
                        lineHeight = 29.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(42.dp))

                    Text(
                        text = "Realize o agendamento:",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(23.dp))

                    Text(
                        text = "Selecione o modo de coleta",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    RadioOption(
                        texto = "Coleta Domiciliar",
                        selecionado = tipoColeta == "Coleta Domiciliar",
                        onClick = {
                            tipoColeta = "Coleta Domiciliar"
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    RadioOption(
                        texto = "Entrega em ponto de coleta",
                        selecionado = tipoColeta == "Entrega em ponto de coleta",
                        onClick = {
                            tipoColeta = "Entrega em ponto de coleta"
                        }
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(
                        text = "Selecione um dia para a coleta",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    SelecaoCampo(
                        texto = if (diaSelecionado.isEmpty()) {
                            "dd/mm/aaaa"
                        } else {
                            diaSelecionado
                        },
                        onClick = {
                            diaSelecionado = "26/05/2025"
                        }
                    )

                    Spacer(modifier = Modifier.height(27.dp))

                    Text(
                        text = "Selecione um horário disponível",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    SelecaoCampo(
                        texto = if (horarioSelecionado.isEmpty()) {
                            "00:00"
                        } else {
                            horarioSelecionado
                        },
                        onClick = {
                            horarioSelecionado = "09:00"
                        }
                    )

                    Spacer(modifier = Modifier.height(27.dp))

                    Text(
                        text = "Selecione um ponto de coleta",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    SelecaoCampo(
                        texto = if (pontoSelecionado.isEmpty()) {
                            "Nome do Local"
                        } else {
                            pontoSelecionado
                        },
                        onClick = {
                            pontoSelecionado = "Banco de Leite Humano"
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(35.dp))
                }
            }
        }

        Button(
            onClick = {
                if (etapaAtual < 4) {
                    etapaAtual++
                } else {
                    onFinalizarClick()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 23.dp,
                    end = 23.dp,
                    bottom = 30.dp
                )
                .height(60.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulLactaRede
            )
        ) {

            Text(
                text = if (etapaAtual == 4) {
                    "Finalizar agendamento"
                } else {
                    "Próximo"
                },
                fontSize = if (etapaAtual == 4) 22.sp else 28.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}

@Composable
private fun StepIndicator(
    etapaAtual: Int
) {

    val nomes = listOf(
        "Pré-requisitos",
        "Dados",
        "Triagem",
        "Agendamento"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        verticalAlignment = Alignment.Top
    ) {

        for (i in 0..3) {

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(51.dp)
                            .clip(CircleShape)
                            .background(
                                if (etapaAtual == i + 1) {
                                    AzulLactaRede
                                } else {
                                    Color(0xFFD9D9D9)
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "${i + 1}",
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = nomes[i],
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
private fun RequirementItem(
    texto: String
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 11.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.CheckBox,
                contentDescription = null,
                tint = Color(0xFF222222),
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Text(
                text = texto,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFD0D0D0))
        )
    }
}

@Composable
private fun Campo(
    titulo: String,
    valor: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = titulo,
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(7.dp))

        OutlinedTextField(
            value = valor,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xFFAAAAAA),
                    fontSize = 16.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            singleLine = true,
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))
    }
}

@Composable
private fun PerguntaTriagem(
    pergunta: String,
    selecionadoSim: Boolean,
    onSim: () -> Unit,
    onNao: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = pergunta,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(13.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RadioOption(
                texto = "Sim",
                selecionado = selecionadoSim,
                onClick = onSim
            )

            RadioOption(
                texto = "Não",
                selecionado = !selecionadoSim,
                onClick = onNao
            )
        }
    }
}

@Composable
private fun RadioOption(
    texto: String,
    selecionado: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier.clickable {
            onClick()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = if (selecionado) {
                Icons.Default.RadioButtonChecked
            } else {
                Icons.Default.RadioButtonUnchecked
            },
            contentDescription = null,
            tint = Color(0xFF222222),
            modifier = Modifier.size(26.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = texto,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}

@Composable
private fun UploadButton() {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { }
            .padding(
                horizontal = 15.dp,
                vertical = 5.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.CloudUpload,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(22.dp)
        )

        Spacer(modifier = Modifier.width(7.dp))

        Text(
            text = "Upload",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
private fun SelecaoCampo(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .height(39.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Color(0xFF666666),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick()
            }
            .padding(horizontal = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = texto,
            fontSize = 18.sp,
            color = if (
                texto == "Nome do Local" ||
                texto == "00:00" ||
                texto == "dd/mm/aaaa"
            ) {
                Color(0xFFBBBBBB)
            } else {
                Color(0xFF444444)
            },
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.Default.ExpandMore,
            contentDescription = null,
            tint = Color(0xFFAAAAAA),
            modifier = Modifier.size(24.dp)
        )
    }
}