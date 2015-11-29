package com.lx.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.lx.rmi.service.IRmiService;
import com.lx.rmi.service.impl.RmiServiceImpl;

/**
 * Rmi 服务接口发布
 * 
 * @author lixin
 *
 */
public class RmiServier {

	public static void main(String[] args) {
		
		try {
			// 创建一个远程接口对象
			IRmiService rmiService = new RmiServiceImpl();
			
			// java rmi默认端口1099，注册端口1099
			LocateRegistry.createRegistry(1099);
			
			/**
			 * 绑定指定名称到远程对象
			 *  把远程对象注册到RMI注册服务器上，并命名为rmiService，绑定的URL标准格式为：rmi://host:port/name
			 *  (其中协议名可以省略，下面两种写法都是正确的）
			 */
			Naming.bind("rmi://localhost:1099/rmiService", rmiService);
			//Naming.bind("locaohost:1099/rmiService", rmiService);
			
			System.out.println("rmi服务已启动，接口暴露地址：rmi://localhost:1099/rmiService");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
