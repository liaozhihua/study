package com.example.study.compose

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import com.example.study.R

class ComposeKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("cccc")
            NewsStory()

        }
    }

    @Preview
    @Composable
    fun NewsStory() {
        Greeting("Android技术杂货铺")
        val iamge = +imageResource(R.mipmap.ic_launcher)
//        MaterialTheme() {
            Column(
                crossAxisSize = LayoutSize.Expand,
                modifier = Spacing(16.dp)
            ) {
                Container(expanded = true, height = 180.dp) {
                    Clip(shape = RoundedCornerShape(10.dp)) {
                        DrawImage(image = iamge)
                    }
                }
                HeightSpacer(height = 20.dp)

                Text("我超❤️JetPack Compose的！", style = +themeTextStyle { h5 }) // 注意添加了style
                Text("Android技术杂货铺", style = +themeTextStyle { body1 }) // 注意添加了style
                Text("依然范特西", style = +themeTextStyle { body2 }) // 注意添加了style
                Text("我超❤️JetPack Compose的！写起来简单，复用性又强，可以抽取很多组件来复用，不用管理复杂的状态变更！",
                    maxLines = 2, overflow = TextOverflow.Ellipsis,
                    style = (+themeTextStyle { h5 }).withOpacity(0.87f))

            }
//        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }
}