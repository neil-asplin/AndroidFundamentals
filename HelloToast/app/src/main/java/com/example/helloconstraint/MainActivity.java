package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mButtonCount = (Button) findViewById(R.id.button_count);
        ((Button) findViewById(R.id.zero_button)).setEnabled(false);

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }


        ((Button) findViewById(R.id.zero_button)).setEnabled(true);

        if (mCount % 2 == 0){
            Log.d("myTag", "countUp: even");
            ViewCompat.setBackgroundTintList(
                    view,
                    ContextCompat.getColorStateList(
                            getApplicationContext(),
                            R.color.purple_200
                    )
            );
            view.setBackgroundColor(getResources().getColor(R.color.purple_200));
        } else {
            ViewCompat.setBackgroundTintList(
                    view,
                    ContextCompat.getColorStateList(
                            getApplicationContext(),
                            R.color.teal_200
                    )
            );
            view.setBackgroundColor(getResources().getColor(R.color.teal_200));
        }


    }

    public void zeroCount(View view) {
        mCount = 0;
        ((Button) findViewById(R.id.zero_button)).setEnabled(false);
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}