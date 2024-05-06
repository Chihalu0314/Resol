package xyz.cotoha.program.qa.Qand;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\nパスワードの再設定について\n\n\n" +
                "パスワードを忘れてしまった場合\nパスワードの再設定をすることが出来ます\nただしメールアドレスを覚えている前提です\n\n\n" +
                "注意：必ず再設定できるわけではありません\n\n\n" +
                "パスワードを自動入力できるアプリを\n使用すれば忘れても安心です\n";

        int colorRed = getResources().getColor(R.color.red);

        SpannableString spannableString = new SpannableString(text);

        int start1 = text.indexOf("注意：必ず再設定できるわけではありません");
        int end1 = start1 + "注意：必ず再設定できるわけではありません".length();
        ForegroundColorSpan colorSpanRed1 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed1, start1, end1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
    }
}
