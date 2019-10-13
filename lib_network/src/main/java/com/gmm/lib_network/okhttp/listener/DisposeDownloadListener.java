package com.gmm.lib_network.okhttp.listener;

/**
 * 监听下载进度
 * @author gmm
 * @date 2019-10-13
 */
public interface DisposeDownloadListener extends DisposeDataListener{
    void onProgress(int progress);
}
