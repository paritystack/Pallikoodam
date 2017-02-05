package in.paritystack.pallikoodam;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener{
    char c = 'A';
    private GestureDetectorCompat mDetector;
    String DEBUG_TAG = "Manu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //char[] alphabets = a.toCharArray();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changeAlphabet();

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);

    }
    public void changeAlphabet(boolean direction) {

        if (direction){
            c++;
            if(c > 'Z') {
                //Reset
                c = 'A';
            }
        }
        else {
            c--;
            if(c < 'A') {
                //Reset
                c = 'Z';
            }
        }

        String s = String.valueOf(c);
        //Log.d(DEBUG_TAG, "Writing " + s);
        TextView t = (TextView) findViewById(R.id.alphabet);
        t.setText(s);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //changeAlphabet();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        float x1 = e1.getX();
        float x2 = e2.getX();
        boolean forward = true;
        if (Math.abs((x1-x2)) > 150) {
            if (x1 > x2) {
                forward = true;
            } else {
                forward = false;
            }

            changeAlphabet(forward);
        }
        return false;
    }




/* Manu - This is the raw touch events.
    // This example shows an Activity, but you would use the same approach if
// you were subclassing a View.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        changeAlphabet();
        return super.onTouchEvent(event);



        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG, "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(DEBUG_TAG, "Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                return super.onTouchEvent(event);
        }

    } */
}

