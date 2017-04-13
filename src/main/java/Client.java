import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {

    }

    public static void main(String[] args) {
//        args = new String[]{"127.0.0.1"};
        String host = (args.length < 1) ? null : args[0];
        String port = (args.length < 2) ? "1099" : args[1];
        try {
            // 获取 host 主机 port 端口上的 RMI 注册表引用，参数是程序运行参数
            Registry registry = LocateRegistry.getRegistry(host, Integer.parseInt(port));
            // 获取远程对象存根，方式多样，上文已经提过
            Hello stub = (Hello) registry.lookup("Hello");
            // 调用远程方法
            while (true) {
                String response = stub.sayHello();
                System.out.println("response: " + response);
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}