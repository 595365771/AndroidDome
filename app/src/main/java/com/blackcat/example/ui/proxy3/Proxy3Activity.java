package com.blackcat.example.ui.proxy3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blackcat.example.R;
import com.blackcat.example.ui.proxy2.Man;
import com.blackcat.example.ui.proxy2.Subject;

public class Proxy3Activity extends AppCompatActivity {
    private Button btn_proxy3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy3);
        initView();
        initListener();
    }

    private void initView() {
        btn_proxy3 = (Button) findViewById(R.id.btn_proxy3);
    }

    private void initListener() {
        btn_proxy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxy3Test();
            }
        });
    }

    private void proxy3Test() {
        Subject target = new Man();
        try {
            Subject subject = (Subject) MyProxyFactory.getProxy(target);
            subject.info();
            subject.shopping();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
