package com.example.ui_counter.bignumber

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
//import com.example.base_ui.components.AutoResizeText
//import com.example.base_ui.components.FontSizeRange

@Composable
fun BigNumberScreen() {

    val viewModel = hiltViewModel<BigNumberViewModel>()
    val state by viewModel.state.collectAsState()

    BigNumberScreen(
        state
    )


}

@Composable
private fun BigNumberScreen(
    state: BigNumberState
) {
   Column(
       modifier = Modifier
           .padding(8.dp)
           .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
//        AutoResizeText(
//            text = state.number,
//            fontSizeRange = FontSizeRange(1.sp, 1000.sp, 15.sp),
//            modifier = Modifier.padding(8.dp).fillMaxWidth(),
//            textAlign = TextAlign.Center,
//            maxLines = 1
//        )
       Text(
           text = state.number
       )

   }
}


