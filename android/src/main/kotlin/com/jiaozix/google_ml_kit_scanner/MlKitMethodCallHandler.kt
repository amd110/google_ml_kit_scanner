package com.jiaozix.google_ml_kit_scanner

import android.content.Context
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import java.util.*


class MlKitMethodCallHandler(context: Context) : MethodChannel.MethodCallHandler {

    private var handlers: MutableMap<String, ApiDetectorInterface>

    init {
        val detectors = listOf(BarcodeDetector(context))
        handlers = HashMap()
        for (detector in detectors) {
            for (method in detector.getMethodsKeys()) {
                handlers[method] = detector
            }
        }
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        val handler: ApiDetectorInterface? = handlers[call.method]
        if (handler != null) {
            handler.onMethodCall(call, result)
        } else {
            result.notImplemented()
        }
    }
}