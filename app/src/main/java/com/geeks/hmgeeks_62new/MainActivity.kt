package com.geeks.hmgeeks_62new

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.geeks.hmgeeks_62new.navigation.OnboardingRoute
import com.geeks.hmgeeks_62new.ui.screens.ConfirmationScreen
import com.geeks.hmgeeks_62new.ui.screens.RegistrationScreen
import com.geeks.hmgeeks_62new.ui.screens.WelcomeScreen
import com.geeks.hmgeeks_62new.ui.theme.HmGeeks_62newTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HmGeeks_62newTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = OnboardingRoute.Welcome.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(OnboardingRoute.Welcome.route) {
                            WelcomeScreen(onNext = {
                                navController.navigate(OnboardingRoute.Registration.route)
                            })
                        }
                        composable(OnboardingRoute.Registration.route) {
                            RegistrationScreen(onRegister = { username ->
                                navController.navigate(OnboardingRoute.Confirmation.createRoute(username))
                            })
                        }
                        composable(
                            OnboardingRoute.Confirmation.route,
                            arguments = listOf(navArgument("username") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val username = backStackEntry.arguments?.getString("username")
                            ConfirmationScreen(username = username)
                        }
                    }
                }
            }
        }
    }
}