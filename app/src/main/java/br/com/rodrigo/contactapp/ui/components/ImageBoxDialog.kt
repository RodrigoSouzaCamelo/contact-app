package br.com.rodrigo.contactapp.ui.components

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.extensions.convertToString
import br.com.rodrigo.contactapp.ui.theme.ContactAppTheme
import br.com.rodrigo.contactapp.util.FORMAT_DATE_DAY_MONTH_YEAR
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
fun boxDialogDate(
    context: Context,
    currentDate: Date?,
    onClickDismiss: () -> Unit = {},
    onClickSelectedDate: (selectedDate: String) -> Unit = {}
) {
    val dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE_DAY_MONTH_YEAR)
    val localDate = if (currentDate == null) LocalDate.now()
    else LocalDate.parse(currentDate.convertToString(), dateTimeFormatter)

    val currentYear = localDate.year
    val currentMonth = localDate.monthValue
    val currentDay = localDate.dayOfMonth

    val datePickerDialog = DatePickerDialog(
        context, { _: DatePicker, year, month, day ->
            val selectedDate = LocalDate.parse("$day/${month + 1}/$year", dateTimeFormatter)
            onClickSelectedDate(selectedDate.format(dateTimeFormatter))
        }, currentYear, (currentMonth - 1), currentDay
    )

    datePickerDialog.setOnDismissListener {
        onClickDismiss()
    }
    datePickerDialog.show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageBoxDialog(
    profilePicture: String,
    modifier: Modifier = Modifier,
    onChangeProfilePicture: (String) -> Unit = {},
    onClickDismiss: () -> Unit = {},
    onClickSave: (urlPicture: String) -> Unit = {}
) {
    Dialog(
        onDismissRequest = onClickDismiss,
        content = {
            Column(
                modifier
                    .clip(RoundedCornerShape(5))
                    .heightIn(250.dp, 400.dp)
                    .widthIn(200.dp)
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImageProfile(
                    urlPicture = profilePicture,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(5, 5))
                )

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .heightIn(max = 80.dp),
                    value = profilePicture,
                    onValueChange = onChangeProfilePicture,
                    label = { Text(stringResource(id = R.string.url_picture)) })

                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onClickDismiss) {
                        Text(text = stringResource(R.string.cancel))
                    }
                    TextButton(onClick = { onClickSave(profilePicture) }) {
                        Text(text = stringResource(R.string.save))
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun CaixaDialogoImagemPreview() {
    ContactAppTheme {
        ImageBoxDialog("")
    }
}