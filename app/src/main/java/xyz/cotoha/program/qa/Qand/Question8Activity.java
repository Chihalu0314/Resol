package xyz.cotoha.program.qa.Qand;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question8Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResolX.R.layout.activity_question8);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\n文字などが見にくい\n\n\n" +
                "ユーザー補助機能を使うことができます\n\n";

        textView.setText(text);

        // "補助設定を行うにはここをタップしてください"という部分のテキストビューを取得します。
        TextView clickableText = findViewById(R.id.clickable_text);
        clickableText.setText("補助設定を行うにはここをタップしてください\n\n\n");

        // テキストの色を赤に設定します。
        clickableText.setTextColor(Color.RED);


        // テキストビューをクリックしたときのリスナーを設定します。
        clickableText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ユーザー補助設定画面に遷移します。
                Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
            }
        });

        TextView textView2 = findViewById(R.id.text_view2);
        String text2 = "主な補助機能一覧\n\n" +
                "⑴ 文字サイズ\n" +
                "　文字のサイズを変更できます\n\n" +
                "⑵ 表示サイズ\n" +
                "　全てのサイズを変更できます\n\n" +
                "⑶テキストを太字へ\n" +
                "　文字を太文字へ変更できます";

        textView2.setText(text2);
    }
}
