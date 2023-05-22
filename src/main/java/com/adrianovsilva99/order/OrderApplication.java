package com.adrianovsilva99.order;

import com.adrianovsilva99.entities.Order;
import com.adrianovsilva99.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.adrianovsilva99"})
public class OrderApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Codigo: ");
		int code = sc.nextInt();
		System.out.print("Valor: ");
		double basic = sc.nextDouble();
		System.out.print("Desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		double total = orderService.total(order);

		System.out.printf("Pedido codigo %d%n", code);
		System.out.printf("Valor total: R$ %.2f%n", total);

		sc.close();
	}
}