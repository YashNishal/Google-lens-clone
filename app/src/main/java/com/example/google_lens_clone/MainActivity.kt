package com.example.google_lens_clone

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.google_lens_clone.barcode.BarcodeActivity
import com.example.google_lens_clone.facedetect.FaceDetectActivity
import com.example.google_lens_clone.imagelabeler.ImageLabelAnalyzer
import com.example.google_lens_clone.imagelabeler.ImageLabelingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic val PHOTO_REQ_CODE = 234
        @JvmStatic val EXTRA_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTakePhoto.setOnClickListener {
            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePhotoIntent, PHOTO_REQ_CODE)
        }

        btnCameraAcitivity.setOnClickListener {
            startActivity(Intent(this,CameraActivity::class.java))
        }

        btnBarcodeActivity.setOnClickListener {
            startActivity(Intent(this,BarcodeActivity::class.java))
        }

        btnFaceDetectActivity.setOnClickListener {
            startActivity(Intent(this,FaceDetectActivity::class.java))
        }

        btnLabelerActivity.setOnClickListener {
            startActivity(Intent(this,ImageLabelingActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PHOTO_REQ_CODE && resultCode == RESULT_OK) {
            val bitmap = data?.extras?.get(EXTRA_DATA) as Bitmap
            imgThumb.setImageBitmap(bitmap)
        }
    }
}