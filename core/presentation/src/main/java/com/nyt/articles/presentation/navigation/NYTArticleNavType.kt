package com.nyt.articles.presentation.navigation

import android.os.Bundle
import android.util.Base64
import androidx.navigation.NavType
import com.nyt.articles.core.common.entity.NYTArticle
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


val NYTArticleNavType = object : NavType<NYTArticle>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): NYTArticle? =
        bundle.getString(key)?.deserializeToNYTArticle()


    override fun put(bundle: Bundle, key: String, value: NYTArticle) =
        bundle.putString(key, value.serialize())

    override fun parseValue(value: String): NYTArticle = value.deserializeToNYTArticle()

    override fun serializeAsValue(value: NYTArticle): String = value.serialize()


    override val name: String = "NYTArticle"

}


fun NYTArticle.serialize(): String {
    val jsonString = Json.encodeToString(this)
    return Base64.encodeToString(jsonString.toByteArray(), Base64.DEFAULT)
}

fun String.deserializeToNYTArticle(): NYTArticle {
    val jsonString = String(Base64.decode(this, Base64.DEFAULT))
    return Json.decodeFromString(jsonString)
}