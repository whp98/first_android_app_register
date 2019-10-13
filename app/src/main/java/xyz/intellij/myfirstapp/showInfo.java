package xyz.intellij.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class showInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String phone = bundle.getString("phone");
        String paswd = bundle.getString("passwd");
        String sex = bundle.getString("sex");
        String hobby = bundle.getString("hobby");
        String city = bundle.getString("city");
        TextView show_text = (TextView)findViewById(R.id.show_content);
        show_text.setText("手机号是："+phone+"\n" +
                "密码是："+paswd+"\n"+
                "性别是："+sex+"\n" +
                "爱好是："+hobby+"\n" +
                "城市是："+city+"\n");
    }
}
