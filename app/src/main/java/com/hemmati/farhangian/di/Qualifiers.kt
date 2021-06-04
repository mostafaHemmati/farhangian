package com.hemmati.farhangian.di

import org.koin.core.qualifier.named

object NetworkQualifiers {
    val RETROFIT_1 = named("retrofit1")
    val RETROFIT_2 = named("retrofit2")
}

object PoodemanQualifiers {
    val INSTANCE_1 = named("instance1")
    val INSTANCE_2 = named("instance2")
}