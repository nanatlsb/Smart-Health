package br.com.fiap.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    VacinasPage()
                }
            }
        }
    }
}

@Composable
fun VacinasBox(
    title: String,
    date: String,
    color: Color,
    line: Boolean,
    modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Text("$date", fontSize = 10.sp, color = Color(0xff454545),)
            if(line) {
                Box(
                    modifier = Modifier
                        .width(3.dp)
                        .fillMaxHeight()
                        .background(color.copy(alpha = 0.4f))
                ) {
                }
            }
        }
        Row ( modifier = Modifier
            .width(280.dp)
            .height(40.dp)
            .background(
                color.copy(alpha = 0.12f),
                shape = RoundedCornerShape(5.dp)
            )
        ){
            Box (
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(
                        color = color,
                        shape = RoundedCornerShape(
                            topStart = 15.dp,
                            bottomStart = 15.dp,
                        )
                    )
            ) {

            }
            Text(
                "$title",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff1E1D1D),
                modifier = Modifier.padding(
                    start = 15.dp,
                    top = 10.dp
                )
            )
        }
    }
}
@Composable
fun VacinasList(modifier: Modifier = Modifier) {
    Column (modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Próximas campanhas",
                color = Color(0xff5E5E5E)
            )
            Text(
                "Mais",
                color = Color(0xff7FAAC8),
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        VacinasBox(
            "Imunização contra dengue",
            "05/05/2024",
            Color(0xff53AFAA),
            true
        )
        VacinasBox(
            "Vacinação H1N1",
            "10/03/2024",
            Color(0xffF6945D),
            true
        )
        VacinasBox(
            "Reforço contra Covid-19",
            "20/04/2024",
            Color(0xffE23424),
            false
        )
    }
}


@Composable
fun VacinasPage(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)

    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xffD9D9D9)
                        .copy(alpha = 0.23f),
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    BorderStroke(
                        1.dp,
                        Color(0xffE7E7E7)
                    ),
                    shape = RoundedCornerShape(15.dp)
                ),
//                .clip(GenericShape { size, _ ->
//                    lineTo(size.width, 0f)
//                    lineTo(size.width, Float.MAX_VALUE)
//                    lineTo(0f, Float.MAX_VALUE)
//                })
//                .shadow(
//                    shape = RoundedCornerShape(15.dp),
//                    elevation = ().dp,
//                    spotColor = Color.Transparent
//                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text("Sua Unidade UBS",
                fontSize = 16.sp,
                color = Color(0xff5E5E5E),
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp)
            )
            Text("UBS Vila Prudente",
                fontSize = 16.sp,
                color = Color(0xff5398C8),
                modifier = Modifier.padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            )
        }
        VacinasList()
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(0.dp)
                    .border(
                        BorderStroke(
                            1.dp,
                            Color(0xff7FAAC8)
                                .copy(alpha = 0.63f),
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xff5398C8)
                )
            ) {
                Text("Histórico de Vacinação",
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxWidth(),
                    fontSize = 16.sp
                )
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(0.dp)
                    .border(
                        BorderStroke(
                            1.dp,
                            Color(0xff7FAAC8)
                                .copy(alpha = 0.63f),
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xff5398C8)
                )
            ) {
                Text("Buscar em outra unidade de saúde",
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxWidth(),
                    fontSize = 16.sp,
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(152.dp)
                    .padding(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff7FAAC8),
                    contentColor = Color(0xffffffff)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Agendar Vacina",
                    modifier = Modifier
                        .padding(0.dp)
                        .width(80.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
                Text("+",
                    modifier = Modifier
                        .padding(0.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VacinasPagePreview() {
    HelloWorldTheme {
        VacinasPage()
    }
}

@Composable
fun Greeting(age: Int, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Informe sua idade",
            modifier = modifier
        )
        Text("$age",
            modifier = modifier
        )
        Row () {
            Button(onClick = { /*TODO*/ }) {
                Text("+")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { /*TODO*/ }) {
                Text("-")
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    HelloWorldTheme {
//        Greeting(25)
//    }
//}