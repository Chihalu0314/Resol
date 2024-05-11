package xyz.cotoha.program.qa.Qand;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question7Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResolX.R.layout.activity_question7);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\nデータ通信量の節約方法\n\n\n" +
                "===============動画===============\n\n" +
                "⑴ YouTubeの動画の画質を下げる\n\n" +
                "⑵ データセーバーを利用する\nWifi接続時は高画質で\nモバイルデータ通信時は標準～低画質と\n自動的に切り替えてくれる機能です\n\n\n" +
                "・低画質 144p: 約120MB/1時間\n" +
                "・低画質 240p: 約180MB/1時間\n" +
                "・標準画質 360p: 約360MB/1時間\n" +
                "・標準画質 480p: 約600MB/1時間\n" +
                "・高画質 720p: 約1.08GB/1時間\n" +
                "・高画質 1080p: 約2.04GB/1時間\n\n" +
                "外で見る場合は480pか360p\n\n" +
                "・TB=テラバイト（1TB ＝ 1000GB）\n・GB ＝ ギガバイト（1GB=1000MB）\n・MB ＝ メガバイト（1MB=1000KB）\n・KB ＝ キロバイト（1KB=1000B）\n・B ＝ バイト　　　　　　　　　\n\n"+
                "⑶ オフライン再生を利用する\n" +
                "事前にダウンロードしておいた動画を\nオフラインで再生できます\n（YouTube Premiere会員のみ利用可能）\n\n" +
                "===============音楽===============\n\n" +
                "⑴ 音質を下がる（Spotify）\n\n" +
                "・低音質 約10.8MB/1時間\n" +
                "・標準音質 約43.2MB/1時間\n" +
                "・高音質 約72MB/1時間\n" +
                "・最高音質 約144MB/1時間\n\n" +
                "標準音質か高音質が適切\n\n" +
                "イヤホンで聞かない限りそんなに変わりはない\n\n\n" +
                "⑵ 曲を端末に入れる\nこうすることでデータ通信量は一切増えない\n\n\n" +
                "===============まとめ===============\n\n" +
                "動画と音楽では消費するデータ通信量は違う¥\n\n\n\n";


        int colorRed = getResources().getColor(R.color.red);

        SpannableString spannableString = new SpannableString(text);

        int start1 = text.indexOf("（YouTube Premiere会員のみ利用可能）");
        int end1 = start1 + "（YouTube Premiere会員のみ利用可能）".length();
        ForegroundColorSpan colorSpanRed1 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed1, start1, end1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start2 = text.indexOf("⑴ YouTubeの動画の画質を下げる");
        int end2 = start2 + "⑴ YouTubeの動画の画質を下げる".length();
        ForegroundColorSpan colorSpanRed2 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed2, start2, end2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start3 = text.indexOf("⑵ データセーバーを利用する");
        int end3 = start3 + "⑵ データセーバーを利用する".length();
        ForegroundColorSpan colorSpanRed3 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed3, start3, end3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start4 = text.indexOf("⑶ オフライン再生を利用する");
        int end4 = start4 + "⑶ オフライン再生を利用する".length();
        ForegroundColorSpan colorSpanRed4 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed4, start4, end4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start5 = text.indexOf("イヤホンで聞かない限りそんなに変わりはない");
        int end5 = start5 + "イヤホンで聞かない限りそんなに変わりはない".length();
        ForegroundColorSpan colorSpanRed5 = new ForegroundColorSpan(colorRed);
        spannableString.setSpan(colorSpanRed5, start5, end5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
    }
}
