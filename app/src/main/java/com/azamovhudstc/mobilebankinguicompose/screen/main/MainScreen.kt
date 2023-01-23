package com.azamovhudstc.mobilebankinguicompose.screen.main

import cafe.adriel.voyager.androidx.AndroidScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.hilt.getScreenModel
import com.azamovhudstc.mobilebankinguicompose.R
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.common.CardData
import com.azamovhudstc.mobilebankinguicompose.ui.theme.MobileBankingUiComposeTheme
import com.azamovhudstc.mobilebankinguicompose.utils.dialogs.MyDialog
import com.azamovhudstc.mobilebankinguicompose.utils.dialogs.MyDialogFont

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<MainScreenModelImpl>()
        val uiState = viewModel.uiState.collectAsState().value

        MobileBankingUiComposeTheme() {

            MainContent(uiState, viewModel::onEventDispatcher)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    uiState: MainContract.UiState,
    eventDispatcher: (MainContract.Intent) -> Unit
) {


    val showDialog = remember { mutableStateOf(false) }
    val showDialogFont = remember { mutableStateOf(false) }

    if (showDialog.value)
        MyDialog(setShowDialog = {
            showDialog.value = it
        })
    if (showDialogFont.value)
        MyDialogFont(setShowDialog = {
            showDialogFont.value = it
        })

    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                Text(
                    text = "My Accounts", style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.weight(1f, true))
                androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.ic_night),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.clickable {
//
                        showDialog.value = true
                    }
                )
                Spacer(modifier = Modifier.width(18.dp))
                androidx.compose.material3.Icon(
                    tint = MaterialTheme.colorScheme.onBackground,
                    painter = painterResource(id = R.drawable.ic_baseline_title_24),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        showDialogFont.value = true
                    })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp, top = 16.dp)
            ) {
                androidx.compose.material3.Text(
                    text = "Total balance",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.weight(1f))
                androidx.compose.material3.Text(
                    text = "${uiState.totalBalance} so‘m",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {

                LazyRow(content = {
                    items(uiState.cards.size) {
                        PayCard(uiState.cards[it])
                    }
                })


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp)
            ) {

                Column(
                    modifier = Modifier.weight(1f, true),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MenuItem(

                        title = "Add Cart",
                        icon = com.azamovhudstc.mobilebankinguicompose.R.drawable.ic_wallet
                    )
                }

                Column(
                    modifier = Modifier.weight(1f, true),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MenuItem(
                        title = "Pay",
                        icon = com.azamovhudstc.mobilebankinguicompose.R.drawable.pay
                    )
                }

                Column(
                    modifier = Modifier.weight(1f, true),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MenuItem(
                        title = "Send",
                        icon = com.azamovhudstc.mobilebankinguicompose.R.drawable.send
                    )
                }

                Column(
                    modifier = Modifier.weight(1f, true),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MenuItem(
                        title = "More",
                        icon = com.azamovhudstc.mobilebankinguicompose.R.drawable.more
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth()

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    androidx.compose.material3.Card(
                        modifier = Modifier.fillMaxSize(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(
                            topEnd = 32.dp,
                            topStart = 32.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            androidx.compose.material3.Divider(
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .width(50.dp)
                                    .height(5.dp)
                                    .background(
                                        shape = RoundedCornerShape(20.dp),
                                        color = Color.Gray
                                    )
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 32.dp)
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)


                        ) {
                            androidx.compose.material3.Text(
                                text = "Recent Transactions",
                                style = MaterialTheme.typography.titleMedium,
                            )
                            Spacer(modifier = Modifier.weight(1f, true))
                            androidx.compose.material3.Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = null
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(top = 24.dp)
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(40.dp)
                                )
                                androidx.compose.material3.Text(
                                    text = "Netflix",
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(start = 16.dp),
                                )
                                Spacer(modifier = Modifier.weight(1f, true))
                                androidx.compose.material3.Text(
                                    text = "-10$", style = MaterialTheme.typography.titleMedium,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun MenuItem(title: String, icon: Int) {
    Card(
        shape = RoundedCornerShape(50),
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 8.dp
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.padding(20.dp),
            tint = MaterialTheme.colorScheme.onBackground,
        )

    }
    Text(
        text = title,
        color = MaterialTheme.colorScheme.onBackground,

        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayCard(data: CardData) {
    androidx.compose.material3.Card(
        modifier = Modifier
            .padding(start = 16.dp)
            .height(168.dp)
            .width(312.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF87B38))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = com.azamovhudstc.mobilebankinguicompose.R.drawable.card),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp)
                        .height(28.dp)
                        .width(42.dp)
                )
                androidx.compose.material3.Text(
                    text = "**** ${data.pan}",
                    color = Color.White,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(top = 22.dp, start = 16.dp)
                )
                Spacer(modifier = Modifier.weight(1f, true))
                androidx.compose.material3.Text(
                    text = "${data.expiredMonth}/${data.expiredYear}",
                    color = Color.White,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(top = 22.dp, end = 20.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 38.dp, start = 20.dp)
            ) {
                androidx.compose.material3.Text(
                    text = "Balance",
                    color = Color.White,
                    fontSize = 17.sp,
                )
                androidx.compose.material3.Text(
                    text = "${data.amount} so‘m",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainContent() {

    MobileBankingUiComposeTheme() {
        MainContent(MainContract.UiState()) {}
    }

}