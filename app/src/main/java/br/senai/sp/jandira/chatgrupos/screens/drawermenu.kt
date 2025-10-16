package br.senai.sp.jandira.chatgrupos.screens

import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.chatgrupos.ui.theme.DarkPrimaryPurple
import br.senai.sp.jandira.chatgrupos.ui.theme.white

@Composable
fun DrawerMenu(
    onOptionSelected: (String) -> Unit
) {
    ModalDrawerSheet(
        modifier = Modifier.width(280.dp),
        drawerContainerColor = DarkPrimaryPurple
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Journey Menu",
                color = white,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            DrawerItem("Criar grupo", Icons.Default.Add) { onOptionSelected("Criar grupo") }
            DrawerItem("Meus grupos", Icons.Default.AccountBox) { onOptionSelected("Meus grupos") }
            DrawerItem("Chat", Icons.Default.Call) { onOptionSelected("Chat") }
            DrawerItem("Configurações", Icons.Default.Settings) { onOptionSelected("Configurações") }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Versão 1.0",
                color = Color.LightGray,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun DrawerItem(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = white,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, color = white, fontSize = 16.sp)
    }
}
