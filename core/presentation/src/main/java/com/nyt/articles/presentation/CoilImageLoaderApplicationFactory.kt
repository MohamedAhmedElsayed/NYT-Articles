package com.nyt.articles.presentation

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.util.DebugLogger

open class CoilImageLoaderApplicationFactory : Application(), ImageLoaderFactory {
    private val diskCache by lazy {
        DiskCache.Builder()
            .directory(cacheDir.resolve("image_cache"))
            .maxSizeBytes(5 * 1024 * 1024)
            .build()
    }
    private val memoryCache by lazy {
        MemoryCache.Builder(this)
            .maxSizePercent(0.20)
            .build()
    }

    override fun newImageLoader() = ImageLoader.Builder(this)
        .memoryCache { memoryCache }
        .diskCache { diskCache }
        .logger(DebugLogger())
        .respectCacheHeaders(false)
        .build()

}

