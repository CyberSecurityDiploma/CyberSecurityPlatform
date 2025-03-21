package hse.diploma.cybersecplatform.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import hse.diploma.cybersecplatform.R

fun isPhoneValid(phone: String): Boolean {
    val phoneRegex = "^((\\+7|8)[\\s-]?)?(\\(?\\d{3}\\)?[\\s-]?)?[\\d\\s-]{7}$"
    return phone.matches(phoneRegex.toRegex())
}

fun isEmailValid(email: String): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    return email.matches(emailRegex.toRegex())
}

fun isPasswordValid(password: String): Boolean {
    val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&.*]).{8,}$"
    return password.matches(passwordRegex.toRegex())
}

@Composable
fun getPasswordErrorMessage(password: String): String {
    return when {
        password.length < 8 -> stringResource(R.string.auth_password_error_length)
        !password.contains(Regex("[0-9]")) -> stringResource(R.string.auth_password_error_no_numbers)
        !password.contains(Regex("[a-z]")) -> stringResource(R.string.auth_password_error_no_lowercase_letters)
        !password.contains(Regex("[A-Z]")) -> stringResource(R.string.auth_password_error_no_uppercase_letters)
        else -> stringResource(R.string.auth_password_error_no_symbols)
    }
}
