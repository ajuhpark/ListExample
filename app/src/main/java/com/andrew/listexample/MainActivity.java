package com.andrew.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create an array or a list
        String[] foods = {"Bacon", "Ham", "Tuna", "Candy", "Meatball", "Potato"};

        /*
        we need an adapter to convert java code to list items
        The ListAdapter is going to be responsible for taking in an array. That's
        why it's called an ArrayAdapter.  It will convert it into list items.
        "android.R.layout" is how you want your list formatted.
        "simple list item" is like the basic list format.
        then we have the array, "foods".
         */
        ListAdapter andrewsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, foods);

        /*
        - get a reference to the list by creating a ListView
        - (ListView) typecasts it into a listview.
        - andrewsListView is in the activity main.
        */
        ListView andrewsListView = (ListView) findViewById(R.id.andrewsListView);

        /*
        - set the adapter to the listview to andrewsAdapter.
        - so it's trying to convert the foods array to list items
        */
        andrewsListView.setAdapter(andrewsAdapter);

        //setting up a listener so it's ready to listen to a click
        //this is a test change for github
        andrewsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        /*
                        this is getting the value of the position and converting
                        it to a string. When we click on bacon or ham, it's going to
                        store it into the variable food.
                         */
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        //then we're showing it as a toast on the screen.
                        Toast.makeText(MainActivity.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}
