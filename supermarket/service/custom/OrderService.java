/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.service.custom;

import supermarket.dto.OrderDto;
import supermarket.service.SuperService;

/**
 *
 * @author DELL
 */
public interface OrderService extends SuperService{
    public String placeOrder(OrderDto orderDto) throws Exception;
}
