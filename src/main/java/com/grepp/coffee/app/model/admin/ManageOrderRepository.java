package com.grepp.coffee.app.model.admin;

import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.OrderDto;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ManageOrderRepository {

    @Select("select * from ORDERS")
    List<OrderDto> selectAllOrders();

    @Select("select * from DETAIL where order_num=#{orderId}")
    List<DetailedOrderDto> selectAllDetailedOrdersById(Integer orderId);

    @Delete("delete from ORDERS where order_id = #{orderId}")
    boolean deleteOrder(Integer orderId);

    @Delete("DELETE FROM DETAIL WHERE order_num = #{orderId}")
    boolean deleteDetailedOrder(Integer orderId);

    @Update("UPDATE ORDERS SET is_delivered = TRUE WHERE order_id = #{orderId}")
    boolean updateDelivery(Integer orderId);
}
