package shop.cloud.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import shop.cloud.common.domain.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
