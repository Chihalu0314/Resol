package xyz.cotoha.program.qa.Qand;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResolX.R.layout.activity_question5);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\n今まであった機能が無い、変わってる\n\n\n" +
                "システムアップデートやアプリのアップデート\nで変更されたり廃止された可能性があります\n\n更新内容はPlayストアから確認できます";

        textView.setText(text);
    }
}
