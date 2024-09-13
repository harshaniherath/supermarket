/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dao.custom.impl;

import java.util.ArrayList;
import supermarket.dao.CrudUtil;
import supermarket.dao.custom.OrderDetailDao;
import supermarket.entity.OrderDetailEntity;

/**
 *
 * @author DELL
 */
public class OrderDetailDaoImpl implements OrderDetailDao{

    @Override
    public boolean create(OrderDetailEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO Orders VALUES(?,?,?)",t.getOrderId(), t.getItemCode(),t.getQty(),t.getDiscount() );
    }

    @Override
    public boolean update(OrderDetailEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Object id) throws Exception {
        return false;
    }

    @Override
    public OrderDetailEntity get(Object id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetailEntity> getAll() throws Exception {
        return null;
    }
    
}
