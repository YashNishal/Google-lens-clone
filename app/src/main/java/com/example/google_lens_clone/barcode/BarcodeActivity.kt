package com.example.google_lens_clone.barcode

import androidx.core.content.ContextCompat
import com.example.google_lens_clone.BaseLensActivity


class BarcodeActivity : BaseLensActivity() {


    override val imageAnalyzer = BarcodeAnalyzer()


    override fun startScanner() {
        scanBarcode()
    }

    private fun scanBarcode() {

        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )

    }

}