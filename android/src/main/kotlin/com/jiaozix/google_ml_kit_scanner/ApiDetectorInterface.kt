package com.jiaozix.google_ml_kit_scanner

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel


interface ApiDetectorInterface {
    fun getMethodsKeys(): List<String>

    fun onMethodCall(call: MethodCall, result: MethodChannel.Result)
}