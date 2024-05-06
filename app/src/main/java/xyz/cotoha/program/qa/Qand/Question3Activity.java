package xyz.cotoha.program.qa.Qand;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\nアプリのアップデートについて\n\n\n" +
                "アプリのアップデートとはその名の通り\nLINEなどアプリに対してののアップデートです\n新しい機能の追加、不具合の修正など\n\n\n";

        textView.setText(text);
    }
}
