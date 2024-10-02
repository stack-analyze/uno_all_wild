package com.stackanlyze.unoallwild.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stackanlyze.unoallwild.R.drawable.logo
import com.stackanlyze.unoallwild.R.drawable.ic_github

@Composable
fun AboutView() {
    val localUriHandler = LocalUriHandler.current
    val modifier = Modifier

    val openUrl: (uri: String) -> Unit = { localUriHandler.openUri(it) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedCard {
            Column(
                modifier = modifier
                    .padding(16.dp)
                    .size(250.dp, 350.dp)
            ) {
                Image(painter = painterResource(id = logo), contentDescription = "about img")

                Text(
                    text = "Uno all wild",
                    maxLines = 2,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 25.sp
                )

                Spacer(modifier.height(5.dp))

                Text(
                    text = "Creado por omega5300",
                    maxLines = 2,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 15.sp
                )

                Spacer(modifier.height(5.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxSize()
                ) {
                    TextButton(onClick = { openUrl("https://github.com/stack-analyze/uno_all_wild") }) {
                        Icon(
                            painter = painterResource(id = ic_github),
                            contentDescription = "github icon",
                            modifier = modifier.size(24.dp)
                        )
                        Spacer(modifier = modifier.width(5.dp))
                        Text(text = "repo")
                    }

                    TextButton(onClick = { openUrl("https://stackshare.io/stack-analyze/uno-all-wild") }) {
                        Icon(
                            Icons.Outlined.Share,
                            contentDescription = "stack icon",
                            modifier = modifier.size(24.dp)
                        )
                        Spacer(modifier = modifier.width(5.dp))
                        Text(text = "tech stack")
                    }
                }
            }
        }
    }
}