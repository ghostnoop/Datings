package ru.date.datingfinder

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class WebAdapter : WebViewClient() {
    private lateinit var prefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    @SuppressLint("CommitPrefEdits")
    override fun onPageFinished(view: WebView, url: String) {
        prefs = view.context.getSharedPreferences("cookies", Context.MODE_PRIVATE)
        editor = prefs.edit()
        editor.putString("cookies", CookieManager.getInstance().getCookie(url))
        editor.apply()
    }

    @TargetApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(
        view: WebView,
        request: WebResourceRequest
    ): Boolean {
        view.loadUrl(request.url.toString())
        return true
    }

    override fun shouldOverrideUrlLoading(
        view: WebView,
        url: String
    ): Boolean {
        view.loadUrl(url)
        return true
    }


}