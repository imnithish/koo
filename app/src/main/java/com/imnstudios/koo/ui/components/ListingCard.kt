package com.imnstudios.koo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter


// profile pic, name, email , phone

@Composable
fun ListingCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    name: String,
    email: String,
    phone: String
) {

    Card(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier.size(64.dp),
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = ""
            )
            Column(modifier = modifier.padding(start = 4.dp)) {
                Text(text = name)
                Text(text = email)
                Text(text = phone)
            }
        }
    }

}