package com.guoyonghui.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * MainActivity
 *
 * @author Tomato Guo
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "Activity_Lifecycle_" + MainActivity.class.getName();

    private static final String EXTRA_COUNTER = "com.guoyonghui.activitylifecycle.EXTRA_COUNTER";

    private int mCounter = 0;

    private Button mStartAnotherActivityExplicitlyButton;

    private Button mStartAnotherActivityImplicitlyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "In MainActivity, onCreate() called.");

        if(savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(EXTRA_COUNTER, -1);
        }

        Log.d(TAG, "counter = " + mCounter);

        initViews();

        initEvents();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "In MainActivity, onStart() called.");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "In MainActivity, onResume() called.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "In MainActivity, onPause() called.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "In MainActivity, onStop() called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "In MainActivity, onDestroy() called.");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "In MainActivity, onSaveInstanceState() called.");

        mCounter++;

        outState.putInt(EXTRA_COUNTER, mCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "In MainActivity, onRestoreInstanceState() called.");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.start_another_activity_explicitly:
                Log.d(TAG, "In MainActivity, start another activity explicitly.");

                Intent explicitIntent = new Intent(MainActivity.this, AnotherActivity.class);

                startActivity(explicitIntent);
                break;
            case R.id.start_another_activity_implicitly:
                Log.d(TAG, "In MainActivity, start another activity implicitly.");

                Intent implicitIntent = new Intent();

                implicitIntent.setAction(AnotherActivity.ACTION_ANOTHER_ACTIVITY);

                implicitIntent.addCategory(AnotherActivity.CATEGORY_ANOTHER_ACTIVITY);
//              implicitIntent.addCategory(Intent.CATEGORY_DEFAULT);

                startActivity(implicitIntent);
                break;

            default:
                break;
        }
    }

    private void initViews() {
        mStartAnotherActivityExplicitlyButton = (Button) findViewById(R.id.start_another_activity_explicitly);

        mStartAnotherActivityImplicitlyButton = (Button) findViewById(R.id.start_another_activity_implicitly);
    }

    private void initEvents() {
        mStartAnotherActivityExplicitlyButton.setOnClickListener(this);

        mStartAnotherActivityImplicitlyButton.setOnClickListener(this);
    }
}
