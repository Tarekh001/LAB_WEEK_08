package com.example.lab_week_08.worker

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class FirstWorker(
    context: Context, workerParams: WorkerParameters
) : Worker(context, workerParams) {

    // Fungsi ini menjalankan proses yang telah ditentukan berdasarkan input
    // dan mengembalikan output setelah selesai
    override fun doWork(): Result {
        // Ambil parameter input
        val id = inputData.getString(INPUT_DATA_ID)

        // Simulasi proses berat selama 3 detik
        Thread.sleep(3000L)

        // Bangun output berdasarkan hasil proses
        val outputData = Data.Builder()
            .putString(OUTPUT_DATA_ID, id)
            .build()

        // Kembalikan hasil sukses
        return Result.success(outputData)
    }

    companion object {
        const val INPUT_DATA_ID = "inId"
        const val OUTPUT_DATA_ID = "outId"
    }
}