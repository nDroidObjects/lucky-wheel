package com.example.spinwheel.javascript;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by amrut.bidri on 1/2/2017.
 */

public class MainActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebViewCallBack(new CallBackFromClass() {
            @Override
            public void getSpinWheelCoins(String text) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                //webView.loadUrl("javascript:resetWheel()");
            }
        }), "Android");

        webView.addJavascriptInterface(new WebAppInterface(this), "MyAndroid");

        webView.loadUrl("file:///android_asset/index.html");

    }
}
