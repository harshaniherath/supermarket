/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dao.custom.impl;

import java.util.ArrayList;
import supermarket.dao.custom.CustomerDao;
import supermarket.entity.CustomerEntity;
import java.sql.ResultSet;
import supermarket.dao.CrudUtil;

/**
 *
 * @author DELL
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean create(CustomerEntity t) throws Exception {
        return false;    
    }

    @Override
    public boolean update(CustomerEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer WHERE custId = ?",id);
        if(rst.next()){
           CustomerEntity entity = new CustomerEntity(
                   rst.getString("CustId"),
                    rst.getString("CustTitle"),
                     rst.getString("CustName"),
                      rst.getString("DOB"),
                   rst.getDouble("salary"),
                   rst.getString("CustAddress"),
                     rst.getString("City"),
                  rst.getString("Province"),
                      rst.getString("PostalCode")
                   );
           return entity;
       }
       return null;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        return null;
    }
    
}
