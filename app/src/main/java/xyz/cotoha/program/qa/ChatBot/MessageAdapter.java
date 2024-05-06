package xyz.cotoha.program.qa.ChatBot;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ResolX.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<xyz.cotoha.program.qa.ChatBot.Message> messages;

    public MessageAdapter(List<xyz.cotoha.program.qa.ChatBot.Message> messages) {
        this.messages = messages;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.messageTextView.setText(message.getText());

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.messageTextView.getLayoutParams();

        if (message.getSender() == Message.Sender.USER) {
            holder.iconImage.setVisibility(View.GONE);
            holder.messageTextView.setBackgroundResource(R.drawable.chat_bubble_right);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
            layoutParams.removeRule(RelativeLayout.END_OF);
        } else {
            holder.iconImage.setVisibility(View.VISIBLE);
            holder.messageTextView.setBackgroundResource(R.drawable.chat_bubble_left);
            layoutParams.addRule(RelativeLayout.END_OF, R.id.icon_image);
            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
        }

        if (message.isError()) {
            holder.messageTextView.setTextColor(Color.RED);
        } else {
            holder.messageTextView.setTextColor(Color.BLACK);
        }

        holder.messageTextView.setLayoutParams(layoutParams);
    }




    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconImage;
        public TextView messageTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.icon_image);
            messageTextView = itemView.findViewById(R.id.message_text);
        }
    }

}