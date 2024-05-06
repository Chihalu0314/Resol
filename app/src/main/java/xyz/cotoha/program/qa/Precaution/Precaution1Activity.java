package xyz.cotoha.program.qa.Precaution;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import ResolX.R;

public class Precaution1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaution1);

        TextView textView = findViewById(R.id.text_view);
        String text = "\n\n会員登録中に前のページに戻る時に起こること\n\n" +
                "これはリアルタイム処理されている場合です\n\n\n\n" +
                "⑴ 入力した情報の喪失\n再度すべての情報を入力する必要になる\n\n\n" +
                "⑵ 二重購入などになってしまう可能性がある\n最初に入力した情報がすでに処理されている場合\n再度同じ情報を入力すると\n商品の購入を二度行ってしまうなどです\n\n\n" +
                "⑶ 登録の失敗\n" +
                "登録の途中で操作を中断すると\nシステムがエラーを起こし\n登録が完全に失敗する可能性がある\n\n\n" +
                "";



        textView.setText(text);
    }
}
