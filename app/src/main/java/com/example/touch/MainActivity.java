package com.example.touch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,View.OnTouchListener {
    TextView txv;
    ImageView img;
    GestureDetector gd;
    int PictureNo, TotalPictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv = (TextView) findViewById(R.id.txv);
        img = (ImageView) findViewById(R.id.img);
        gd = new GestureDetector(this, this);
        img.setOnTouchListener(this);
        PictureNo = 0;
        TotalPictures = 4;


    }
    /*
    public boolean onTouchEvent (MotionEvent event){
        //txv.setText(String.valueOf(event.getX())+ "\n" +String.valueOf(event.getY()));
        gd.onTouchEvent(event);
        return true;
    }
*/

    @Override
    public boolean onDown(MotionEvent e) {
        //txv.setText("觸控螢幕開始");
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {
        //txv.setText("觸控後無後續動作");
    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        //txv.setText("短按螢幕");
        PictureNo = 0;
        img.setImageResource(R.drawable.pu0);
        return false;
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //txv.setText("持續移動\nx1y1:" + String.valueOf(e1.getX()) + ", " + String.valueOf(e1.getY()) + "\nx2y2:" + String.valueOf(e2.getX()) + "," + String.valueOf(e2.getY()));
        return false;
    }
    @Override
    public void onLongPress(MotionEvent e) {
        // txv.setText("長按螢幕");
        PictureNo = TotalPictures - 1;
        img.setImageResource(R.drawable.pu3);
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //txv.setText("快速滑動\nx1y1:" + String.valueOf(e1.getX()) + "," + String.valueOf(e1.getY())
        //        + "\nx2y2:" + String.valueOf(e2.getX()) + "," + String.valueOf(e2.getY())
        //        + "\nX軸Y軸速度:" + String.valueOf(velocityX) + "," +  String.valueOf(velocityY));
        if (e1.getX()<e2.getX()){  //向右滑動
            PictureNo++;
            if (PictureNo==TotalPictures){  PictureNo = 0;  }
        }
        else{     //向左滑動
            PictureNo--;
            if (PictureNo<0){  PictureNo = TotalPictures-1; }
        }
        ShowPicture();
        return false;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gd.onTouchEvent(event);
        return true;
    }
    public void ShowPicture(){
        switch (PictureNo){
            case 0: { img.setImageResource(R.drawable.pu0); break;}
            case 1: { img.setImageResource(R.drawable.pu1); break;}
            case 2: { img.setImageResource(R.drawable.pu2); break;}
            case 3: { img.setImageResource(R.drawable.pu3); break;}
        }
    }
}