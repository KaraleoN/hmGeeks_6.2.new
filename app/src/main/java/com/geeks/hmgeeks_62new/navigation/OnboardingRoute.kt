package com.geeks.hmgeeks_62new.navigation

sealed class OnboardingRoute(val route: String) {
    object Welcome : OnboardingRoute("welcomeScreen")
    object Registration : OnboardingRoute("registrationScreen")
    object Confirmation : OnboardingRoute("confirmationScreen/{username}") {
        fun createRoute(username: String) = "confirmationScreen/$username"
    }
}