/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.DiscountModel;

/**
 *
 * @author asus
 */
public interface DiscountDao extends GenericDao<Integer, DiscountModel>{
    DiscountModel findByName(String discountName);
}
