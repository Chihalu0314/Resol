package xyz.cotoha.program.qa.Qand;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ResolX.R;
import xyz.cotoha.program.qa.DefaultActivity;

public class QandAAdapter extends RecyclerView.Adapter<QandAAdapter.ViewHolder> {
    private List<QandA> qandaList;
    private Context context;
    private Class[] activityClasses = {Question1Activity.class, Question2Activity.class, Question3Activity.class,
            Question4Activity.class, Question5Activity.class, Question6Activity.class, Question7Activity.class, Question8Activity.class};  // ここに各質問に対応するアクティビティクラスを追加します

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView questionView;
        public TextView answerView;

        public ViewHolder(View v) {
            super(v);
            questionView = v.findViewById(R.id.question);
            answerView = v.findViewById(R.id.answer);
        }
    }

    public QandAAdapter(List<QandA> qandaList, Context context) {
        this.qandaList = qandaList;
        this.context = context;
    }

    @Override
    public QandAAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.qanda_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QandA qanda = qandaList.get(position);
        holder.questionView.setText(qanda.getQuestion());
        holder.answerView.setText(qanda.getAnswer());

        // 質問をタップしたときのリスナーを設定します
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ここで新しいアクティビティを開始します
                Intent intent;
                int pos = holder.getAdapterPosition();  // ここで現在のアダプター位置を取得します
                if (pos != RecyclerView.NO_POSITION && pos < activityClasses.length) {
                    intent = new Intent(context, activityClasses[pos]);
                } else {
                    intent = new Intent(context, DefaultActivity.class);
                }
                context.startActivity(intent);
            }
        };

        holder.questionView.setOnClickListener(onClickListener);
        holder.answerView.setOnClickListener(onClickListener);  // 回答をタップしたときも同じリスナーを設定します
    }


    @Override
    public int getItemCount() {
        return qandaList.size();
    }
}
