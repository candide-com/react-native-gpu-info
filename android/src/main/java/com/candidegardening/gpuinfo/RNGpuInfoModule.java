package com.candidegardening.gpuinfo;

import android.preference.PreferenceManager;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNGpuInfoModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    RNGpuInfoModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNGpuInfo";
    }

    @ReactMethod
    public void getGlRenderer(Promise promise) {
        String gpuRenderer = PreferenceManager.getDefaultSharedPreferences(reactContext).getString(Constants.GL_RENDERER, "Unknown");
        promise.resolve(gpuRenderer);
    }
}