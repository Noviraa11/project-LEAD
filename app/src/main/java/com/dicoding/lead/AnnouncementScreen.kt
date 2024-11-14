package com.dicoding.lead

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Event

@Composable
fun AnnouncementScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Header()
        AnnouncementTabs()
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            items(announcementList) { announcement ->
                AnnouncementItem(announcement)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Pengumuman", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Tandai Telah Dibaca",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp
        )
    }
}

@Composable
fun AnnouncementTabs() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Semua", "Pemberitahuan", "Informasi LEAD", "Informasi BCF")

    TabRow(selectedTabIndex = selectedTab) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTab == index,
                onClick = { selectedTab = index }
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun AnnouncementItem(announcement: Announcement) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = announcement.icon,
                contentDescription = "Announcement Icon",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = announcement.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = announcement.date,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = announcement.description,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            announcement.tags.forEach { tag ->
                Tag(tag = tag)
            }
        }
    }
}

@Composable
fun Tag(tag: String) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = Color.LightGray,
        modifier = Modifier.padding(end = 4.dp)
    ) {
        Text(
            text = tag,
            fontSize = 12.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

// Sample data for announcements
data class Announcement(
    val title: String,
    val date: String,
    val description: String,
    val tags: List<String>,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

// Example data (you would replace with actual icons and data)
val announcementList = listOf(
    Announcement(
        title = "Jangan lupa untuk mengumpulkan MISI 2 terkait Momen Onboarding",
        date = "31 Mei 2023, 10.00 WIB",
        description = "Jangan lupa untuk mengumpulkan MISI 2 terkait Momen Onboarding sebelum Sabtu, 2 Mei 2023 pukul 19.00 WIB. Tetap semangat, ya!",
        tags = listOf("Reminder"),
        icon = Icons.Default.Notifications // replace with appropriate icon
    ),
    Announcement(
        title = "Jangan lupa untuk menyelesaikan Lembar Kerja Topik: Desain Program Sosial",
        date = "7 April 2023, 10.00 WIB",
        description = "Jangan lupa untuk menyelesaikan Lembar Kerja Topik: Desain Program Sosial sebelum Minggu, 14 April 2023 pukul 23.30 WIB. Tetap semangat, ya!",
        tags = listOf("Reminder"),
        icon = Icons.Default.Event // replace with appropriate icon
    ),
    // Add more announcements as needed
)