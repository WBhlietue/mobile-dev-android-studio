package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.telephony.SignalStrengthUpdateRequest;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Lab3_1 extends AppCompatActivity {

    ImageButton im1, im2, im3, im4, im5, im6;
    View graphicView;
    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;
    static boolean blur = false;
    static boolean embos = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab31);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        LinearLayout picLinear =  findViewById(R.id.picLayout);
        graphicView =  new MyGraphicView(this);
        picLinear.addView(graphicView);
        clickIcons();
    }
    private void clickIcons() {
        im1 = (ImageButton) findViewById(R.id.ib1);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate(); }
        });
        im2 = (ImageButton) findViewById(R.id.ib2);
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate(); }
        });
        im3 = (ImageButton) findViewById(R.id.ib3);
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                satur = satur + 0.2f;
//                if(satur > 1){
//                    satur = 1;
//                }
                graphicView.invalidate(); }
        });
        im4 = (ImageButton) findViewById(R.id.ib4);
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                satur = satur - 0.2f;
//                if(satur < 0){
//                    satur = 0;
//                }
                graphicView.invalidate(); }
        });
        im5 = (ImageButton) findViewById(R.id.ib5);
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle + 20;
                graphicView.invalidate(); }
        });
        im6 = (ImageButton) findViewById(R.id.ib6);
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(satur==0)
                    satur=1;
                else
                    satur=0;
                graphicView.invalidate();
            }

        });
    }
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context)
        {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY,cenX, cenY);
            canvas.rotate(angle, cenX, cenY);
            Paint paint = new Paint();
            ColorMatrix cm = new ColorMatrix();
            cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            if (blur == true)
            {
                BlurMaskFilter bMask;
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(bMask);
            }
            Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.qwe);
            int picX = (this.getWidth() - pic.getWidth()) / 2;
            int picY = (this.getHeight() - pic.getHeight()) / 2;
            canvas.drawBitmap(pic, picX, picY, paint);
            pic.recycle();
        }
    }
}