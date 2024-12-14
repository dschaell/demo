/*package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import com.example.demo.service.BubbleSortService;
import com.example.demo.service.MergeSortService;
import com.example.demo.service.QuickSortService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Controller.class)
@ContextConfiguration(classes = ControllerTest.TestConfig.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BubbleSortService bubbleSortService;

    @Autowired
    private MergeSortService mergeSortService;

    @Autowired
    private QuickSortService quickSortService;

    @BeforeEach
    void setupMocks() {
        // BubbleSortService Mock
        Mockito.when(bubbleSortService.sort(anyList(), eq("asc")))
                .thenReturn(Arrays.asList(2.2, 3.3, 5.5, 9.9));
        
        Mockito.when(bubbleSortService.sort(anyList(), eq("desc")))
                .thenReturn(Arrays.asList(9.9, 5.5, 3.3, 2.2));

        // MergeSortService Mock
        Mockito.when(mergeSortService.sort(anyList(), eq("asc")))
                .thenReturn(Arrays.asList(1.1, 2.2, 3.3, 4.4));

        Mockito.when(mergeSortService.sort(anyList(), eq("desc")))
                .thenReturn(Arrays.asList(4.4, 3.3, 2.2, 1.1));

        // QuickSortService Mock
        Mockito.when(quickSortService.sort(anyList(), anyInt(), anyInt(), eq("asc")))
                .thenReturn(Arrays.asList(1.1, 3.3, 4.4));

        Mockito.when(quickSortService.sort(anyList(), anyInt(), anyInt(), eq("desc")))
                .thenReturn(Arrays.asList(4.4, 3.3, 1.1));
    }

    @Test
    void testBubbleSort() throws Exception {
        mockMvc.perform(post("/api/sort/bubble?order=asc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [5.5, 2.2, 9.9, 3.3]}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[2.2, 3.3, 5.5, 9.9]"));
                
    }

    @Test
    void testMergeSort() throws Exception {
        mockMvc.perform(post("/api/sort/merge?order=desc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [3.3, 1.1, 4.4, 2.2]}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[4.4, 3.3, 2.2, 1.1]"));
    }

    @Test
    void testQuickSort() throws Exception {
        mockMvc.perform(post("/api/sort/quick?order=asc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [3.3, 1.1, 4.4]}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[1.1, 3.3, 4.4]"));
    }

    @Test
    void testInvalidInput() throws Exception {
        mockMvc.perform(post("/api/sort/bubble?order=asc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": []}"))
                .andExpect(status().isBadRequest());
    }

    @Configuration
    static class TestConfig {
        @Bean
        public BubbleSortService bubbleSortService() {
            return Mockito.mock(BubbleSortService.class);
        }

        @Bean
        public MergeSortService mergeSortService() {
            return Mockito.mock(MergeSortService.class);
        }

        @Bean
        public QuickSortService quickSortService() {
            return Mockito.mock(QuickSortService.class);
        }
    }
}
*/




package com.example.demo.controller;


import com.example.demo.service.BubbleSortService;
import com.example.demo.service.MergeSortService;
import com.example.demo.service.QuickSortService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(Controller.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private BubbleSortService bubbleSortService;

	@MockitoBean
	private MergeSortService mergeSortService;

	@MockitoBean
	private QuickSortService quickSortService;

	@InjectMocks
	private Controller controller;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testBubbleSort() throws Exception {
		List<Double> input = Arrays.asList(3.0, 1.0, 2.0);
		List<Double> sorted = Arrays.asList(1.0, 2.0, 3.0);

		when(bubbleSortService.sort(anyList(), eq("asc"))).thenReturn(sorted);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/sort/bubble")
						.contentType(MediaType.APPLICATION_JSON)
						.param("order", "asc")
						.content("{\"numbers\":" + input + "}")   // input = [3.0, 1.0, 2.0]
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[1.0,2.0,3.0]"));
	}

	@Test
	public void testMergeSort() throws Exception {
		List<Double> input = Arrays.asList(5.0, 4.0, 6.0);
		List<Double> sorted = Arrays.asList(4.0, 5.0, 6.0);

		when(mergeSortService.sort(anyList(), eq("asc"))).thenReturn(sorted);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/sort/merge")
						.contentType(MediaType.APPLICATION_JSON)
						.param("order", "asc")
						.content("{\"numbers\":" + input + "}") // input = [5.0, 4.0, 6.0]
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[4.0,5.0,6.0]"));
	}

	@Test
	public void testQuickSort() throws Exception {
		List<Double> input = Arrays.asList(9.0, 7.0, 8.0);
		List<Double> sorted = Arrays.asList(7.0, 8.0, 9.0);

		when(quickSortService.sort(anyList(), anyInt(), anyInt(), eq("asc"))).thenReturn(sorted);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/sort/quick")
						.contentType(MediaType.APPLICATION_JSON)
						.param("order", "asc")
						.content("{\"numbers\":" + input + "}") // input = [9.0, 7.0, 8.0]
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[7.0,8.0,9.0]"));
	}
}
