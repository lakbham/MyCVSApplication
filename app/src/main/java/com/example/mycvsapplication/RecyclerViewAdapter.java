package com.example.mycvsapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context mcontext;
    private ArrayList<String> mToDoListItems;
   // ImageView mImageView1;
   private static ImageView mImageView2;
    private static Button mButton3;
    private int current_img;
    int[] images={R.drawable.ic_done_black_24dp,R.drawable.ic_highlight_off_black_24dp};


           // hightlight_light_off_button;
    public RecyclerViewAdapter(Context context, ArrayList<String> ToDoList, Button button3, ImageView imageView2 ){
        mcontext=context;
        mToDoListItems=ToDoList;
        mButton3=button3;
        mImageView2=imageView2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent, false);
        return new RecyclerViewAdapter.ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {
  final String currentItem=mToDoListItems.get(position);
  holder.textView.setText(currentItem);

  holder.button3.setOnClickListener(new View.OnClickListener(){
@Override
      public void onClick(View view){
    switch(view.getId()) {
        case (R.id.button3 ):
                if (MainActivity.flag==true) {

            holder.imageView2.setImageResource(images[0]);
            holder.textView.setBackgroundColor(Color.parseColor("#00ff00"));
           // holder.textView.setBackgroundColor(Integer.parseInt("#90ee90"));
            notifyItemInserted(position);
            // mToDoListItems.add(currentItem);
            //mToDoListItems.remove(position);
            notifyDataSetChanged();
            //notifyItemRemoved(position);
            // notifyItemChanged(position,mToDoListItems.size());
            // mToDoListItems.notify();
            Toast.makeText(mcontext, "Item Done.....", Toast.LENGTH_LONG).show();
            break;
        }

       default:
           if(MainActivity.flag==false)
               holder.imageView2.setImageResource(images[1]);
           notifyItemInserted(position);
           notifyDataSetChanged();
            //below is the syntax to remove the row record
           /* mToDoListItems.remove(position);
            notifyItemRemoved(position);
            notifyItemChanged(position, mToDoListItems.size());
            // mToDoListItems.notify();
            Toast.makeText(mcontext, "Item Removed......", Toast.LENGTH_LONG).show();
            break;*/
        }

    }

  });
    }

    @Override
    public int getItemCount() {
        return mToDoListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public Button button3;
       // public ImageView imageView1;
        public ImageView imageView2;
public ViewHolder(@NonNull View itemView){
      super(itemView);
      textView=itemView.findViewById(R.id.list_item_string);
      button3 = itemView.findViewById(R.id.button3);
    imageView2 = itemView.findViewById(R.id.imageView2);


    }

    }
}



