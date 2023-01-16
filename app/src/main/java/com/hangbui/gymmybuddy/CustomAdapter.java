package com.hangbui.gymmybuddy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amplifyframework.datastore.generated.model.Category;
import com.amplifyframework.datastore.generated.model.Exercise;
import com.amplifyframework.datastore.generated.model.ExerciseCategory;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Exercise> exercises;

    public CustomAdapter(Context context, List<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }
    @Override
    public int getCount() {
        return exercises.size();
    }

    @Override
    public Object getItem(int position) {
        return exercises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_exercises_row, parent, false);
        }
        Exercise exercise = exercises.get(position);
        Log.i("CustomAdapter", exercise.getExerciseName());
        TextView exerciseName = convertView.findViewById(R.id.textView_exercise_name);
        TextView category = convertView.findViewById(R.id.textView_category);

        exerciseName.setText(exercise.getExerciseName().toUpperCase());
        List<String> categories = new ArrayList<>();
        if(exercise.getCategory() != null) {
            for (ExerciseCategory c : exercise.getCategory()) {
                if (c != null) {
                    categories.add(c.getCategory().getCategoryName());
                }
            }
        }
        category.setText(String.join(" | ", categories));

        return convertView;
    }
}
