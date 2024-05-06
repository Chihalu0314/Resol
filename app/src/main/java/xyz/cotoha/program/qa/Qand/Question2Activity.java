package xyz.cotoha.program.qa.Qand;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\nシステムアップデートについて\n\n\n" +
                "システムアップデートとは\nスマホ本体のアップデートです\n\n" +
                "大きな更新と小さな更新の2種類があります\n\n\n\n" +
                "=======大きな更新=======\n（メージャーアップデート）\n\n" +
                "・Andoridバージョンがアップデートされます\n" +
                "（現在の最新バージョンはAndroid14です）\n・新機能の追加やパフォーマンスの改善など\n\n\n\n" +
                "=======小さな更新=======\n（マイナーアップデート）\n\n" +
                "・小さな改善や新機能の追加修正など\n\n\n\n" +
                "=======注意事項=======\n\n" +
                "⑴ 大きな更新をする際は十分注意してください\n" +
                "※不具合が起きる可能性があります※\n\n\n" +
                "⑵ システムアップデートには\nサポート期限というものがあります\n" +
                "期限を過ぎるとシステムアップデートを\n受けることが出来なくなります\n\n\n" +
                "⑶ Google Pixel 7aは最低でも\n3年までのアップデートが保証されています\n" +
                "ただし、変更される可能性もあります\n" +
                "メジャーアップデートは2026年5月までの\n" +
                "サポートが予定されています\n\n" +
                "マイナーアップデートは2028年5月までの\n" +
                "サポートが予定されています\n\n\n\n";

        int colorRed = getResources().getColor(R.color.red);
        int colorBlue = getResources().getColor(R.color.blue);

        SpannableString spannableString = new SpannableString(text);

        int start1 = text.indexOf("大きな更新");
        int end1 = start1 + "大きな更新".length();
        ForegroundColorSpan colorSpanRed1 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed1, start1, end1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start2 = text.indexOf("小さな更新");
        int end2 = start2 + "小さな更新".length();
        ForegroundColorSpan colorSpanBlue1 = new ForegroundColorSpan(colorBlue);
        spannableString.setSpan(colorSpanBlue1, start2, end2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start3 = text.indexOf("=======大きな更新=======");
        int end3 = start3 + "=======大きな更新=======".length();
        ForegroundColorSpan colorSpanRed2 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed2, start3, end3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start4 = text.indexOf("=======小さな更新=======");
        int end4 = start4 + "=======小さな更新=======".length();
        ForegroundColorSpan colorSpanBlue2 = new ForegroundColorSpan(colorBlue);
        spannableString.setSpan(colorSpanBlue2, start4, end4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start5 = text.indexOf("=======注意事項=======");
        int end5 = start5 + "=======注意事項=======".length();
        ForegroundColorSpan colorSpanRed3 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed3, start5, end5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start6 = text.indexOf("⑴ 大きな更新をする際は十分注意してください\n");
        int end6 = start6 + "⑴ 大きな更新をする際は十分注意してください\n".length();
        ForegroundColorSpan colorSpanRed4 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed4, start6, end6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start7 = text.indexOf("※不具合が起きる可能性があります※\n\n\n");
        int end7 = start7 + "※不具合が起きる可能性があります※\n\n\n".length();
        ForegroundColorSpan colorSpanRed5 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed5, start7, end7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
    }


}
