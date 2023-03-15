package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class Lab2_5 extends AppCompatActivity {
    public static  final int LINE = 1;
    public static  final int CIRCLE = 2;
    static int shape = LINE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lab25);
        setContentView(new NewView(this));

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "Drawing line");
        menu.add(0, 2, 0, "Drawing circle");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                shape = LINE;
                return true;
            case 2:
                shape = CIRCLE;
                return true;
        }
        return super.onContextItemSelected(item);
    }
    public class NewView extends View{
        int startX = -1, startY = -1, stopX = -1, stopY = -1;

        public NewView(Context context) {
            super(context);
        }
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);
            switch (shape) {
                case LINE: canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE: int radius = (int) (Math.sqrt(Math.pow(stopX-startX, 2))
                        +Math.sqrt(Math.pow(stopX-startX, 2)));
                    canvas.drawCircle(startX, startY, radius, paint); break;
            }

        }


    }
}

