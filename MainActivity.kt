package com.barbarians.global

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Bg = Color(0xFF07090D)
private val Card = Color(0xFF11151D)
private val Red = Color(0xFFFF2438)
private val Muted = Color(0xFF9AA2B1)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BarbariansApp() }
    }
}

@Composable
fun BarbariansApp() {
    var onboarded by remember { mutableStateOf(false) }
    var tab by remember { mutableStateOf(0) }
    MaterialTheme(colorScheme = darkColorScheme(primary = Red, background = Bg, surface = Card)) {
        Surface(Modifier.fillMaxSize(), color = Bg) {
            if (!onboarded) Welcome { onboarded = true } else MainShell(tab) { tab = it }
        }
    }
}

@Composable
fun Welcome(onStart: () -> Unit) {
    Column(
        Modifier.fillMaxSize().padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("B", color = Red, fontSize = 86.sp, fontWeight = FontWeight.Black)
        Text("BARBARIANS", fontSize = 30.sp, fontWeight = FontWeight.Black, letterSpacing = 2.sp)
        Spacer(Modifier.height(10.dp))
        Text("REAL PEOPLE  •  REAL TALKS  •  GLOBAL", color = Muted, fontSize = 11.sp, letterSpacing = 1.5.sp)
        Spacer(Modifier.height(42.dp))
        Text("Different places.\nSame purpose.", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(14.dp))
        Text("Meet, discuss, share ideas and build meaningful connections with people around the world.", color = Muted, fontSize = 15.sp)
        Spacer(Modifier.height(48.dp))
        Button(onClick = onStart, modifier = Modifier.fillMaxWidth().height(54.dp), shape = RoundedCornerShape(18.dp)) {
            Text("Get Started  →", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun MainShell(tab: Int, onTab: (Int) -> Unit) {
    Scaffold(
        containerColor = Bg,
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF0B0E14)) {
                val items = listOf("Home" to Icons.Default.Home, "Meetings" to Icons.Default.DateRange, "Chats" to Icons.Default.ChatBubbleOutline, "Profile" to Icons.Default.Person)
                items.forEachIndexed { i, pair ->
                    NavigationBarItem(selected = tab == i, onClick = { onTab(i) }, icon = { Icon(pair.second, null) }, label = { Text(pair.first) })
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}, containerColor = Red, contentColor = Color.White) { Icon(Icons.Default.Add, null) }
        }
    ) { p ->
        when (tab) {
            0 -> Home(Modifier.padding(p))
            1 -> Meetings(Modifier.padding(p))
            2 -> Chats(Modifier.padding(p))
            else -> Profile(Modifier.padding(p))
        }
    }
}

@Composable
fun Header(title: String, subtitle: String? = null) {
    Column(Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
        Text(title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
        subtitle?.let { Text(it, color = Muted, fontSize = 13.sp) }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    LazyColumn(modifier.fillMaxSize()) {
        item { Header("Barbarians", "Connect • Discuss • Grow") }
        item { HeroCard() }
        item { SectionTitle("Live & Upcoming") }
        item { MeetingCard("GLOBAL IDEAS FORUM", "Technology • Business • Future", "LIVE  •  1.3K joined") }
        item { SectionTitle("Popular Communities") }
        items(listOf("Business & Startups", "Tech & Innovation", "Education & Skills", "Global Networking")) { CommunityCard(it) }
    }
}

@Composable fun HeroCard() = CardBox { Text("Welcome to", color = Color.White); Text("Barbarians", color = Red, fontSize = 27.sp, fontWeight = FontWeight.Bold); Spacer(Modifier.height(6.dp)); Text("A global place for real conversations.", color = Muted) }

@Composable
fun Meetings(modifier: Modifier = Modifier) {
    LazyColumn(modifier.fillMaxSize()) {
        item { Header("Meetings", "Find conversations worth joining") }
        item { Row(Modifier.padding(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) { listOf("All", "Live", "Upcoming", "Past").forEachIndexed { i, s -> FilterChip(i == 0, { }, label = { Text(s) }) } } }
        items(listOf("Global Ideas Forum", "Africa to the World", "Creative Minds Meetup", "Tech Talks & AI", "Global Networking Hour")) { name -> MeetingCard(name, "Ideas • People • Collaboration", "Upcoming") }
    }
}

@Composable fun Chats(modifier: Modifier = Modifier) { Column(modifier.fillMaxSize()) { Header("Discussions", "Talk with people from anywhere"); CommunityCard("Global Networking"); CommunityCard("Business & Startups"); CommunityCard("Tech & Innovation") } }

@Composable fun Profile(modifier: Modifier = Modifier) { Column(modifier.fillMaxSize()) { Header("Profile"); CardBox { Text("Your Barbarians profile", fontWeight = FontWeight.Bold, fontSize = 20.sp); Text("Connect with communities, meetings and people.", color = Muted) }; CardBox { Text("Settings"); Text("Privacy • Notifications • Account", color = Muted) } } }

@Composable fun SectionTitle(t: String) { Text(t, Modifier.padding(20.dp, 18.dp, 20.dp, 8.dp), fontWeight = FontWeight.Bold, fontSize = 18.sp) }

@Composable
fun MeetingCard(name: String, desc: String, status: String) = CardBox {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(54.dp).background(Red.copy(alpha = .15f), RoundedCornerShape(14.dp)), contentAlignment = Alignment.Center) { Icon(Icons.Default.Public, null, tint = Red) }
        Spacer(Modifier.width(14.dp)); Column(Modifier.weight(1f)) { Text(name, fontWeight = FontWeight.Bold); Text(desc, color = Muted, fontSize = 12.sp); Spacer(Modifier.height(5.dp)); Text(status, color = Red, fontSize = 11.sp, fontWeight = FontWeight.Bold) }
        Icon(Icons.Default.ChevronRight, null, tint = Muted)
    }
}

@Composable
fun CommunityCard(name: String) = CardBox {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(48.dp).background(Color(0xFF1A1F2A), RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) { Icon(Icons.Default.Groups, null, tint = Red) }
        Spacer(Modifier.width(12.dp)); Column(Modifier.weight(1f)) { Text(name, fontWeight = FontWeight.SemiBold); Text("Meet people • Share ideas • Build", color = Muted, fontSize = 12.sp) }
        OutlinedButton(onClick = {}) { Text("Join") }
    }
}

@Composable
fun CardBox(content: @Composable ColumnScope.() -> Unit) { Card(Modifier.padding(horizontal = 20.dp, vertical = 6.dp).fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Card), shape = RoundedCornerShape(18.dp)) { Column(Modifier.padding(16.dp), content = content) } }
