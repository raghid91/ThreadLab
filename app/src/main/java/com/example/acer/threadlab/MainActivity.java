package com.example.acer.threadlab;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    TextView text;
    Runnable r1, r2;
    Thread t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.Text);
        r1 = new GreetingProducer(threadHandler);
        r2 = new GreetingProducer(thread2Handler);

        t1 = new Thread(r1);
        t2 = new Thread(r2);
    }

    protected void goStart(View view){
        t1.start();
        t2.start();
    }

    protected void goStop(View view){
        t1.interrupt();
        t2.interrupt();
    }

    Handler threadHandler = new Handler(){
        public void handleMessage(android.os.Message message){
            text.setText(text.getText() + "Hello World! \n");
        }
    };

    Handler thread2Handler = new Handler(){
        public void handleMessage(android.os.Message message){
            text.setText(text.getText() + "Goodbye World! \n");
        }
    };


}
