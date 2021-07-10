package com.hellokh.sovary.adfbkotlin

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.facebook.ads.*
import java.util.*

class FbAdManager(val ctx: Context)
{
    private companion object
    {
        lateinit var adInter: InterstitialAd
    }

    init {
        AudienceNetworkAds.initialize(ctx)
    }

    fun showBanner(layout: LinearLayout, adId:String, size: AdSize = AdSize.BANNER_HEIGHT_50)
    {
        val adView = AdView(ctx,adId,size)
        layout.addView(adView)
        val config = adView.buildLoadAdConfig().withAdListener(object :AdListener
        {
            override fun onError(p0: Ad?, p1: AdError?) {
                Toast.makeText(ctx,"Banner ${p1?.errorMessage}", Toast.LENGTH_SHORT).show()
            }

            override fun onAdLoaded(p0: Ad?) {
                Toast.makeText(ctx,"Banner Loaded",Toast.LENGTH_SHORT).show()
            }

            override fun onAdClicked(p0: Ad?) {
                Toast.makeText(ctx,"Banner Clicked",Toast.LENGTH_SHORT).show()
            }

            override fun onLoggingImpression(p0: Ad?) {
                //TODO("Not yet implemented")
            }

        }).build()
        adView.loadAd(config)
    }

    fun createInterstitial(adId: String)
    {
        adInter = InterstitialAd(ctx,adId)
        val config = adInter.buildLoadAdConfig().withAdListener(object : InterstitialAdListener
        {
            override fun onError(p0: Ad?, p1: AdError?) {
                Toast.makeText(ctx,"Inter ${p1?.errorMessage}", Toast.LENGTH_SHORT).show()
            }

            override fun onAdLoaded(p0: Ad?) {
                Toast.makeText(ctx,"Inter Loaded", Toast.LENGTH_SHORT).show()
            }

            override fun onAdClicked(p0: Ad?) {
                Toast.makeText(ctx,"Inter Clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onLoggingImpression(p0: Ad?) {
                //TODO("Not yet implemented")
            }

            override fun onInterstitialDisplayed(p0: Ad?) {
                Toast.makeText(ctx,"Inter Displayed", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialDismissed(p0: Ad?) {
                Toast.makeText(ctx,"Inter Dismissed", Toast.LENGTH_SHORT).show()
            }

        }).build()
        adInter.loadAd(config)
    }
    fun showInterstitial()
    {
        if(adInter == null) return
        if(adInter.isAdLoaded)
            adInter.show()
        else adInter.loadAd()
    }
}