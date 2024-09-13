/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.controller;

import supermarket.dto.CustomerDto;
import supermarket.service.ServiceFactory;
import supermarket.service.custom.CustomerService;

/**
 *
 * @author DELL
 */
public class CustomerController {
    
    private CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    
    public CustomerDto getCustomer(String custId) throws Exception{
        return customerService.getCustomer(custId);
    } 
}
