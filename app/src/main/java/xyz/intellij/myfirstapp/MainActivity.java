package xyz.intellij.myfirstapp;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener {

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Spinner spinner = (Spinner)findViewById(R.id.spinner);
//        String[] city = new String[]{"北京","上海","南昌","保定","武汉"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city);
//        spinner.setAdapter(adapter);
//    }
    //定义字符串，用来保存各个信息
    private String phone_str = "";
    private String paswd_str = "";
    //默认男性被选中
    private String sex_str = "男性";
    private String hobby_str = "1";
    private String city_str = "";
    //组件定义
    EditText phone_edit, paswd_edit;
    RadioGroup sex_group;
    RadioButton nan_but, nv_but;
    CheckBox play, read, music;
    Button register;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //组件初始化
        phone_edit = (EditText) findViewById(R.id.phonenum);
        paswd_edit = (EditText) findViewById(R.id.passwdin);
        sex_group = (RadioGroup) findViewById(R.id.sex);
        //添加监听事件
        sex_group.setOnCheckedChangeListener(this);
        nan_but = (RadioButton) findViewById(R.id.gender_male);
        read = (CheckBox) findViewById(R.id.reading_like);
        play = (CheckBox) findViewById(R.id.play_ball);
        music = (CheckBox) findViewById(R.id.like_music);
        register = (Button) findViewById(R.id.register);
        //添加监听事件
        register.setOnClickListener(this);
        spinner = (Spinner) findViewById(R.id.spinner);
        final String[] citys = new String[]{"北京", "上海", "南昌", "保定", "武汉"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, citys);
        spinner.setAdapter(adapter);
        //城市下拉列表添加监听事件
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city_str = citys[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                //获取手机号和密码
                phone_str = phone_edit.getText().toString();
                paswd_str = paswd_edit.getText().toString();
                //获取兴趣爱好（复选框）
                hobby_str = "";
                if (read.isChecked()) {
                    hobby_str += read.getText().toString();

                }
                if (play.isChecked()) {
                    hobby_str += play.getText().toString();
                }
                if (music.isChecked()) {
                    hobby_str += music.getText().toString();
                }
                Intent intent = new Intent(this, showInfo.class);
                Bundle bundle = new Bundle();
                bundle.putString("phone", phone_str);
                bundle.putString("passwd", paswd_str);
                bundle.putString("sex", sex_str);
                bundle.putString("hobby", hobby_str);
                bundle.putString("city", city_str);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup,@IdRes int i) {
        //根据用户选择来改变sex_str的值
        sex_str=i==R.id.gender_male?"男性":"女性";
    }
}
