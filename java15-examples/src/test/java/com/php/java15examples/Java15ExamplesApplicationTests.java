package com.php.java15examples;

import com.php.java15examples.record.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Java15ExamplesApplicationTests {

	@Test
	void testTextBlock() {
		String sql = """
    				Select \
    					p.id_product,\
    					p.name,\
    					c.name
    				from products p 
    				join categories c on c.id_product = p.id_product
    				where p.price > 10
				""";

		System.out.println(sql);
	}

	@Test
	void testPatternMatching() {
		Object obj = "Poloea";
		if (obj instanceof String) {
			String name = (String) obj;
			System.out.println("Antigo " + name);
		}

		if (obj instanceof String name) {
			System.out.println("Novo 1 - " + name);
		}

		//Não funciona com ou
		if (obj instanceof String name && name.length() > 4) {
			System.out.println("Novo 2 - " + name);
		}
	}

	@Test
	void testRecord() {
		Product tv = new Product(1L, "TV");
		System.out.println(tv);


		record Categories(Long id, String name){};
		Categories categories = new Categories(1L, "Electronic");
		System.out.println(categories);
	}

	@Test
	void testLocalInterface() {
		//Podem ser declarados metodos e classes
		interface Drawing{}

		enum DrawingEnum { SQUARE, CICLE }

		record Square() implements Drawing{};
	}

}
