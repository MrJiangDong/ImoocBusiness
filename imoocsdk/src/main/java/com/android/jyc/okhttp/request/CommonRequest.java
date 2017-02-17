package com.android.jyc.okhttp.request;

import android.app.DownloadManager;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by Admin on 2017/2/17.
 *
 * @function 接收请求参数, 为我们生成Request对象
 */

public class CommonRequest {

    /**
     * @param url
     * @param params
     * @return 返回一个创建好的Request
     */
    public static Request createPostRequest(String url, RequestParams params) {

        FormBody.Builder mFormBodyBuild = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                //将请求参数遍历添加到我们的请求构件类中
                mFormBodyBuild.add(entry.getKey(), entry.getValue());
            }
        }

        //通过请求构件类的build方法获取到真正的请求对象
        FormBody mFormBody = mFormBodyBuild.build();
        return new Request.Builder().url(url).post(mFormBody).build();
    }

    /**
     * @param url
     * @param params
     * @return 通过传入的参数返回一个Get类型的请求
     */
    public static Request createGetRequest(String url, RequestParams params) {
        StringBuilder urlBuilder = new StringBuilder(url).append("?");

        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                //将请求参数遍历添加到我们的请求构件类中
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }

        return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length() - 1)).get().build();
    }
}
