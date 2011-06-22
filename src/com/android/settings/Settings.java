/*
 * Copyright (C) 2011 The SalvageMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings;

import android.os.Bundle;
import android.app.TabActivity;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.FrameLayout;
import android.widget.TabHost.TabSpec;
import android.content.Intent;
import android.content.res.Resources;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.net.sip.SipManager;
import android.view.Window;

public class Settings extends TabActivity {


public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main);

    Resources res = getResources(); // Resource object to get Drawables
    TabHost tabHost = getTabHost();  // The activity TabHost
    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
    Intent intent;  // Reusable Intent for each tab

    // Create an Intent to launch an Activity for the tab (to be reused)
    intent = new Intent().setClass(this, SettingsMain.class);

    // Initialize a TabSpec for each tab and add it to the TabHost
    spec = tabHost.newTabSpec("settings").setIndicator("Settings",
                      res.getDrawable(R.drawable.ic_tab_settings))
                  .setContent(intent);
    tabHost.addTab(spec);

    intent = new Intent();
    intent.setClassName("com.salvagemod.salvageparts", "com.salvagemod.salvageparts.activities.MainActivity");
    spec = tabHost.newTabSpec("parts").setIndicator("Parts",
                      res.getDrawable(R.drawable.ic_tab_parts))
                  .setContent(intent);
    tabHost.addTab(spec);

    intent = new Intent().setClass(this, ApplicationSettings.class);
    spec = tabHost.newTabSpec("apps").setIndicator("Apps",
                      res.getDrawable(R.drawable.ic_tab_apps))
                  .setContent(intent);
    tabHost.addTab(spec);

    intent = new Intent();
    intent.setClassName("com.salvagemod.salvageparts", "com.salvagemod.salvageparts.activities.SystemActivity");
    spec = tabHost.newTabSpec("rom").setIndicator("ROM",
                      res.getDrawable(R.drawable.ic_tab_rom_info))
                  .setContent(intent);
    tabHost.addTab(spec);

    intent = new Intent().setClass(this, DeviceInfoSettings.class);
    spec = tabHost.newTabSpec("about").setIndicator("About",
                      res.getDrawable(R.drawable.ic_tab_about))
                  .setContent(intent);
    tabHost.addTab(spec);

    tabHost.setCurrentTab(0);
}

}
