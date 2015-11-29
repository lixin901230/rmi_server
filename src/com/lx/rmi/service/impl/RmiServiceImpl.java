package com.lx.rmi.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.lx.rmi.service.IRmiService;

/**
 * RMI服务的实现类
 * 注意：从普通 RMI 改编与spring集成时要注意需要将实现类的extends UnicastRemoteObject去掉，
 * 		否则会报错［org.springframework.beans.factory.BeanCreationException: 
 * 		Error creating bean with name 'refreshService' defined in class path resource [applicationContext.xml]: 
 * 		Initialization of bean failed; nested exception is java.rmi.server.ExportException: object already exported］
 * 		因为UnicastRemoteObject的作用就是生成stub object 
 * @author lixin
 *
 */
public class RmiServiceImpl extends UnicastRemoteObject implements IRmiService {

	private static final long serialVersionUID = 419042456407002017L;

	/**
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，
	 * 因此这里默认的构造方法必须写，
	 * 必须声明抛出RemoteException异常
     * @throws RemoteException
     */
	public RmiServiceImpl() throws RemoteException {
		
	}

	public String sayHello(String name) throws RemoteException {
		return "Hello " + name;
    }

}
