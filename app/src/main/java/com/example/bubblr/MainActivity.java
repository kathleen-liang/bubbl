package com.example.bubblr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.io.*;


public class MainActivity extends AppCompatActivity {

    private static ArrayList<BubbleTea> b1 = new ArrayList<>();
    private static ArrayList<String> snames1 = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapter;
    private int i;

    protected static void readFile() {

    }

    protected static void createBubbleTea(String name, String homestore, String bio, String profilePic) {
        BubbleTea tea = new BubbleTea(name, homestore, bio, profilePic);
        b1.add(tea);
    }


    protected static void createSnames(ArrayList<BubbleTea> b1) {
        for (int k = 0; k < b1.size(); k++) {
            snames1.add(b1.get(k).getName());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1.add(new BubbleTea("Karen", "Starbucks", "I only date men who are above 6 ft, have a little something that's longer than 6 inches, and earn more than 6 figures. Haha 666, I'm such a wild girl! I also like to travel and read.", "karen"));
        b1.add(new BubbleTea("Jennifer", "Kung Fu Tea", "Down to party!!! Let's get together and have some funnnn \uD83D\uDE09", "jennifer"));
        b1.add(new BubbleTea("Emma", "Coco's", "I take hot showers because I like burning in hell. Let's be miserable together!", "emma"));
        b1.add(new BubbleTea("Xinyi", "Gong Cha", "Hello! I am from District 32, Qingdao, Shandong, China. Nice to meet you! I want a nice guy to take home to my parents.", "xinyi"));
        b1.add(new BubbleTea("Vicky", "The Alley", "I'm very important. I was the student council president in my high school and graduated with the top mark in the school. I'm looking for a long-term relationship. Preferably with someone in the top 2% of their cohort.", "vicky"));
        b1.add(new BubbleTea("Amy", "Sweet Dreams", "Loves K-dramas and K-pop. Looking for a [adj] oppa who will saranghae me ❤", "amy"));
        b1.add(new BubbleTea("Chad", "ThirsTEA",
                "\uD83D\uDE09 \uD83D\uDE09 \uD83D\uDE09 Hey there cutie. I can show you a good time.", "chad"));
        b1.add(new BubbleTea("Jake", "Sweet Dreams", "Tapioca. Cats. Chilling. Tattoos. Tapioca. Photography. Travelling. Good vibes. Did I mention tapioca? Tapioca. Let's eat!", "jake"));
        b1.add(new BubbleTea("Samayamantri Venkata Rama Krishna", "Sharetea", "Brampton boi. My friends call me Krishna. \uD83D\uDE09", "krishna"));
        b1.add(new BubbleTea("Victor", "Real Fruit Bubble Tea", "Organic, low-fat, 100% authentic, born in Vancouver and raised by the world. Travel with me! The world is my gym.", "victor"));
        b1.add(new BubbleTea("Zhang Wei", "OneZo", "I can show you good time.", "zhangwei"));
        b1.add(new BubbleTea("Beckett", "Labothery", "I only drink self made cold brew coffee, with no sugar because that's capitalism, but you can be the sweetie in my life. I also enjoy spontaneously backpacking europe, and once, i didn't produce any garbage at all! Hmu if you want a breathe of fresh air!", "beckett"));
        b1.add(new BubbleTea("Andrew", "Chatime", "Add me as a friend on OSU!*/", "andrew"));


        createSnames(b1);

        if(b1.isEmpty()){
            Log.d("problem with null", "b1 is empty");
        }

        if(snames1.isEmpty()){
            Log.d("problem with null", "snames1 is empty");
        }

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.name, snames1);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                snames1.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                Toast.makeText(MainActivity.this, "Sorry, you're alone.", Toast.LENGTH_SHORT).show();
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {

            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
