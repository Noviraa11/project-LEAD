package com.dicoding.lead

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ParticipantEvaluationScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item { TotalEvaluationScore() }
        item { GeneralEvaluationSection() }
        item { ProgramAchievementSection() }
        item { ClusterAchievementSection() }
        item { DiscussionTopicsSection() }
        item { MentorFeedbackSection("Umpan Balik Mentor Cluster") }
        item { MentorFeedbackSection("Umpan Balik Mentor Desain Program") }
        item { ImprovementSection() }
    }
}

@Composable
fun TotalEvaluationScore() {
    Text(
        text = "Total Penilaian: 1620/2200",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun GeneralEvaluationSection() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "Penilaian Umum Peserta", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        EvaluationTable(
            items = listOf(
                EvaluationItem("Kehadiran", 50),
                EvaluationItem("Keaktifan", 40),
                EvaluationItem("Kemandirian / Inisiatif", 70),
                EvaluationItem("Pitching Day", 100),
                EvaluationItem("Capaian pendanaan yang didapat", 74),
                EvaluationItem("Kerjasama dengan instansi lain", 56),
                EvaluationItem("Keaktifan Sosial Media", 60),
                EvaluationItem("Pengurangan Nilai", 10),
            )
        )
    }
}

@Composable
fun ProgramAchievementSection() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "Evaluasi Capaian Desain Program", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        EvaluationTable(
            items = listOf(
                EvaluationItem("Capaian Desain Program 1", 160),
                EvaluationItem("Capaian Desain Program 2", 80),
                EvaluationItem("Capaian Desain Program 3", 140),
                EvaluationItem("Capaian Desain Program 4", 140),
            )
        )
    }
}

@Composable
fun ClusterAchievementSection() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "Evaluasi Capaian Cluster", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        EvaluationTable(
            items = listOf(
                EvaluationItem("Capaian Cluster 1", 160),
                EvaluationItem("Capaian Cluster 2", 80),
                EvaluationItem("Capaian Cluster 3", 140),
                EvaluationItem("Capaian Cluster 4", 140),
            )
        )
    }
}

@Composable
fun DiscussionTopicsSection() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "Hal-hal Yang Dibahas Selama Kegiatan Mentoring",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "1. Memiliki semangat yang besar untuk meningkatkan ...")
        Text(text = "2. Memanfaatkan media sosial tidak hanya Instagram, ...")
        Text(text = "3. Memiliki kekuatan untuk mendapatkan pendanaan ...")
    }
}

@Composable
fun MentorFeedbackSection(title: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "1. Meningkatkan keaktifan media sosial dalam melaporkan ...")
        Text(text = "2. Mengelola data-data capaian jumlah penerima manfaat ...")
        Text(text = "3. Melakukan pencatatan dan pengelolaan data ...")
    }
}

@Composable
fun ImprovementSection() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "Hal-Hal Yang Perlu Ditingkatkan",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "1. Meningkatkan keaktifan media sosial dalam melaporkan ...")
        Text(text = "2. Mengelola data-data capaian jumlah penerima manfaat ...")
        Text(text = "3. Melakukan pencatatan dan pengelolaan data ...")
    }
}

@Composable
fun EvaluationTable(items: List<EvaluationItem>) {
    Column {
        items.forEachIndexed { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "${index + 1}", modifier = Modifier.weight(1f))
                Text(text = item.aspect, modifier = Modifier.weight(6f))
                Text(text = item.score.toString(), modifier = Modifier.weight(1f))
            }
            HorizontalDivider()
        }
    }
}

data class EvaluationItem(val aspect: String, val score: Int)
