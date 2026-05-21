package de.bonimporter.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import de.bonimporter.app.ui.BonImporterNavGraph
import de.bonimporter.app.ui.theme.BonImporterTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BonImporterTheme {
                BonImporterNavGraph()
            }
        }
    }
}
