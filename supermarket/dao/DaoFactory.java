/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dao;

import supermarket.dao.custom.impl.CustomerDaoImpl;
import supermarket.dao.custom.impl.ItemDaoImpl;
import supermarket.dao.custom.impl.OrderDaoImpl;

/**
 *
 * @author DELL
 */
public class DaoFactory {
    private static DaoFactory daoFactory;
    
    private DaoFactory(){}
    
    public static DaoFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        
        return daoFactory;
    }
    
    public SuperDao getDao(DaoType type){
        switch (type) {
            case ITEM:
                return new ItemDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            default:
                return null;
        }
    }
    
    public enum DaoType{
        ITEM , CUSTOMER , ORDER , ORDERDETAIL ;
    }
            
}
    
