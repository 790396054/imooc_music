package com.gmm.lib_common_ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.gmm.lib_common_ui.utils.StatusBarUtil;

/**
 * @author gmm
 * @date 2019-10-06 22
 * @email miaomiaogong@92gmail.com
 */
public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.statusBarLightMode(this);
    }
}
