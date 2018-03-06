package com.example.nshwe.uicomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.SearchView;

public class BrowserActivity extends AppCompatActivity {

    private Button button;
    private SearchView searchView;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        button = findViewById(R.id.searchBtn);
        searchView = findViewById(R.id.searchView);
        webView = findViewById(R.id.webView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browse();
            }
        });
    }
    private void browse() {
        String url = searchView.getQuery().toString();
        webView.setWebViewClient(new MyBrowser());

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
