package com.tcs.abn.recipeapi;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.builder.SpringApplicationBuilder;
@ExtendWith(MockitoExtension.class)
class ServletInitializerTest {

	@Mock
	  private SpringApplicationBuilder springApplicationBuilder;
	
	@Test
	void testConfigureSpringApplicationBuilder() {

		ServletInitializer servletInitializer = new ServletInitializer();
	    when(springApplicationBuilder.sources(RecipeApiApplication.class)).thenReturn(springApplicationBuilder);

	    SpringApplicationBuilder result = servletInitializer.configure(springApplicationBuilder);

	    verify(springApplicationBuilder).sources(RecipeApiApplication.class);
	    assertEquals(springApplicationBuilder,result);

	}

}
