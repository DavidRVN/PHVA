package com.example.phva;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class detail_docs extends Fragment {

    public String UrlF;

    public detail_docs() {
        // Required empty public constructor
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_docs, container, false);

        String url = getArguments().getString("url");

        Toast.makeText(getContext(), UrlF, Toast.LENGTH_SHORT).show();

        WebView webView = (WebView)view.findViewById(R.id.webViewForm);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
      //  webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSflz8mrviuiyyKahWYui0abjRLVpUWNct2v_izDkoKt7QUi1g/viewform?usp=sf_link");
        webView.loadUrl(url);


        return view;
    }
}