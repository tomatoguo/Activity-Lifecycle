package com.guoyonghui.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * AnotherActivity
 *
 * @author Tomato Guo
 */
public class AnotherActivity extends Activity {

    public static final String ACTION_ANOTHER_ACTIVITY = "com.guoyonghui.activitylifecycle.ACTION_ANOTHER_ACTIVITY";

    public static final String CATEGORY_ANOTHER_ACTIVITY = "com.guoyonghui.activitylifecycle.CATEGORY_ANOTHER_ACTIVITY";

    private static final String TAG = "Activity_Lifecycle_" + AnotherActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Log.d(TAG, "In AnotherActivity, onCreate() called.");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "In AnotherActivity, onStart() called.");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "In AnotherActivity, onResume() called.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "In AnotherActivity, onPause() called.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "In AnotherActivity, onStop() called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "In AnotherActivity, onDestroy() called.");
    }

}
