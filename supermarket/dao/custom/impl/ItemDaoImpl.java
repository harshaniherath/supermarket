/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dao.custom.impl;

import java.util.ArrayList;
import supermarket.dao.CrudUtil;
import supermarket.dao.custom.ItemDao;
import supermarket.entity.ItemEntity;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean create(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES (?,?,?,?,?)" , t.getItemCode(), t.getDescription(), t.getPack(), t.getUnitPrice(), t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE ITEM SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?",t.getDescription(), t.getPack(), t.getUnitPrice(), t.getQoh());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE ItemCode = ?", id);
    }

    @Override
    public ItemEntity get(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item WHERE ItemCode = ?",id);
       if(rst.next()){
           ItemEntity entity = new ItemEntity(
                   rst.getString("ItemCode"),
                   rst.getString("Description"),
                   rst.getString("PackSize"),
                   rst.getInt("QtyOnHand"),
                   rst.getDouble("UnitPrice")
                   );
           return entity;
       }
       return null;
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
       ArrayList<ItemEntity> itemEntities = new ArrayList<>();
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
       while(rst.next()){
           ItemEntity entity = new ItemEntity(
                   rst.getString("ItemCode"),
                   rst.getString("Description"),
                   rst.getString("PackSize"),
                   rst.getInt("QtyOnHand"),
                   rst.getDouble("UnitPrice")
                   );
         itemEntities.add(entity);
       }
       return itemEntities;
    }
    
}
