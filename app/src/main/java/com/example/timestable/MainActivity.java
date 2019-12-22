package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mylistview;
    public void updatetimestableApp(int times_progress)
    {

        ArrayList<String>  timestablevalues= new ArrayList<String>();
        for(int i=1;i<=10;i++)
        {
            timestablevalues.add(Integer.toString(i*times_progress));
        }
        ArrayAdapter<String> marrayadapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timestablevalues);
        mylistview.setAdapter(marrayadapter);
    }
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar myseekbar=(SeekBar)findViewById(R.id.TimeTableSeekBar);

      mylistview=(ListView)findViewById(R.id.TimeTableListview);
        myseekbar.setMax(20);
        myseekbar.setProgress(10);


        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {


                int min=1;
                int timestable;
                if(progress<min)
                {
                    timestable=min;
                    myseekbar.setProgress(min);
                }
                else
                {
                    timestable=progress;
                }
              updatetimestableApp(timestable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }

        });
updatetimestableApp(10);

    }
}
