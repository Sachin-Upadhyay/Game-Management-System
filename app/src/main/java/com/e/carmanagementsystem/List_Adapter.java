package com.e.carmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class List_Adapter extends ArrayAdapter<Getter> {
    List<Getter> heroList;  // declaring a list

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    public List_Adapter(Context context, int resource, List<Getter> heroList) {  // constructor that takes data
        super(context, resource, heroList);
        this.context = context;
        this.resource = resource;
        this.heroList = heroList;
    }

    //code completion method
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view

        TextView gamename = view.findViewById(R.id.game_name);
        TextView playersRequired = view.findViewById(R.id.player_required);
        TextView equipments = view.findViewById(R.id.equipment_required);
        TextView teamA = view.findViewById(R.id.teamA);
        TextView teamB = view.findViewById(R.id.teamB);
        TextView rule = view.findViewById(R.id.rules);
        TextView Description = view.findViewById(R.id.description);

        //getting the hero of the specified position
        Getter hero = heroList.get(position);

        //adding values to the list item

        gamename.setText(hero.getGamename());
        playersRequired.setText(hero.getPlayerRequired());
        equipments.setText(hero.getEquipments());
        teamA.setText(hero.getTeamA());
        teamB.setText(hero.getTeamB());
        rule.setText(hero.getRules());
        Description.setText(hero.getDescription());


        //adding a click listener to the button to remove item from the list


        //finally returning the view
        return view;
    }


}


