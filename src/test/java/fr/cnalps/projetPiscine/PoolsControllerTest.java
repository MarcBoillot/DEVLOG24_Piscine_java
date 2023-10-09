package fr.cnalps.projetPiscine;

import fr.cnalps.projetPiscine.controller.PoolsController;
import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.service.PoolsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

    @ExtendWith(SpringExtension.class)
    @WebMvcTest(controllers = PoolsController.class)
    public class PoolsControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PoolsService poolsService;

        private Pools pool;

        @BeforeEach
        public void setup(){
        pool = new Pools(1, "DLOG2023", "Valence");}


        public void getAllCandidatesTest() throws Exception {

            when(poolsService.getPools()).thenReturn(Collections.singletonList(pool));
            mockMvc.perform(get("/pools"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].town").value("Valence"));
        }
    }

