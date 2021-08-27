package com.thd.training;

import com.jayway.jsonpath.JsonPath;
import com.thd.training.repository.GroceryProductRepository;
import com.thd.training.service.GroceryProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TrainingApplicationTests {
	@Autowired
	private MockMvc mvc;


	@Test
	void contextLoads() {
	}
	@Test
	public void getGroceryProduct_whenGetId4_thenStatus200()throws Exception{

		mvc.perform(
						get("/grocery_products/find_by_id?id=4")
						.accept(MediaType.APPLICATION_JSON)
		)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      			.andExpect(jsonPath("$.groceryProduct.name", is("Product12")))
				.andExpect(jsonPath("$.groceryProduct.unit_price", is(10.0)));
	}

	@Test
	public void getGroceryProduct_whenGetId10000_thenStatus404()throws Exception{

		mvc.perform(
						get("/grocery_products/find_by_id?id=1000")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andDo(print())
				.andExpect(status().isNotFound());
	}

}
