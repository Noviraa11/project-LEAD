package com.dicoding.lead

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.lead.ChangePasswordScreen
import com.dicoding.lead.MentoringScreen
import com.dicoding.lead.ParticipantEvaluationScreen
import com.dicoding.lead.AnnouncementScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavigation(navController)
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "changePassword") {
        composable("changePassword") { ChangePasswordScreen() }
        composable("mentoring") { MentoringScreen() }
        composable("evaluation") { ParticipantEvaluationScreen() }
        composable("announcement") { AnnouncementScreen() }
    }
}
