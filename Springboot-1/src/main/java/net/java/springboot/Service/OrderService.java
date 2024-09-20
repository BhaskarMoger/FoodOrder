package net.java.springboot.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.model.Order;
import net.java.springboot.DTO.OrderRequest;
import net.java.springboot.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	
	 //post
    public Order addOrder(OrderRequest orderRequest) {
    	LocalDate currentDate = LocalDate.now();
    	Order order = new Order();
        order.setFirstName(orderRequest.getFirstName());
        order.setLastname(orderRequest.getLastname());
        order.setMobileNo(orderRequest.getMobileNo());
        order.setAddress(orderRequest.getAddress());
        order.setAmount(orderRequest.getAmount());
        order.setUserId(orderRequest.getUserId());
        order.setQuantity((long) 1);
        order.setPayment(orderRequest.getPayment());

        // Set the current date as the order date
        order.setDate(currentDate);

        // Save the order in the repository
        return orderRepository.save(order);
    }
}
