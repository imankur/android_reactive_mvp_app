package com.ankur.mvp.app;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ankur.mvp.app.model.Question;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItem> {

    List<Question> questions;

    @Override
    public ListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ListItem(v);
    }

    @Override
    public void onBindViewHolder(ListItem holder, int position) {
        Question question = questions.get(position);

        holder.mTitle.setText(question.getTitle());
        holder.name.setText(question.getUser().getName());
        holder.time.setText(formatRelativeTime(question.getCreationDate()));
        Picasso.with(holder.avatar.getContext()).load(question.getUser().getImage()).placeholder(R.drawable.ic_action_name).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return questions == null ? 0 : questions.size();
    }

    void setData(List<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }

    class ListItem extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.created)
        TextView time;

        public ListItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static String formatRelativeTime(long time) {
        return DateUtils.getRelativeTimeSpanString(time * 1000, System.currentTimeMillis(),
                android.text.format.DateUtils.MINUTE_IN_MILLIS).toString();
    }
}
