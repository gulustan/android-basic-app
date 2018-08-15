package com.example.admin.xo;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.ViewHolder> {
    private List<ModelTxt> mTexts;
    private Context mContext;
    private AdaptorListener listener;
    public AdapterRV(Context context, List<ModelTxt> texts,AdaptorListener listener){
        this.mTexts = texts;
        this.mContext = context;
       this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.box, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(mTexts.get(position).getText());
        holder.daddyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null)
                    listener.onItemClick(view, position);
            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(listener!=null)
                   listener.onItemClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTexts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout daddyLayout;
        Button delete;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            daddyLayout = itemView.findViewById(R.id.parent_layout);
            delete = itemView.findViewById(R.id.del);
        }
    }
}
