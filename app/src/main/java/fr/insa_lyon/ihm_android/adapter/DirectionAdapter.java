package fr.insa_lyon.ihm_android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.insa_lyon.ihm_android.R;
import fr.insa_lyon.ihm_android.model.Direction;

import static android.support.constraint.Constraints.TAG;

public class DirectionAdapter extends RecyclerView.Adapter<DirectionAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View directionView = inflater.inflate(R.layout.item_direction, viewGroup, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(directionView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Direction dir = directions.get(i);
        Log.d(TAG, "onBindViewHolder: "+dir);
        TextView textView = viewHolder.start;
        textView.setText(dir.getStart());
        textView = viewHolder.end;
        textView.setText(dir.getEnd());
        textView = viewHolder.numberPerson;
        textView.setText(Integer.toString(dir.getNumberPerson()));
        textView = viewHolder.date;
        textView.setText(dir.getFormtedDate());
    }

    @Override
    public int getItemCount() {
        return directions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView start;
        public TextView end;
        public TextView numberPerson;
        public TextView date;

        public ViewHolder(View itemView)
        {
            super(itemView);

            start = (TextView) itemView.findViewById(R.id.startText);
            end = (TextView) itemView.findViewById(R.id.endText);
            numberPerson = (TextView) itemView.findViewById(R.id.nbPersonText);
            date = (TextView) itemView.findViewById(R.id.dateText);
        }
    }

    private List<Direction> directions;

    public DirectionAdapter(List<Direction> directions) {
        this.directions = directions;
    }
}
