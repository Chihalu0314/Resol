package xyz.cotoha.program.qa.Qand;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question6Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResolX.R.layout.activity_question6);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\n間違えて写真、動画などを消してしまった\n\n\n" +
                "万が一消してしまってもゴミ箱から\n復元することが出来ます" +
                "\n大抵が消してから30日間まで\nゴミ箱にありますが、過ぎると完全削除されます";

        textView.setText(text);
    }
}
