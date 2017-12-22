package com.kkk;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * jetty 启动入口
 * http://www.eclipse.org/jetty/documentation/9.3.x/embedding-jetty.html
 * Create By z3jjlzt on 2017/10/23
 *
 * If this code is useful, it is written by z3jjlzt.
 * If not good, I do not know who wrote.
 */
public class JettyMain {
    public static final int PORT = 8080;
    public static final String CONTEXT = "/";

    private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port, String contextPath) {
        Server server = new Server();
        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        //这是http的连接器
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[]{connector});

        WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
        //webContext.setContextPath("/");
        webContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        // 设置webapp的位置
        webContext.setResourceBase(DEFAULT_WEBAPP_PATH);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(webContext);
        return server;
    }

    public void startJetty(int port,String context){
        final Server server = createServerInSource(PORT, CONTEXT);
        try {
            server.stop();
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new JettyMain().startJetty(8081,"");
    }
}
