package shop.cloud.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import shop.cloud.common.domain.Order;
public interface OrderDao extends JpaRepository<Order, Integer>{

}
