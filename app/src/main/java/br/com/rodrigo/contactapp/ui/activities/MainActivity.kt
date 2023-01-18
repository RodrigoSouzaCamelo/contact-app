package br.com.rodrigo.contactapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.contactapp.ui.navigation.AppNavHost
import br.com.rodrigo.contactapp.ui.theme.ContactAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactAppTheme {
                val navController = rememberNavController()

                AppNavHost(navController = navController)
            }
        }
    }
}