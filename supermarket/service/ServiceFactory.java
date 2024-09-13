/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.service;

import supermarket.service.custom.impl.CustomerServiceImpl;
import supermarket.service.custom.impl.ItemServiceImpl;
import supermarket.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author DELL
 */
public class ServiceFactory {
    
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    
    
    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case ITEM :
                return new ItemServiceImpl();
            case CUSTOMER :
                return new CustomerServiceImpl();
            case ORDER :
                return new OrderServiceImpl();
            default :
                return null;
        }
    }
    
    public enum ServiceType{
        ITEM , CUSTOMER , ORDER
    }
}
