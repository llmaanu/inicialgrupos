package br.senai.sp.jandira.chatgrupos.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.chatgrupos.ui.theme.DarkPrimaryPurple
import br.senai.sp.jandira.chatgrupos.ui.theme.roxoclarinho
import br.senai.sp.jandira.chatgrupos.ui.theme.topo
import br.senai.sp.jandira.chatgrupos.ui.theme.white
import br.senai.sp.jandira.chatgrupos.ui.theme.LightAccent
import kotlinx.coroutines.launch
import br.senai.sp.jandira.chatgrupos.screens.

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homegrupos() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenu(onItemSelected = {
                // aqui você pode tratar cliques no menu
                scope.launch { drawerState.close() }
            })
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = br.senai.sp.inicialgrupos.R.drawable.jclaro),
                                contentDescription = "Logo Journey",
                                modifier = Modifier.size(62.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Journey", color = white)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = white
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* ação do tema */ }) {
                            Image(
                                painter = painterResource(id = br.senai.sp.inicialgrupos.R.drawable.temaescuro),
                                contentDescription = "Tema",
                                modifier = Modifier.size(44.dp)
                            )
                        }
                        IconButton(onClick = { /* ação perfil */ }) {
                            Image(
                                painter = painterResource(id = br.senai.sp.inicialgrupos.R.drawable.perfil),
                                contentDescription = "Perfil",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = topo)
                )
            }
        ) { padding ->

            // Responsividade: usa dimensões flexíveis
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(roxoclarinho)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = topo,
                            modifier = Modifier
                                .size(28.dp)
                                .clickable { }
                        )

                        Spacer(Modifier.height(16.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .sizeIn(minWidth = 80.dp, maxWidth = 120.dp)
                                    .aspectRatio(1f)
                                    .background(Color.Black)
                            )
                            Spacer(Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Direito",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 26.sp,
                                    color = Color.Black
                                )
                                Text(
                                    text = "15 membros",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                        }

                        Spacer(Modifier.height(20.dp))

                        Text(
                            text = "Área:",
                            color = DarkPrimaryPurple,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 40.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(LightAccent),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(4f)
                                    .padding(start = 12.dp),
                                text = "Direito",
                                fontWeight = FontWeight.Medium,
                                color = DarkPrimaryPurple
                            )
                        }

                        Spacer(Modifier.height(16.dp))

                        Text(
                            text = "Descrição:",
                            color = DarkPrimaryPurple,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 100.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(LightAccent),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(4f)
                                    .padding(12.dp),
                                text = "Grupo de mentoria jurídica voltado ao crescimento profissional, troca de experiências e desenvolvimento prático no mundo do Direito.",
                                fontWeight = FontWeight.Medium,
                                color = DarkPrimaryPurple
                            )
                        }

                        Spacer(Modifier.height(24.dp))

                        var selectedTab by remember { mutableStateOf("chat") }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(DarkPrimaryPurple)
                                .padding(2.dp)
                        ) {
                            Button(
                                onClick = { selectedTab = "chat" },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (selectedTab == "chat") Color(0xFF351D9B) else Color(0xFF7B5DF4)
                                ),
                                shape = RoundedCornerShape(
                                    topStart = 12.dp,
                                    bottomStart = 12.dp
                                )
                            ) {
                                Text("Chat", color = roxoclarinho)
                            }

                            Button(
                                onClick = { selectedTab = "calendario" },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (selectedTab == "calendario") Color(0xFF351D9B) else Color(0xFF7B5DF4)
                                ),
                                shape = RoundedCornerShape(
                                    topEnd = 12.dp,
                                    bottomEnd = 12.dp
                                )
                            ) {
                                Text("Calendário", color = roxoclarinho)
                            }
                        }

                        Spacer(Modifier.height(28.dp))

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(containerColor = DarkPrimaryPurple),
                                modifier = Modifier
                                    .widthIn(min = 180.dp, max = 260.dp)
                                    .height(50.dp),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = "Participar",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Previewhomegrupos() {
    Homegrupos()
}
