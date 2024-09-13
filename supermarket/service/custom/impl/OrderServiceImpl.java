/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.service.custom.impl;

import supermarket.dao.DaoFactory;
import supermarket.dao.custom.ItemDao;
import supermarket.dao.custom.OrderDao;
import supermarket.dao.custom.OrderDetailDao;
import supermarket.dto.OrderDto;
import supermarket.service.custom.OrderService;
import java.sql.Connection;
import supermarket.db.DBConnection;
import supermarket.dto.OrderDetailDto;
import supermarket.entity.ItemEntity;
import supermarket.entity.OrderDetailEntity;
import supermarket.entity.OrderEntity;

/**
 *
 * @author DELL
 */
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDERDETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);
    
    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();  
        try{
            connection.setAutoCommit(true);
            OrderEntity orderEntity = new OrderEntity(orderDto.getOrderId(), orderDto.getCustId(),orderDto.getDate());
            if(orderDao.create(orderEntity)){
                boolean isOrderDetailSaved = true;
                
                for(OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()){
                     OrderDetailEntity orderDetailEntity = new OrderDetailEntity(
                             orderDetailDto.getOrderId(),
                             orderDetailDto.getItemCode(),
                             orderDetailDto.getQty(),
                             orderDetailDto.getDiscount()
                     );
                     
                     if(!orderDetailDao.create(orderDetailEntity)){
                         isOrderDetailSaved = false;
                     }
                }
                
                if(isOrderDetailSaved){
                    boolean isItemUpdated = true;
                    for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()){
                        ItemEntity itemEntity = itemDao.get(orderDetailDto.getItemCode());
                        if(itemEntity != null){
                            itemEntity.setQoh(itemEntity.getQoh() - orderDetailDto.getQty());
                            if(itemDao.update(itemEntity)){
                                isItemUpdated = false;
                            }
                        }
                    }
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    }else{
                        connection.rollback();
                        return "Item Update Error";
                    }
                    
                }else{
                    connection.rollback();
                    return "Order Detail Save Error";
                }
                
            }else{
                connection.rollback();
                return "Order Save Error";
            }
            
        } catch (Exception e){
            connection.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            connection.setAutoCommit(true);
        }     
    }
    
}
