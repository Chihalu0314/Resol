package xyz.cotoha.program.qa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class DefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        TextView textView = findViewById(R.id.text_view);
        String text = "この質問に対する詳細情報は現在準備中です。\nしばらくお待ちください。";
        textView.setText(text);
    }
}
