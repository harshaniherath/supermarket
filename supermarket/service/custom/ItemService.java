/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.service.custom;


import java.util.ArrayList;
import supermarket.dto.ItemDto;
import supermarket.service.SuperService;

/**
 *
 * @author DELL
 */
public interface ItemService extends SuperService{
    String save(ItemDto itemDto) throws Exception;
    String update(ItemDto itemDto) throws Exception;
    String delete(String itemCode) throws Exception;
    ArrayList <ItemDto> getAll() throws Exception;
    ItemDto get(String itemCode) throws Exception;
}
