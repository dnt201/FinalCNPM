package dao;

import model.OrderItemsModel;

import java.util.List;

public interface OrderItemsDao extends GenericDao<Integer, OrderItemsModel>{
    List<OrderItemsModel> findByProductId(Integer id);
}
