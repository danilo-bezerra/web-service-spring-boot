package io.danilobzerra.crud;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.danilobzerra.crud.entities.Category;
import io.danilobzerra.crud.entities.Order;
import io.danilobzerra.crud.entities.OrderItem;
import io.danilobzerra.crud.entities.Payment;
import io.danilobzerra.crud.entities.Product;
import io.danilobzerra.crud.entities.User;
import io.danilobzerra.crud.entities.enums.OrderStatus;
import io.danilobzerra.crud.repositories.CategoryRepository;
import io.danilobzerra.crud.repositories.OrderItemRepository;
import io.danilobzerra.crud.repositories.OrderRepository;
import io.danilobzerra.crud.repositories.ProductRepository;
import io.danilobzerra.crud.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepositoty;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o3 = new Order(null, Instant.now().minusSeconds(523698), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.now().minusSeconds(15523698), OrderStatus.PAID, u2);
		Order o1 = new Order(null, Instant.now().minusSeconds(12523698), OrderStatus.DELIVERED, u1);

		userRepositoty.saveAll(Arrays.asList(u1, u2));

		Payment pay1 = new Payment(null, Instant.now(), o3);
		o3.setPayment(pay1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

	}

}
