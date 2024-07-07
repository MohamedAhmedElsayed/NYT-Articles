package com.nyt.articles.core.common.extentions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log


fun Context.openInBrowser(url: String) {
    runCatching {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }.onFailure {
        Log.e("Error", "openInBrowser: $it")
    }
}