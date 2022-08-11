package com.bbg.composerturtors

import android.graphics.LightingColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bbg.composerturtors.ui.theme.ComposerTurtorsTheme

class DemoUiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MessageUi(Message(name = "李白1", content = "30"))
        }
    }

    @Composable
    fun MesListUi(data: List<com.bbg.composerturtors.Message>) {
        LazyColumn {
            items(data) { item ->
                MessageUi(item)
            }
        }
    }
    
    @Preview
    @Composable
    fun PreviewDataListUi() {
        MesListUi(data = SampleData.conversationSample)
    }

    @Preview
    @Composable
    fun MessageUi(message: Message? = null) {

        Box(contentAlignment = Alignment.TopStart) {

        }

        Row(
            Modifier.padding(all = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.profile_picture),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.2.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(9.dp))
            Column {
                Text(
                    text = message?.name ?: "unknown",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                androidx.compose.material.Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp
                ) {
                    Text(
                        text = "" + message?.content,
                        color = MaterialTheme.colors.secondaryVariant,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }

    }
}