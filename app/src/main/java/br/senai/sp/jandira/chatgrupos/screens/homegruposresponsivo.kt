package br.senai.sp.jandira.chatgrupos.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun HomeGruposResponsive(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit = {}
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    BoxWithConstraints {
        if (maxWidth > 600.dp) {
            PermanentNavigationDrawer(
                drawerContent = {
                    DrawerMenu(
                        onOptionSelected = { },
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = onThemeToggle
                    )
                }
            ) {
                Homegrupos()
            }
        } else {
            ModalNavigationDrawer(
                drawerContent = {
                    DrawerMenu(
                        onOptionSelected = {  },
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = onThemeToggle
                    )
                },
                drawerState = drawerState
            ) {
                Homegrupos()
            }
        }
    }
}
