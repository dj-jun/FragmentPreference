package com.example.administrator.fragmentpreference;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PreFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从xml文件中加载选项
        addPreferencesFromResource(R.xml.preference);
    }
}
