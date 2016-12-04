package com.example.demo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demo.myapplication.Components.Interface.DBCommunicator;
import com.example.demo.myapplication.Components.Interface.UserService;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, DBCommunicator
{
    private Button b_logout;

    private ListView listView;
    private List<String> listData;

    private MainController mMainController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // setting button
        b_logout = (Button) findViewById(R.id.b_logout);
        b_logout.setOnClickListener(this);

        // setting list
        listView = (ListView) findViewById(R.id.l_course);
        listData = new ArrayList<String>();

        // getting data from DB
        mMainController = new MainController(this);
        mMainController.getCourseList();

        // setting list adapter
        listView.setAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, listData));
        listView.setOnItemClickListener(list_item_onClick);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.b_logout:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                break;
        }
    }

    public void onResultReceived(String text)
    {
        text = "COMP3006 Software Engineering<br>COMP3005 Design and Analysis of Algorithms<br>MATH1005 Calculus<br>MATH1205 Discrete Mathematics<br>...<br>...<br>...<br>...<br>...<br>...<br>...<br>...<br>";

        listData = processData(text);
    }

    public void onErrorReceived(String text)
    {
        Toast.makeText(getApplicationContext(), "Error: " + text, Toast.LENGTH_LONG).show();
    }

    public List<String> processData(String rawData)
    {
        final String divider = "<br>";

        List<String> ld = new ArrayList<String>();
        String temp = "";

        for(int i=0; i<rawData.length(); ++i)
        {
            if(i+divider.length()-1 < rawData.length() && rawData.substring(i,i+divider.length()).equals(divider))
            {
                ld.add(temp);
                temp = "";
                i+=divider.length()-1;
            }
            else
            {
                temp += rawData.charAt(i);
            }
        }
        if(!temp.isEmpty()) ld.add(temp);

        return ld;
    }


    private ListView.OnItemClickListener list_item_onClick = new ListView.OnItemClickListener()
    {
        public void onItemClick(AdapterView parent, View view, int position, long id)
        {
            Object o = listView.getItemAtPosition(position);

            Intent intent = new Intent(HomeActivity.this, CourseInfoActivity.class);
            intent.putExtra("course", listData.get(position));

            startActivity(intent);
        }
    };
}

