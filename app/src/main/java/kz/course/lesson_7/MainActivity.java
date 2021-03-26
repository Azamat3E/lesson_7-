package com.example.new_lesson_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView androidPhone, iOsPhone;
    RadioButton cardRadio,numberRadio;
    CheckBox trainCheckbox, planeCheckbox;
    Button deliveryBtn;

    String tolemTyri, deliveryType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidPhone = findViewById(R.id.androidPhone);
        iOsPhone = findViewById(R.id.iOsPhone);

        cardRadio = findViewById(R.id.cardRadio);
        numberRadio = findViewById(R.id.numberRadio);

        trainCheckbox = findViewById(R.id.trainCheckbox);
        planeCheckbox = findViewById(R.id.planeCheckbox);

        deliveryBtn = findViewById(R.id.deliveryBtn);

        registerForContextMenu(androidPhone);
        registerForContextMenu(iOsPhone);

        deliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardRadio.isChecked()){
                    tolemTyri = "Paying by card";
                }else{
                    tolemTyri = "Paying by number";
                }
                if(trainCheckbox.isChecked()){
                    deliveryType = "Delivering by train";
                }
                if(planeCheckbox.isChecked()){
                    deliveryType = "Delivering by plane";
                }

                String result = "Android: " + androidPhone.getText()+"\n"+
                        "iOs: "+ androidPhone.getText()+"\n"+
                        "Paying type: " + tolemTyri+"\n"+
                        "Delivering type: "+ deliveryType;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v == androidPhone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        else if(v == iOsPhone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.samsungPhone:
                androidPhone.setText("Samsung");
                break;
            case R.id.mi9Phone:
                androidPhone.setText("mi9");
                break;
            case R.id.xiaomiPhone:
                androidPhone.setText("Xiaomi");
                break;
            case R.id.huaweiPhone:
                androidPhone.setText("Huawei");
                break;

            case R.id.iPhone:
                iOsPhone.setText("iPhone");
                break;
            case R.id.iPad:
                iOsPhone.setText("iPad");
                break;
            case R.id.iMac:
                iOsPhone.setText("iMac");
                break;
            case R.id.airPods:
                iOsPhone.setText("airPods");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this, "Settings menu clicked", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu clicked", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_save:
                Toast.makeText(this, "Save menu clicked", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu clicked", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}