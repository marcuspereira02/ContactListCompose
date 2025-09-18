package com.marcuspereira.contactlistcompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcuspereira.contactlistcompose.ui.theme.ContactListComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactListComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column {
                        Text(
                            text = "Contacts",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 48.dp, start = 16.dp, end = 16.dp)
                        )

                        LazyColumn {
                            items(listContacts){contact ->
                                ContactCard(contact)
                            }
                        }

                    }



                }
            }
        }
    }
}

@Composable
fun ContactCard(contact: Contact) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(60.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(contact.icon),
                contentDescription = "Contact Image"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = contact.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = contact.phone,
                    color = Color.Gray
                )
            }
        }
    }

}

data class Contact(
    val name: String,
    val phone: String,
    @DrawableRes val icon: Int
)

private val listContacts = listOf(
    Contact(
        name = "Ana Flávia",
        phone = "(55) 12 987479983",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Anderson",
        phone = "(55) 12 987479477",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Beatriz",
        phone = "(55) 11 987409498",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Bia Franco",
        phone = "(55) 12 997426902",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "Bia Moreira",
        phone = "(55) 11 993479642",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Carol",
        phone = "(55) 12 997379497",
        icon = R.drawable.sample6
    ),
    Contact(
        name ="Carol Hipólito",
        phone = "(55) 11 987620194",
        icon = R.drawable.sample7
    ),
    Contact(
        name = "David",
        phone = "(55) 12 998450251",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Deyverson",
        phone = "(55) 12 997320648",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Ednaldo",
        phone = "(55) 12 992784017",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Flávia",
        phone = "(55) 12 990398173",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Guilherme",
        phone = "(55) 12 984920173",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Joana",
        phone = "(55) 12 986241083",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Jonas",
        phone = "(55) 11 998630297",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Maria Eduarda",
        phone = "(55) 12 996302918",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Stephanny",
        phone = "(55) 11 997201983",
        icon = R.drawable.sample16
    )
)


@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    ContactListComposeTheme {
        val contact = Contact(
            name = "Jonas",
            phone = "(55) 12995685861",
            icon = R.drawable.sample8
        )
        ContactCard(contact)
    }
}