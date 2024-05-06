package xyz.cotoha.program.qa.Precaution;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ResolX.R;

public class PrecautionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaution);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        List<Precaution> precautionList = new ArrayList<>();
        precautionList.add(new Precaution("⑴ 会員登録中に別のページに移ると...", "　タップして詳細を見てください"));
        precautionList.add(new Precaution("⑵ ネットを閲覧してたら突然ウイルスが!?", "　タップして詳細を見てください"));
        precautionList.add(new Precaution("⑶ 不審なショートメールが届いたら", "　タップして詳細を見てください"));

        PrecautionAdapter adapter = new PrecautionAdapter(precautionList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}