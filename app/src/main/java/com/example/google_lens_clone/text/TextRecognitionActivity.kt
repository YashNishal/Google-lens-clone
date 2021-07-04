package com.example.google_lens_clone.text

import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.example.google_lens_clone.BaseLensActivity

class TextRecognitionActivity : BaseLensActivity(){
    override val imageAnalyzer = TextAnalyzer()

    override fun startScanner() {
        startTextRecognition()
    }

    private fun startTextRecognition() {
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }
}