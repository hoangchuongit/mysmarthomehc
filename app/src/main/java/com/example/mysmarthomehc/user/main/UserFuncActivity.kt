/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2021 Tuya Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.example.mysmarthomehc.user.main

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mysmarthomehc.MainActivity
import com.example.mysmarthomehc.R
import com.example.mysmarthomehc.user.login.UserLoginActivity
import com.example.mysmarthomehc.user.register.UserRegisterActivity
import com.thingclips.smart.home.sdk.ThingHomeSdk


/**
 * User Func Navigation Page
 *
 * @author qianqi <a href="mailto:developer@tuya.com"/>
 * @since 2021/1/5 4:31 PM
 */
class UserFuncActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // If login, then navigate to MainSampleList
        if (ThingHomeSdk.getUserInstance().isLogin) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        setContentView(R.layout.user_activity_func)

        findViewById<Button>(R.id.btnRegister).setOnClickListener(this)
        findViewById<Button>(R.id.btnLogin).setOnClickListener(this)

        try {
            val pInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
            findViewById<TextView>(R.id.tvAppVersion).text =
                    String.format(getString(R.string.app_version_tips), pInfo.versionName)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }

    override fun onClick(v: View?) {
        v?.id?.let {
            if (it == R.id.btnRegister) {
                // Register
                startActivity(Intent(this, UserRegisterActivity::class.java))
            } else if (it == R.id.btnLogin) {
                // Login
                startActivity(Intent(this, UserLoginActivity::class.java))
            }
        }
    }
}