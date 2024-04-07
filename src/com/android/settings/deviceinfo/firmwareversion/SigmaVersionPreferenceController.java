/*
 * Copyright (C) 2019-2023 The LineageOS Project
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

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;

import androidx.preference.Preference;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class SigmaVersionPreferenceController extends BasePreferenceController {

    private static final String SIGMA_BUILD_VERSION = "ro.sigma.modversion";
    private static final String KEY_SIGMA_VERSION = "sigma_version";
    private static final String SIGMA_PACKAGE_TYPE = "ro.sigma.build.package";


    public SigmaVersionPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_SIGMA_VERSION;
    }

    @Override
    public CharSequence getSummary() {
        String version = SystemProperties.get(SIGMA_BUILD_VERSION, "");
        if (TextUtils.isEmpty(version)) return "";
        String packageType = SystemProperties.get(SIGMA_PACKAGE_TYPE, "");
        if (TextUtils.isEmpty(packageType)) return version;
        return version + " (" + packageType + ")";
    }
}
