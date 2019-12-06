package com.learning.sample;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    private void finishWithResult() {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.ACTIVITY2_RESULT_EXTRA, MainActivity.ACTIVITY2_RESULT);
        setResult(RESULT_OK, intent);
    }
}
