package com.example.app_lab_1021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private Button send_btn;
    private EditText set_drink;
    private RadioGroup rg_sugar,rg_ice;

    private  String sugar="無糖";
    private String ice="去冰";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg_sugar=findViewById(R.id.rg_sugar);
        rg_sugar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radiogroup, int  i) {
                switch(i){
                    case R.id.btn_sugar_no:
                        sugar="無糖";
                        break;
                    case R.id.btn_sugar_low:
                        sugar="少糖";
                        break;
                    case R.id.btn_sugar_half:
                        sugar="半糖";
                        break;
                    case R.id.btn_sugar_normal:
                        sugar="全糖";
                        break;
                }
            }
        });


        rg_ice=findViewById(R.id.rg_ice);
        rg_ice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radiogroup, int i) {
                switch(i){
                    case R.id.btn_ice_no:
                        ice="去冰";
                        break;
                    case R.id.btn_ice_low:
                        sugar="微冰";
                        break;
                    case R.id.btn_ice_normal:
                        sugar="正常冰";
                        break;
                }
            }
        });

        send_btn=findViewById(R.id.btn_send);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_drink=findViewById(R.id.drink_name);
                String drink=set_drink.getText().toString();
                Intent i=new Intent();
                Bundle b=new Bundle();
                b.putString("sugar",sugar);
                b.putString("drink",drink);
                b.putString("ice",ice);
                i.putExtras(b);
                setResult(101,i);
                finish();
            }
        });

    }
}