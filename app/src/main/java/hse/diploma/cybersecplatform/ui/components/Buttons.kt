package hse.diploma.cybersecplatform.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hse.diploma.cybersecplatform.R
import hse.diploma.cybersecplatform.ui.theme.Montserrat

@Composable
fun FilledButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(52.dp),
        enabled = enabled,
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_large)),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.button_enabled),
            contentColor = Color.White,
            disabledContainerColor = colorResource(R.color.button_disabled),
            disabledContentColor = Color.White
        ),
    ) {
        Text(
            text = text,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun CustomOutlinedButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.fillMaxWidth().height(52.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
            disabledContentColor = colorResource(R.color.text_disabled)
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled) {
                colorResource(R.color.button_enabled)
            } else {
                colorResource(R.color.button_disabled)
            }
        ),
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_large))
    ) {
        Text(
            text = text,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Заполненная кнопка (Enabled)
        FilledButton(
            text = "Filled Button",
            onClick = { /* Обработка нажатия */ },
            enabled = true
        )

        // Заполненная кнопка (Disabled)
        FilledButton(
            text = "Filled Button (Disabled)",
            onClick = { /* Обработка нажатия */ },
            enabled = false
        )

        // Кнопка с границей (Enabled)
        CustomOutlinedButton(
            text = "Outlined Button",
            onClick = { /* Обработка нажатия */ },
            enabled = true
        )

        // Кнопка с границей (Disabled)
        CustomOutlinedButton(
            text = "Outlined Button (Disabled)",
            onClick = { /* Обработка нажатия */ },
            enabled = false
        )
    }
}
