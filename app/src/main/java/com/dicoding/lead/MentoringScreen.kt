package com.dicoding.lead

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MentoringScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Greeting and Introduction
        Text(text = "Halo, Peserta", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Berikut Kelompok Mentoring dan Mentor yang akan menjadi pendampingmu selama perjalanan LEAD Indonesia!",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mentor Information Section
        MentorInfoSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Mentoring Group Table
        Text(text = "Kelompok Mentoring", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        MentoringGroupTable()
    }
}

@Composable
fun MentorInfoSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Mentor Image
        Image(
            painter = painterResource(id = R.drawable.mentor_image), // Replace with actual resource ID
            contentDescription = "Mentor Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Mentor Details
        Column {
            Text(text = "Dody Supriyadi", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "Mentor Cluster • Kesehatan", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Tuberculosis (TBC) • Stunting • HIV/AIDS",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun MentoringGroupTable() {
    // Sample data for the table
    val mentoringGroups = listOf(
        MentoringGroup(1, "Bakrie Center Foundation", "Tuberculosis"),
        MentoringGroup(2, "Yayasan Literasi Kita Indonesia", "Stunting"),
        MentoringGroup(3, "STPI Penabulu Banten", "HIV/AIDS")
    )

    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
            ) {
                Text("No.", modifier = Modifier.weight(0.2f), fontWeight = FontWeight.Bold)
                Text("Nama Lembaga", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
                Text("Fokus Isu", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
            }

            HorizontalDivider(color = Color.Gray)

            LazyColumn {
                items(mentoringGroups) { group ->
                    MentoringGroupRow(group)
                    HorizontalDivider(color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun MentoringGroupRow(group: MentoringGroup) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = group.id.toString(), modifier = Modifier.weight(0.2f))
        Text(text = group.name, modifier = Modifier.weight(1f))
        Text(text = group.issue, modifier = Modifier.weight(1f))
    }
}

data class MentoringGroup(val id: Int, val name: String, val issue: String)
