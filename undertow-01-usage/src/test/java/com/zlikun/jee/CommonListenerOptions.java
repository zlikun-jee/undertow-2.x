package com.zlikun.jee;

import io.undertow.Undertow;
import io.undertow.util.Headers;

import static io.undertow.UndertowOptions.DEFAULT_MAX_HEADER_SIZE;
import static io.undertow.UndertowOptions.MAX_HEADER_SIZE;
import static io.undertow.UndertowOptions.URL_CHARSET;

/**
 * http://undertow.io/undertow-docs/undertow-docs-2.0.0/index.html#common-listener-options
 */
public class CommonListenerOptions {

    public static void main(final String[] args) {
        // 构建一个Server
        Undertow server = Undertow.builder()
                .addHttpListener(80, "0.0.0.0")
                .setServerOption(MAX_HEADER_SIZE, DEFAULT_MAX_HEADER_SIZE)
                .setServerOption(URL_CHARSET, "UTF-8")
                // ... ...
                .setHandler(exchange -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html");
                    exchange.getResponseSender().send("<a target=\"_blank\" href=\"http://undertow.io/undertow-docs/undertow-docs-2.0.0/index.html#common-listener-options\">common-listener-options</a>");
                }).build();

        server.start();
    }
}
