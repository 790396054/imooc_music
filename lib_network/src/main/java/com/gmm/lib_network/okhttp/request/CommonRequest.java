package com.gmm.lib_network.okhttp.request;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 提供 get/post/文件上传请求
 * @author gmm
 * @date 2019-10-10 22
 */
public class CommonRequest {

    /**
     * 创建 post 请求对象
     * @param url 地址
     * @param params post 参数
     * @return {@link Request}
     */
    public static Request postRequest(String url, RequestParams params) {
        return postRequest(url, params, null);
    }

    /**
     * 创建 post 请求对象
     * @param url 地址
     * @param params post 参数
     * @param headers 请求头
     * @return {@link Request}
     */
    public static Request postRequest(String url, RequestParams params, RequestParams headers) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                // 参数遍历
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }

        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                // 请求头遍历
                headerBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        return new Request.Builder()
                .url(url)
                .headers(headerBuilder.build())
                .post(formBodyBuilder.build())
                .build();
    }

    /**
     * 创建 get 请求对象
     * @param url 地址
     * @param params 参数
     * @return {@link Request}
     */
    public static Request getRequest(String url, RequestParams params) {
        return getRequest(url, params, null);
    }

    /**
     * 创建 get 请求对象
     * @param url 地址
     * @param params 参数
     * @param headers 请求头
     * @return {@link Request}
     */
    public static Request getRequest(String url, RequestParams params, RequestParams headers) {
        StringBuilder stringBuilder = new StringBuilder(url);
        if (params != null) {
            stringBuilder.append("?");
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            }
        }

        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                // 请求头遍历
                headerBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        return new Request.Builder()
                .url(stringBuilder.toString())
                .headers(headerBuilder.build())
                .get()
                .build();
    }

    private static final MediaType FILE_TYPE = MediaType.parse("application/octet-stream");
    /**
     * 文件上传请求
     * @param url 地址
     * @param params 参数
     * @return {@link Request}
     */
    public static Request multiPostRequest(String url, RequestParams params) {
        MultipartBody.Builder requestBody = new MultipartBody.Builder();
        requestBody.setType(MultipartBody.FORM);
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.fileParams.entrySet()) {
                if (entry.getValue() instanceof File) {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(FILE_TYPE, (File) entry.getValue()));
                } else if (entry.getValue() instanceof String) {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(null, (String) entry.getValue()));
                }
            }
        }
        return new Request.Builder().url(url).post(requestBody.build()).build();
    }
}
