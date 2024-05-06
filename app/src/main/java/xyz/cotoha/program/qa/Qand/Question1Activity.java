package xyz.cotoha.program.qa.Qand;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Question1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\nメールが届かないときの解決策\n\n\n\n" +
                "⑴ バッテリーの節約機能や\n最適化機能がオンになっている\n" +
                "オンになっている場合はオフにしてみてください\n\n\n" +
                "⑵ メールアプリを起動して上から下へ\nスワイプして更新してみてください\n\n\n" +
                "⑶ メールアプリを開かないと\n通知が届かないことがあります\n\n\n" +
                "⑷ 迷惑メールに届いていないか確認してください\n\n\n" +
                "⑸ 全ての受信トレイに切り替えて見てください\n";



        textView.setText(text);
    }
}
