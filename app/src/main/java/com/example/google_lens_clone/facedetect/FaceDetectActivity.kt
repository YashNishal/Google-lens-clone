package com.example.google_lens_clone.facedetect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.example.google_lens_clone.BaseLensActivity

class FaceDetectActivity : BaseLensActivity() {

    override val imageAnalyzer = FaceDetectAnalyzer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun startFaceScanner() {
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }

    override fun startScanner() {
        startFaceScanner()
    }
}