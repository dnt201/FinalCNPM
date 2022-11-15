package service.impl;

import dao.OrderDetailsDao;
import dao.impl.OrderDetailsDaoImpl;
import model.OrderDetailsModel;
import service.IOrderDetailsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class OrderDetailsService implements IOrderDetailsService {
    @Inject
    private OrderDetailsDao orderDetailsDao;

    public OrderDetailsService() {
        orderDetailsDao = new OrderDetailsDaoImpl();
    }

    @Override
    public Integer save(OrderDetailsModel orderDetailModel) {
        Timestamp ts = Timestamp.from(Instant.now());
        orderDetailModel.setCreateAt(ts);
        return orderDetailsDao.saveReturnId(orderDetailModel);
    }

    @Override
    public void update(OrderDetailsModel orderDetailModel) {
        orderDetailsDao.update(orderDetailModel);
    }

    @Override
    public OrderDetailsModel findById(Integer orderDetailId) {
        return orderDetailsDao.findById(orderDetailId);
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return orderDetailsDao.delete(ids);
    }

    @Override
    public List<OrderDetailsModel> findAll() {
        return orderDetailsDao.findAll();
    }

    @Override
    public List<OrderDetailsModel> findByUserId(Integer userId) {
        return orderDetailsDao.findByUserId(userId);
    }
}
