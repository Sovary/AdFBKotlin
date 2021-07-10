package com.hellokh.sovary.adfbkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.ads.AdSize

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ad = FbAdManager(this)
        ad.showBanner(findViewById(R.id.banner_wrapper),"IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_90)
    }
}