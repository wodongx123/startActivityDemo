package com.wodongx123.startactivitydemo.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wodongx123.startactivitydemo.R;

import java.net.URI;
import java.util.Stack;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                actionTest();
                break;
            case R.id.btn2:
                categoryTest();
                break;
            case R.id.btn3:
                //dataTest();
                dataTest1();
                break;
        }
    }



    /**
     * 测试Action的匹配规则
     * 切换不同的Aciton运行查看结果
     */
    private void actionTest() {
        Intent intent = new Intent();
        intent.setAction("test1");
        //intent.setAction("test2");
        //intent.setAction("test3");
        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, "启动Activity失败,查看logcat", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    /**
     * 测试category的匹配规则
     * 取消category2的注释后运行，然后取消category3的注释后再次运行，查看结果
     */
    private void categoryTest() {
        Intent intent = new Intent();

        intent.setAction("t");
        intent.addCategory("cate1");
        //intent.addCategory("cate2");
        //intent.addCategory("cate3");
        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, "启动Activity失败,查看logcat", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    /**
     * 测试Data的匹配规则（只设置mimeType）
     * 切换不同的mimeType运行查看结果
     */
    private void dataTest() {
        Intent intent = new Intent();
        intent.setAction("t1");
        intent.setType("image/png");
        //intent.setType("image/jpeg");
        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, "启动Activity失败,查看logcat", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    /**
     * 测试Data的匹配规则（设置mimeType和URI）
     * 切换不同的URI查看结果
     */
    private void dataTest1() {
        Intent intent = new Intent();
        intent.setAction("t2");
        intent.setDataAndType(Uri.parse("https://www.baidu.com/aaa"), "image/jpeg");
        //intent.setDataAndType(Uri.parse("https://www.tecent.com/aaa"), "image/jpeg");
        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, "启动Activity失败,查看logcat", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


}