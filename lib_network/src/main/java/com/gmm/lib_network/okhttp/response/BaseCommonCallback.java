package com.gmm.lib_network.okhttp.response;

import android.os.Handler;

import com.gmm.lib_network.okhttp.exception.OkHttpException;
import com.gmm.lib_network.okhttp.listener.DisposeDataHandle;
import com.gmm.lib_network.okhttp.listener.DisposeDataListener;
import com.gmm.lib_network.okhttp.listener.DisposeDownloadListener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author gmm
 * @date 2019-10-13
 */
public abstract class BaseCommonCallback implements Callback {
    /**
     * the java layer exception, do not same to the logic error
     */
    protected final int NETWORK_ERROR = -1;
    protected final int IO_ERROR = -2;
    protected final int JSON_ERROR = -3;
    protected final int OTHER_ERROR = -4;

    protected final String EMPTY_MSG = "";
}
