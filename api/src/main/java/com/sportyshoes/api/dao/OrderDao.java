package com.sportyshoes.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportyshoes.api.entities.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {

	public List<Order> findAllByOrderById();

	public List<Order> findAllByOrderByIdDesc();

	public List<Order> findAllByOrderByOrderDate();

	public List<Order> findAllByOrderByOrderDateDesc();

	@Query("select o from Order o where  o.user.id = :userId")
	public List<Order> getAllOrderByUserId(Long userId);
	
	@Query("select o from Order o where  o.product.id = :productId")
	public List<Order> getAllOrderByProductId(Long productId);

}
