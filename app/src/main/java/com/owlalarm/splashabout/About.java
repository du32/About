package com.owlalarm.splashabout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class About extends AppCompatActivity {

    TextView text;
    Animation anim;
    Animation put,out,rotat;
    Button button,facebook,twet,youtub;
    Boolean open=true;
    long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

         //ربط الانميشن مع النص
        text=(TextView)findViewById(R.id.titel);
        anim= AnimationUtils.loadAnimation(this,R.anim.mov);
        text.setAnimation(anim);

          //ربط الانميشن مع العنوان
        text=(TextView)findViewById(R.id.dev);
        anim= AnimationUtils.loadAnimation(this,R.anim.txt_mov);
        text.setAnimation(anim);



        button=(Button)findViewById(R.id.button);
        facebook=(Button)findViewById(R.id.facebook);
        twet=(Button)findViewById(R.id.twet);
        youtub=(Button)findViewById(R.id.youtub) ;



        put=AnimationUtils.loadAnimation(this,R.anim.put);
        out=AnimationUtils.loadAnimation(this,R.anim.out);
        rotat=AnimationUtils.loadAnimation(this,R.anim.rotat);






    }

//زر الرجوع الى الخلف للخروج من التطبيق
    @Override
    public void onBackPressed() {

//إذا كان الوقت في الهاتف اصغر من 3 ثواني يتم الخروج من التطبيق
        if (time+3000 > System.currentTimeMillis()){

            super.onBackPressed();

        }else {

            Toast.makeText(About.this,"إضغط مره اخرى للخروج من التطبيق",Toast.LENGTH_SHORT).show();
        }
        time= System.currentTimeMillis();
    }

    public void devClick(View view) {


        //عند الضغط للمره الاولى تظهر الايقوتات المختغية
        if (open){
            open=false;
        button.startAnimation(rotat);
        facebook.startAnimation(put);
        twet.startAnimation(put);
        youtub.startAnimation(put);

        facebook.setVisibility(View.VISIBLE);
        twet.setVisibility(View.VISIBLE);
        youtub.setVisibility(View.VISIBLE);



    }else{
            //عند الضغط للمره الثانية تختفي
            open=true;


            button.startAnimation(rotat);
            facebook.startAnimation(out);
            twet.startAnimation(out);
            youtub.startAnimation(out);

            facebook.setVisibility(View.INVISIBLE);
            twet.setVisibility(View.INVISIBLE);
            youtub.setVisibility(View.INVISIBLE);

        }


    }

}

