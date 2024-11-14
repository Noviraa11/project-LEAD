package com.dicoding.lead

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults



@Composable
fun ChangePasswordScreen() {
    // States for each input field
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // States for visibility toggles
    var currentPasswordVisible by remember { mutableStateOf(false) }
    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    // State for error message visibility
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pengaturan", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Ubah Kata Sandi", fontSize = 16.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        // Current Password
        PasswordInputField(
            label = "Kata Sandi Saat Ini",
            password = currentPassword,
            onPasswordChange = { currentPassword = it },
            passwordVisible = currentPasswordVisible,
            onVisibilityChange = { currentPasswordVisible = !currentPasswordVisible },
            isError = showError
        )

        Spacer(modifier = Modifier.height(8.dp))

        // New Password
        PasswordInputField(
            label = "Kata Sandi Baru",
            password = newPassword,
            onPasswordChange = { newPassword = it },
            passwordVisible = newPasswordVisible,
            onVisibilityChange = { newPasswordVisible = !newPasswordVisible },
            isError = showError
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Confirm Password
        PasswordInputField(
            label = "Konfirmasi Kata Sandi Baru",
            password = confirmPassword,
            onPasswordChange = { confirmPassword = it },
            passwordVisible = confirmPasswordVisible,
            onVisibilityChange = { confirmPasswordVisible = !confirmPasswordVisible },
            isError = showError
        )

        // Error message for password rules
        if (showError) {
            Text(
                text = "Anda hanya dapat mengganti password setiap 2 minggu sekali.",
                color = Color.Red,
                fontSize = 12.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Change Password Button
        Button(
            onClick = {
                // Here you can add validation logic
                showError = true // This will show the error message
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ubah Password")
        }
    }
}

@Composable
fun PasswordInputField(
    label: String,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onVisibilityChange: () -> Unit,
    isError: Boolean = false
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(text = label) },
        singleLine = true,
        isError = isError,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            IconButton(onClick = onVisibilityChange) {
                Icon(imageVector = image, contentDescription = null)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = if (isError) Color.Red else MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = if (isError) Color.Red else Color.Gray,
            textColor = Color.Black
        )
    )
}
