package com.wodongx123.startactivitydemo.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.wodongx123.startactivitydemo.R;
import com.wodongx123.startactivitydemo.test2.Main2Activity;

/**
 * 查看各个按钮对应的方法
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                explicitStart();
                break;
            case R.id.btn2:
                implicitStart();
                break;
            case R.id.btn3:
                implicitStartDefault();
                break;
            case R.id.btn4:
                startActivity(new Intent(this, Main2Activity.class));
                break;
        }
    }

    /**
     * 显式启动Activity
     * 注释掉其中两个类型后运行查看结果
     */
    private void explicitStart() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

        // 第一个参数是包名，第二个参数是包下的类名。包名可以直接用getPackageName()方法代替，也可以直接输入当前包的环境
        ComponentName c = new ComponentName("com.wodongx123.startactivitydemo", "com.wodongx123.startactivitydemo.test1.SecondActivity");
        //ComponentName c = new ComponentName(getPackageName(), getPackageName() + ".SecondActivity");
        //ComponentName c = new ComponentName(getApplicationContext(), getPackageName() + ".SecondActivity");
        Intent intent1 = new Intent();
        intent1.setComponent(c);
        startActivity(intent1);


        // 第一个参数是包名，第二个参数是包下的类名。包名可以直接用getPackageName()方法代替，也可以直接输入当前包的环境
        Intent intent2 = new Intent();
        intent2.setClassName("com.wodongx123.startactivitydemo", "com.wodongx123.startactivitydemo.test1.SecondActivity");
        //intent2.setClassName(getApplicationContext(), "com.wodongx123.startactivitydemo.test1.SecondActivity");
        startActivity(intent2);
    }

    /**
     * 隐式启动Activity
     * 不出意外会成功启动SecondActivity(查看AndroidManifest.xml中SecondActivity的Intent Filter内容)
     */
    private void implicitStart() {
        Intent intent = new Intent();
        intent.setAction("a");
        intent.addCategory("b");
        startActivity(intent);
    }

    /**
     * 隐式启动系统默认的Activity（打电话）
     */
    private void implicitStartDefault() {
        String tel = "110";
        //隐式调用，第一个参数是Action，第二个参数是data
/*        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel));
        startActivity(intent);*/

        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
        startActivity(intent1);
    }
}