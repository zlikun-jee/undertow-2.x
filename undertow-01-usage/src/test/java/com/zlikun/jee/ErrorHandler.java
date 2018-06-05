package com.zlikun.jee;

import io.undertow.Undertow;
import lombok.extern.slf4j.Slf4j;

/**
 * http://undertow.io/undertow-docs/undertow-docs-2.0.0/index.html#exceptions
 */
@Slf4j
public class ErrorHandler {

    public static void main(String[] args) {

        Undertow undertow = Undertow.builder()
                .addHttpListener(80, "0.0.0.0")
                .setHandler(exchange -> {
                    try {
                        // HTTP处理逻辑
                        throw new RuntimeException("这里不作任何处理，仅供测试使用");
                    } catch (Exception e) {
                        if (exchange.isResponseChannelAvailable()) {
                            // handle error
                            log.error("请求发生错误!", e);

                            // 提供错误响应
                            exchange.getResponseSender().send("ERROR");
                        }
                    }
                })
                .build();

        undertow.start();

    }

}
