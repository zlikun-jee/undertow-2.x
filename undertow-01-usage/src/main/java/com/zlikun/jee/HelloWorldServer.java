package com.zlikun.jee;

import io.undertow.Undertow;
import io.undertow.util.Headers;

/**
 * 官方示例<br>
 * http://undertow.io/ <br>
 * http://undertow.io/undertow-docs/undertow-docs-2.0.0/index.html<br>
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/06/05
 */
public class HelloWorldServer {

    public static void main(final String[] args) {
        // 构建一个Server
        Undertow server = Undertow.builder()
                // 添加一个HTTP监听器，指定监听端口、主机信息
                // 可以通过localhost和127.0.0.1来访问
                .addHttpListener(8080, "localhost")
//                // 本机IP，如果不监听，则无法通过该IP访问(即不能其它主机访问)
//                .addHttpListener(80, "192.168.0.105")
//                // 使用0.0.0.0将监听任意发送到本机指定端口(8000)的HTTP请求
//                .addHttpListener(8000, "0.0.0.0")
                // 添加一个Handler，这里用于响应请求信息(匹配任意URL，仅作演示使用)
                // Handler接收一个Exchange，用于处理响应、响应，实际逻辑处理部分
                .setHandler(exchange -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send("Hello World");
                }).build();

        // 启动该Server，启动过程参考：http://undertow.io/undertow-docs/undertow-docs-2.0.0/index.html#assembling-a-server-manually
        server.start();
    }

}
