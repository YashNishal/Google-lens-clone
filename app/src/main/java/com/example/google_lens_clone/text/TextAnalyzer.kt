package com.example.google_lens_clone.text

import android.annotation.SuppressLint
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizerOptions

class TextAnalyzer : ImageAnalysis.Analyzer {

    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)



    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        Log.d("TEXT", "image analyzed")


        imageProxy.image?.let {
            val inputImage = InputImage.fromMediaImage(it,
                imageProxy.imageInfo.rotationDegrees
            )

            recognizer.process(inputImage)
                .addOnSuccessListener { text ->
                    text.textBlocks.forEach { block ->

                        Log.d("TEXT","""
                            LINES = ${block.lines.joinToString("\n"){ it.text} } 
                        """.trimIndent())
                    }
                }
                .addOnFailureListener { ex ->
                    Log.e("TEXT","DETECTION Failed",ex)
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        } ?: imageProxy.close()


    }

}