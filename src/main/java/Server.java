import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public Server() {
        super();
    }

    ;

    public static void main(String[] args) {
        try {
            // 创建本机 1099 端口上的RMI registry
            RMISocketFactory.setSocketFactory(new SMRMISocket());
            Registry registry = LocateRegistry.createRegistry(1099);
            Server obj = new Server();
//            RMISocketFactory.setSocketFactory(new SMRMISocket());

            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 1099);
//            Hello stub = new Client();
            // 有些RMI示例代码会让接口实现类直接继承自 UnicastRemoteObject ，效果是一样的，参见 UnicastRemoteObject 的构造函数，或则在接口实现类构造函数中做这个工作也可以

            // 将 Stub 绑定到RMI注册表中，方式多样，上文已经提过
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    //The implementation class Server implements the remote interface Hello,
    //providing an implementation for the remote method sayHello. The method sayHello does not need to declare that it throws any exception because the method implementation itself does not throw RemoteException nor does it throw any other checked exceptions.
    @Override
    public String sayHello() {
        return "Hello, world";
    }
}