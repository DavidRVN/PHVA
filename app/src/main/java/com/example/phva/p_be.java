package com.example.phva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class p_be extends Fragment {


    public p_be() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_p_be, container, false);

        View view = inflater.inflate(R.layout.fragment_p_be, container, false);
        WebView webView = (WebView)view.findViewById(R.id.webViewForm);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        /*webView.loadUrl("https://usefulangle.com/demos/352/camera-capture-photo.html");*/
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSflz8mrviuiyyKahWYui0abjRLVpUWNct2v_izDkoKt7QUi1g/viewform?usp=sf_link");
        return view;

    }
}