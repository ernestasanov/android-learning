package com.learning.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button startActivity1Button;
    private Button startActivity2Button;
    private Button startActivity3Button;
    private Button startActivity4Button;

    private static final int ACTIVITY2_REQUEST_CODE = 1;
    public static final String ACTIVITY2_RESULT_EXTRA = "activity2_result";
    public static final int ACTIVITY2_RESULT = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ACTIVITY2_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra(ACTIVITY2_RESULT_EXTRA, 0);
                if (result == ACTIVITY2_RESULT) {
                    startActivity3Button.setVisibility(View.VISIBLE);
                    startActivity4Button.setVisibility(View.VISIBLE);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
