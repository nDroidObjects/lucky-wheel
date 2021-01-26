package com.example.spinwheel.javascript;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by amrut.bidri on 1/2/2017.
 */

public class WebViewCallBack {

    CallBackFromClass callBackFromClass;

    public WebViewCallBack(CallBackFromClass callBackFromClass) {
        this.callBackFromClass = callBackFromClass;
    }

    @JavascriptInterface
    public void log(String text) {
        callBackFromClass.getSpinWheelCoins(text);
        Log.d("final_number", text);
    }
}
