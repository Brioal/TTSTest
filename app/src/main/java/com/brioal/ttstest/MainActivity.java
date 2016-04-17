package com.brioal.ttstest;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.brioal.ttstest.util.BrioalUtil;

public class MainActivity extends AppCompatActivity {
    private EditText mEt;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BrioalUtil.init(this);
        setContentView(R.layout.activity_main);
        mEt = (EditText) findViewById(R.id.main_et);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    //初始化成功
                } else {
                    Toast.makeText(MainActivity.this, "初始化失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void speak(View view) {
        String content = mEt.getText().toString();
        if (content.isEmpty()) {
            //
            textToSpeech.speak("你是傻逼吗", TextToSpeech.QUEUE_ADD, null);
        } else {
            //
            textToSpeech.speak(content, TextToSpeech.QUEUE_ADD, null);

        }
    }
}
