package service.impl;

import dao.OrderItemsDao;
import dao.impl.OrderItemsDaoImpl;
import model.OrderItemsModel;
import service.IOrderItemsService;

import javax.inject.Inject;
import java.util.List;

public class OrderItemsService implements IOrderItemsService {
    @Inject
    private OrderItemsDao orderItemsDAO;

    public OrderItemsService() {
        orderItemsDAO = new OrderItemsDaoImpl();
    }

    @Override
    public void save(OrderItemsModel orderItemModel) {
        orderItemsDAO.save(orderItemModel);
    }

    @Override
    public void update(OrderItemsModel orderItemModel) {
        orderItemsDAO.update(orderItemModel);
    }

    @Override
    public OrderItemsModel findByID(Integer orderItemId) {
        return orderItemsDAO.findById(orderItemId);
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return orderItemsDAO.delete(ids);
    }

    @Override
    public List<OrderItemsModel> findAll() {
        return orderItemsDAO.findAll();
    }

    @Override
    public List<OrderItemsModel> findByProductId(Integer id) {
        return orderItemsDAO.findByProductId(id);
    }
}
