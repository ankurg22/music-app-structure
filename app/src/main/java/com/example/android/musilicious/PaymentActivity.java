package com.example.android.musilicious;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //Using Html class to properly format all text in one TextView
        TextView textView = findViewById(R.id.desc);

        //New method because old one was deprecated so using if-else statements to determine the sdk
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(
                    "<p>" + getString(R.string.step1) + "</p>" +
                            "<p>" + getString(R.string.step2) + "</p>" +
                            "<p>" + getString(R.string.step3) + "</p>" +
                            "<p>" + getString(R.string.step4) + "</p>" +
                            "<p>" + getString(R.string.step5) + "</p>" +
                            "<p>" + getString(R.string.step6) + "</p>" +
                            "<p>" + getString(R.string.step7) + "</p>" +
                            "<p>" + getString(R.string.step8) + "</p>" +
                            "<p>" + getString(R.string.step9) + "</p>",
                    Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(
                    "<p>" + getString(R.string.step1) + "</p>" +
                            "<p>" + getString(R.string.step2) + "</p>" +
                            "<p>" + getString(R.string.step3) + "</p>" +
                            "<p>" + getString(R.string.step4) + "</p>" +
                            "<p>" + getString(R.string.step5) + "</p>" +
                            "<p>" + getString(R.string.step6) + "</p>" +
                            "<p>" + getString(R.string.step7) + "</p>" +
                            "<p>" + getString(R.string.step8) + "</p>" +
                            "<p>" + getString(R.string.step9) + "</p>"));
        }
    }
}
