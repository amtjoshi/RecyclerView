package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<DataModel>arrayList;
    MyAdapter(ArrayList<DataModel> arrayList)
    {
        this.arrayList=arrayList;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlayout,viewGroup,false);
       MyViewHolder viewHolder=new MyViewHolder(view);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
     DataModel dataModel=arrayList.get(i);
        viewHolder.imageView.setImageResource(dataModel.image);
 viewHolder.textView.setText(dataModel.title);
 viewHolder.setListener(i);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        ImageView remove;
        ImageView copy;
        int i;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            remove=itemView.findViewById(R.id.remove);
            copy=itemView.findViewById(R.id.copy);

        }
   public  void setListener(int i)
   {   this.i=i;
      remove.setOnClickListener(MyViewHolder.this);
       copy.setOnClickListener(MyViewHolder.this);

   }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.remove: {
                    arrayList.remove(i);
                    notifyItemRemoved(i);
                    notifyItemRangeChanged(i,arrayList.size());
                    break;
                }
                case R.id.copy:{
                    arrayList.add(i,arrayList.get(i));

                    notifyItemInserted(i);
                    notifyItemRangeChanged(i,arrayList.size());
break;                }}


        }
    }
}
