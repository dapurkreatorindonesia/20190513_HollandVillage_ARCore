package com.dapurkreatorindonesia.hollandvillage

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.afollestad.materialdialogs.MaterialDialog
import com.dapurkreatorindonesia.hollandvillage.onboard.OnboardActivity
import org.jsoup.Jsoup

class SplashScreenActivity : AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)


        checkAppVersion()

    }

    private fun checkAppVersion() {
        GetVersionCode().execute()
//        onVersionUpdated()
    }

    @SuppressLint("StaticFieldLeak")
    inner class GetVersionCode: AsyncTask<Void, String, String>() {

        override fun doInBackground(vararg params: Void?): String? {
            var newVersion: String? = null
            return try {
                newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + this@SplashScreenActivity.packageName)
                    .timeout(30000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get()
                    .select(".hAyfc .htlgb")
                    .get(7)
                    .ownText()
                newVersion
            } catch (e: Exception) {
//                Movic.logError(e)
                newVersion
            }
        }

        override fun onPostExecute(onlineVersion: String?) {
            super.onPostExecute(onlineVersion)
            onGetVersion(onlineVersion)
        }

    }

    private fun onGetVersion(version: String?){
        if (version != null){
            val currentVersion = packageManager.getPackageInfo(packageName, 0).versionName
            if (currentVersion != version){
                val majVersionNew = version.split(".")
                val majVersion = currentVersion.split(".")

                if (majVersionNew.size == 3 && majVersion.size == 3){
                    val majNew = majVersionNew[0].toInt()
                    val maj = majVersion[0].toInt()
                    val minNew = majVersionNew[1].toInt()
                    val min = majVersion[1].toInt()
                    val patchNew = majVersionNew[2].toInt()
                    val patch = majVersion[2].toInt()
                    if (majNew > maj){
                        onVersionOutOfDate()
                        return
                    }else if (majNew == maj){
                        if (minNew > min){
                            onVersionOutOfDate()
                            return
                        }else if (minNew == min && patchNew > patch){
                            onVersionOutOfDate()
                            return
                        }
                    }
                }
            }
        }
        onVersionUpdated()
    }

    private fun onVersionUpdated() {
            //3second splash time
            Handler().postDelayed({
                //start main activity
                startActivity(Intent(this@SplashScreenActivity, OnboardActivity::class.java))
                //finish this activity
                finish()
            },3000)
    }

    private fun onVersionOutOfDate() {
        MaterialDialog.Builder(this)
            .limitIconToDefaultSize()
            .title(R.string.warning)
            .content(R.string.out_of_date_app_version)
            .positiveText(R.string.open_play_store)
            .negativeText(R.string.close)
            .autoDismiss(false)
            .dismissListener { finish() }
            .canceledOnTouchOutside(false)
            .onPositive { _, _ -> openPlayStore() }
            .onNegative { _, _ -> finish() }
            .show()
    }

    private fun openPlayStore() {
        val appPackageName = packageName
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)))
        } catch (exception: android.content.ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)))
        }
    }

}