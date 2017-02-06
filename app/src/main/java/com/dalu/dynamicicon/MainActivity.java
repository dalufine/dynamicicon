package com.dalu.dynamicicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ComponentName mDefault;
    private ComponentName mDouble6;
    private ComponentName mDouble10;
    private PackageManager mPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDefault = getComponentName();
        mDouble6 = new ComponentName(
                getBaseContext(),
                "com.dalu.dynamicicon.icon6");
        mDouble10 = new ComponentName(
                getBaseContext(),
                "com.dalu.dynamicicon.icon10");
        mPm = getApplicationContext().getPackageManager();
    }

    public void changeIcon6(View view) {
        disableComponent(mDefault);
        disableComponent(mDouble10);
        enableComponent(mDouble6);
    }

    public void changeIcon10(View view) {
        disableComponent(mDefault);
        disableComponent(mDouble6);
        enableComponent(mDouble10);
    }

    private void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}