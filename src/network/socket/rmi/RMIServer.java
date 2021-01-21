package network.socket.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Callable;

public class RMIServer {
    public static void main(String[] args) throws RemoteException {
        System.out.println("create RMI server -- Get Local Date Time...");

        // 实例化一个 Clock 接口
        ClockInterface clock = new ClockService();

        // 将该服务转换成 RMI 服务接口
        ClockInterface clockRMI = (ClockInterface) UnicastRemoteObject.exportObject(clock, 0);

        // 将RMI服务注册到服务器的 1099 端口
        Registry reg = LocateRegistry.createRegistry(1099);

        // 注册此服务, 服务名为 "ClockService"
        reg.rebind("ClockService", clockRMI);
    }
}
