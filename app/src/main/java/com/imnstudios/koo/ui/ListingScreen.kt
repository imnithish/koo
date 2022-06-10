package com.imnstudios.koo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.imnstudios.koo.ui.components.ListingCard
import com.imnstudios.koo.util.OnBottomReached

@Composable
fun ListingScreen(viewModel: ListingViewModel) {
    val state = rememberLazyListState()


    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            state = state,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {


            viewModel.uiSate.value.result.forEach {

                item(key = it.id.value) {
                    ListingCard(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        imageUrl = it.picture.thumbnail,
                        name = it.name.first,
                        email = it.email,
                        phone = it.phone
                    )
                }

            }
        }

        state.OnBottomReached { viewModel.attemptAPICall() }

        if (viewModel.uiSate.value.loading)
            LinearProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter))
    }


}