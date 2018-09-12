package com.example.mohamedelnhrawy.marvelwalltask.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohamedelnhrawy.marvelwalltask.R;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.Marvel;
import com.example.mohamedelnhrawy.marvelwalltask.utils.NenoBoldTextView;
import com.example.mohamedelnhrawy.marvelwalltask.utils.NenoRegularTextView;

import java.util.List;

/**
 * Created by mohamedelnhrawy on 9/12/18.
 */

public class MarvelListAdapter extends RecyclerView.Adapter<MarvelListAdapter.ListItemViewHolder> {

    private List<Marvel> list;
    private Context context;
    private onCardClicked callback;

    public interface onCardClicked{
        void onItemClicked(int position,Marvel marvel);
    }

    public MarvelListAdapter(Context context,List<Marvel> list) {
        this.list = list;
        this.context=context;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.marvel_list_row, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, final int position) {

        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_body.setText(list.get(position).getBody());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClicked(position,list.get(position));
            }
        });

        holder.tv_body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClicked(position,list.get(position));

            }
        });

        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClicked(position,list.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public NenoBoldTextView tv_title;
        public NenoRegularTextView tv_body;
        private CardView card;


        public ListItemViewHolder(View itemView) {
            super(itemView);
            tv_title = (NenoBoldTextView) itemView.findViewById(R.id.tv_title);
            tv_body = (NenoRegularTextView) itemView.findViewById(R.id.tv_body);
            card = (CardView) itemView.findViewById(R.id.card);
        }
    }

    public void updateList(List<Marvel> marvelList){
        this.list=marvelList;
        notifyDataSetChanged();
    }

    public void setItemClickedCallback(onCardClicked callback){
        this.callback=callback;
    }
}
