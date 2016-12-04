package com.example.demo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class CourseInfoActivity extends AppCompatActivity {
    private TextView textView_course_info;
    private ListView listView_section_info;
    private ListView listView_comment;

    private List<String> sections;
    private List<String> comments;

    private static Button buttonRate;
    private static TextView textView;
    private static RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        textView_course_info = (TextView) findViewById(R.id.textView_course_info);
        listView_section_info = (ListView) findViewById(R.id.listView_section_info);
        listView_comment = (ListView) findViewById(R.id.listView_comment);

        listenerForRatingBar();
        onButtonClickListener();

        set_data();
    }

    public void listenerForRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        textView = (TextView) findViewById(R.id.text_view);
        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        textView.setText(String.valueOf(v));
                    }
                }
        );
    }

    public void onButtonClickListener() {
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        buttonRate = (Button) findViewById(R.id.button_rate);
        buttonRate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(CourseInfoActivity.this,
                                String.valueOf(ratingBar.getRating()),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void set_data()
    {
        //CODE TO PROCESS COURSE INFO
        sections = new ArrayList<String>();
        comments = new ArrayList<String>();
        sections.add("Section: 50\nLecturer: Mr. Wong\nTime: 15:00-16:00(Mon), 08:00-10:00(Tsu)");
        sections.add("Section: 51\nLecturer: Mr. Li\nTime: 15:00-16:00(Wed), 09:00-11:00(Tsu)");
        comments.add(">Samuel\nGreat!");
        comments.add(">Samuel\nCool!");
        comments.add(">Samuel\nGood Course.");
        comments.add(">Samuel\nGreat!");
        comments.add(">Samuel\nCool!");
        comments.add(">Samuel\nGood Course.");

//        textView_course_info.setText(getString(R.string.course_code) + course.code + '\n' +
//                getString(R.string.course_title) + course.title + '\n' +
//                getString(R.string.course_unit) + course.unit + '\n' +
//                getString(R.string.course_level) + course.level + '\n' +
//                getString(R.string.course_moi) + course.moi );
//
//
//        // Defined Array values to show in ListView
//        List<String> sections = new ArrayList<String>();
//        List<String> comments = new ArrayList<String>();
//
//        for (int i = 0; i < course.sections.size(); i++)
//        {
//            sections.add(getString(R.string.course_sec_section) + course.sections.get(i).sectionNo + '\n' +
//                    getString(R.string.course_sec_lecturer) + course.sections.get(i).lecturer + '\n' +
//                    getString(R.string.course_sec_time) + course.sections.get(i).startTime + " - " + course.sections.get(i).endTime);
//        }
//
//        for (int i = 0; i < course.comments.size(); i++)
//        {
//            comments.add(course.comments.get(i).username + '\n' +
//                    course.sections.get(i).comment);
//        }

        // setting list adapter
        ArrayAdapter<String> adapterSec = new ArrayAdapter<String>(this, R.layout.list_item_section, R.id.textView_section_info, sections);
        listView_section_info.setAdapter(adapterSec);

        ArrayAdapter<String> adapterCom = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comments);
        listView_comment.setAdapter(adapterCom);
    }
}
