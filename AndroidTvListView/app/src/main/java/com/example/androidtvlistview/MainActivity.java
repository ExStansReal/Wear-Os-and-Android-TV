package com.example.androidtvlistview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {


    ListView lst;
    TextView txt;
    String[] Games = {"Team Fortress 2", "DayZ", "Minecraft", "World of Tanks","Warframe","Elden Ring", "Dark Souls 1-2-3"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }
        lst = findViewById(R.id.listView);
        txt = findViewById(R.id.text);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, Games
        );
        lst.setAdapter(adapter);
        String[] slovo = {"", "", "", "","","",""};
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for(int b = 0; b < 4; b++)
                {
                    if(lst.isItemChecked(b)) {
                        slovo[b] = Games[b];
                    }
                    else
                    {
                        slovo[b] = "";
                    }
                }
                String fin = "";
                for(int b = 0; b < 4; b++)
                {
                    if(slovo[b] != "")
                    {
                        fin += "|" + slovo[b] + "|";
                    }
                }
                txt.setText(fin);
            }
        });

    }
}