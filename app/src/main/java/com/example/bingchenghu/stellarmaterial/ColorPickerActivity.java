package com.example.bingchenghu.stellarmaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;
import com.sansi.stellarWiFi.util.L;

public class ColorPickerActivity extends AppCompatActivity implements ColorPicker.OnColorChangedListener {
    private SVBar svBar;
    private OpacityBar opacityBar;
    private Button button;
    private TextView text;
    private ColorPicker picker;
    SaturationBar saturationBar;
    ValueBar valueBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        picker = (ColorPicker) findViewById(R.id.picker);
        svBar = (SVBar) findViewById(R.id.svbar);
        opacityBar = (OpacityBar) findViewById(R.id.opacitybar);
        button = (Button) findViewById(R.id.button1);
        text = (TextView) findViewById(R.id.textView1);

        saturationBar = (SaturationBar) findViewById(R.id.saturationbar);
        valueBar = (ValueBar) findViewById(R.id.valuebar);

        picker.addSVBar(svBar);
        picker.addOpacityBar(opacityBar);
        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);
        picker.setOnColorChangedListener(this);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int i =picker.getColor();
                text.setTextColor(picker.getColor());
                text.setText(Integer.toHexString(i).toUpperCase());
                picker.setOldCenterColor(picker.getColor());
            }
        });
    }


    @Override
    public void onColorChanged(int color) {
    }
}
