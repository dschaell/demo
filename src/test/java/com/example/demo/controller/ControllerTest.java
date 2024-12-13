package com.example.demo.controller;

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
