/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dao.custom.impl;

import java.util.ArrayList;
import supermarket.dao.CrudUtil;
import supermarket.dao.custom.OrderDao;
import supermarket.entity.OrderEntity;

/**
 *
 * @author DELL
 */
public class OrderDaoImpl implements OrderDao{

    @Override
    public boolean create(OrderEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Orders VALUES(?,?,?)", t.getOrderId(),t.getDate(),t.getCustId());
    }
    @Override
    public boolean update(OrderEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public OrderEntity get(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderEntity> getAll() throws Exception {
        return null;
    }
    
}
