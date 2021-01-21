package network.socket.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

public class RMIClient {
    // 要想在客户端实现RMI，必须要把服务器的 ClockInterface.java 这个接口文件复制到客户端，然后再实现远程调用.
    public static void main(String[] args) throws RemoteException, NotBoundException {
        //连接到RMI服务器 及其端口 1099
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);

        // 查找名称为 "ClockService" 的RMI服务，并强制转型为 ClockInterface 接口
        ClockInterface clockClient = (ClockInterface)reg.lookup("ClockService");

        // 正常调用接口方法
        LocalDateTime res = clockClient.getTime("Asia/Shanghai");

        // 打印结果
        System.out.println(res);
    }

}
