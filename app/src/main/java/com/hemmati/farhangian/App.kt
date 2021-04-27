package com.hemmati.farhangian

import android.app.Application
import com.hemmati.farhangian.di.NetworkModule
import com.hemmati.farhangian.di.PoodemanModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(getModulesList())
        }


    }

    private fun getModulesList(): List<Module> {
        return listOf(NetworkModule, PoodemanModule)
    }
}