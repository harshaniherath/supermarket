/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.service.custom.impl;

import supermarket.dao.DaoFactory;
import supermarket.dao.custom.CustomerDao;
import supermarket.dto.CustomerDto;
import supermarket.entity.CustomerEntity;
import supermarket.service.custom.CustomerService;

/**
 *
 * @author DELL
 */
public class CustomerServiceImpl implements CustomerService{
   
    private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    
    @Override
    public CustomerDto getCustomer(String custId) throws Exception{
        CustomerEntity entity = customerDao.get(custId);
        if(entity != null){
            CustomerDto dto = new CustomerDto(
             entity.getCustId(),
              entity.getTitle(),
               entity.getName(),
                entity.getDob(),
             entity.getSalary(),
             entity.getAddress(),
               entity.getCity(),
            entity.getProvince(),
                entity.getZip()
            );
            return dto;
        }
        return null;
        
    }
}
