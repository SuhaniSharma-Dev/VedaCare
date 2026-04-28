package com.business;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.business.entities.Admin;
import com.business.entities.User;
import com.business.entities.Product;
import com.business.repositories.AdminRepository;
import com.business.repositories.UserRepository;
import com.business.repositories.ProductRepository;

@SpringBootApplication
public class BusinessProjectApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BusinessProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner createSampleData(AdminRepository adminRepository, UserRepository userRepository, ProductRepository productRepository) {
		return args -> {
			if (adminRepository.findByAdminEmail("admin@business.com") == null) {
				Admin admin = new Admin();
				admin.setAdminName("Demo Admin");
				admin.setAdminEmail("admin@business.com");
				admin.setAdminPassword("admin123");
				admin.setAdminNumber("9876543210");
				adminRepository.save(admin);
				System.out.println("Demo Admin created successfully: admin@business.com / admin123");
			}

			if (userRepository.findUserByUemail("user@business.com") == null) {
				User user = new User();
				user.setUname("Demo User");
				user.setUemail("user@business.com");
				user.setUpassword("user123");
				user.setUnumber(9876543210L);
				userRepository.save(user);
				System.out.println("Demo User created successfully: user@business.com / user123");
			}

			if (productRepository.count() == 0) {
				Product p1 = new Product();
				p1.setPname("Premium Green Tea");
				p1.setPprice(250.0);
				p1.setPdescription("High-quality organic green tea leaves.");
				productRepository.save(p1);

				Product p2 = new Product();
				p2.setPname("Assam Black Tea");
				p2.setPprice(300.0);
				p2.setPdescription("Strong and malty black tea from Assam.");
				productRepository.save(p2);

				Product p3 = new Product();
				p3.setPname("Chamomile Tea");
				p3.setPprice(350.0);
				p3.setPdescription("Relaxing herbal chamomile tea.");
				productRepository.save(p3);

				System.out.println("Sample Products created successfully.");
			}
		};
	}
}
