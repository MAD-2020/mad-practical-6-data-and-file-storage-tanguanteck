package sg.edu.np.week_6_whackamole_3_0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.logging.Level;

import androidx.recyclerview.widget.RecyclerView;

public class CustomScoreAdaptor extends RecyclerView.Adapter<CustomScoreViewHolder> {
    /* Hint:
        1. This is the custom adaptor for the recyclerView list @ levels selection page

     */
    private static final String FILENAME = "CustomScoreAdaptor.java";
    private static final String TAG = "Whack-A-Mole3.0!";
    private UserData list_members;
    private ArrayList<Integer>  level_List;
    private ArrayList<Integer> score_List;
    private Context tcontext;
    public CustomScoreAdaptor(UserData userdata, Context context){
        /* Hint:
        This method takes in the data and readies it for processing.
         */
        list_members = userdata;
        level_List = userdata.getLevels();
        score_List = userdata.getScores();
        tcontext = context;

    }

    public CustomScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        /* Hint:
        This method dictates how the viewholder layuout is to be once the viewholder is created.
         */
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_select, parent, false);
        return new CustomScoreViewHolder(item);
    }

    public void onBindViewHolder(CustomScoreViewHolder holder, final int position){

        /* Hint:
        This method passes the data to the viewholder upon bounded to the viewholder.
        It may also be used to do an onclick listener here to activate upon user level selections.

        Log.v(TAG, FILENAME + " Showing level " + level_list.get(position) + " with highest score: " + score_list.get(position));
        Log.v(TAG, FILENAME+ ": Load level " + position +" for: " + list_members.getMyUserName());
         */
        final String l = level_List.get(position).toString();
        final String s = score_List.get(position).toString();
        holder.Levels.setText("Level " + l);
        holder.Scores.setText("Highest Score " + s);

        Log.v(TAG, FILENAME + " Showing level " + level_List.get(position) + " with highest score: " + score_List.get(position));
        Log.v(TAG, FILENAME+ ": Load level " + position +" for: " + list_members.getMyUserName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tcontext, Main4Activity.class);
                tcontext.startActivity(intent);
            }
        });
    }

    public int getItemCount(){
        /* Hint:
        This method returns the the size of the overall data.
         */
        return score_List.size();
    }
}