/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dto;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class OrderDto {
    private String orderId;
    private String custId;
    private String date;
    
    private ArrayList<OrderDetailDto> orderDetailDtos;

    public OrderDto() {
    }

    public OrderDto(String orderId, String custId, String date, ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderId = orderId;
        this.custId = custId;
        this.date = date;
        this.orderDetailDtos = orderDetailDtos;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the orderDetailDtos
     */
    public ArrayList<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    /**
     * @param orderDetailDtos the orderDetailDtos to set
     */
    public void setOrderDetailDtos(ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderId=" + orderId + ", custId=" + custId + ", date=" + date + ", orderDetailDtos=" + orderDetailDtos + '}';
    }
    
    
}
