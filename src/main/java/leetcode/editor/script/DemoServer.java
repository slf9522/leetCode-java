package leetcode.editor.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoServer extends Thread {
    private ServerSocket serverSocket = new ServerSocket(0);
    private ExecutorService executor = Executors.newFixedThreadPool(8);


    public DemoServer() throws IOException {
    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                executor.execute(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }

    public class NIOServer extends Thread {
        public void run() {
            try (Selector selector = Selector.open();
                 // 就是selector
                 ServerSocketChannel serverSocket = ServerSocketChannel.open();) {// 创建Selector和Channel
                serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
                serverSocket.configureBlocking(false);
                // 注册到Selector，并说明关注点
                serverSocket.register(selector, SelectionKey.OP_ACCEPT);
                while (true) {
                    selector.select();// 阻塞等待就绪的Channel，这是关键点之一
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectedKeys.iterator();
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        // 生产系统中一般会额外进行就绪状态检查
//                        sayHelloWorld((ServerSocketChannel) key.channel());
                        iter.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public class AIOServer extends Thread {
            public void run() {
                try (Selector selector = Selector.open();
                     // 就是selector
                     AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open();) {//
                    // 创建Selector和Channel
                    serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void sayHelloWorld(ServerSocketChannel server) throws IOException {
                // 就是实际的连接套接字
                try (SocketChannel client = server.accept();) {
                    client.write(Charset.defaultCharset().encode("Hello world!"));
                }
            }
            // 省略了与前面类似的main
        }


        public  void main(String[] args) throws IOException {
            DemoServer server = new DemoServer();
            server.start();
            try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                bufferedReader.lines().forEach(s -> System.out.println(s));
            }
        }
    }

    // 简化实现，不做读取，直接发送字符串
    class RequestHandler extends Thread {
        private Socket socket;

        RequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
                out.println("Hello world!");
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}