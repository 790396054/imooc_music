package com.gmm.lib_network.okhttp.listener;

/**
 * 业务逻辑层真正处理的地方，包括java层异常和业务层异常
 *
 * @author gmm
 * @date 2019-10-10
 */
public interface DisposeDataListener {

    /**
     * 请求成功回调事件处理
     * @param responseObj obj
     */
    void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     * @param ex exception
     */
    void onFailure(Exception ex);
}
