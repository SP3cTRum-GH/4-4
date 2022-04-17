package com.cookandroid.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch swAgree;
    RadioGroup rGroup1;
    RadioButton rdoPie, rdoQ, rdoR;
    Button btnExit,btnReset;
    ImageView imgAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        //id연결
        text1 = (TextView) findViewById(R.id.Text1);
        swAgree = (Switch) findViewById(R.id.SwAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoPie= (RadioButton) findViewById(R.id.rdoPie);
        rdoQ = (RadioButton) findViewById(R.id.rdoQ);
        rdoR = (RadioButton) findViewById(R.id.rdoR);

        imgAndroid = (ImageView) findViewById(R.id.ImgAndroid);

        btnExit = (Button) findViewById(R.id.BtnExit);
        btnReset = (Button) findViewById(R.id.BtnReset);

        //체크박스 체크시 VISIBLE로 상태변경
        swAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(swAgree.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                    btnExit.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                } else
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                    btnExit.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                }
            }
        });

        //클릭한 안드로이드 버전의 사진을 출력
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(rGroup1.getCheckedRadioButtonId()){
                    case R.id.rdoPie:
                        imgAndroid.setImageResource(R.drawable.pie);
                        break;
                    case R.id.rdoQ:
                        imgAndroid.setImageResource(R.drawable.q10);
                        break;
                    case R.id.rdoR:
                        imgAndroid.setImageResource(R.drawable.r11);
                        break;
                }
            }
        });

        //종료버튼
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);}
        });
        //초기화 버튼
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swAgree.setChecked(false);
                rdoPie.setChecked(false);
                rdoQ.setChecked(false);
                rdoR.setChecked(false);
                imgAndroid.setImageResource(0);

                Toast.makeText(getApplicationContext(),"초기화 합니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}