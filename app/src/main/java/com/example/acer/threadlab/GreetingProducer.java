package com.example.acer.threadlab;

import android.app.Activity;
import android.os.Handler;
import android.widget.TextView;

public class GreetingProducer implements Runnable{

    Handler hi;
    private static final int REPETITIONS = 10;
    private static final int DELAY = 100;

    public GreetingProducer(Handler hello){
        hi=hello;
    }

    public void run(){
        try {
            for (int i=1; i<=REPETITIONS; i++){
                hi.sendEmptyMessage(0);

                //System.out.print(i+ ": " + greeting);
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException exception){

        }
    }

}
