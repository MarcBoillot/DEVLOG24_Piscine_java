package fr.cnalps.projetPiscine;

import fr.cnalps.projetPiscine.controller.PoolsController;
import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.service.PoolsService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @RunWith(SpringRunner.class)
    @WebMvcTest(controllers = PoolsController.class)
    public class PoolsControllerTest {
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PoolsService poolsService;

        private Pools pools;
        

        @Test
        public void getAllCandidatesTest() throws Exception {
                Pools pool1 = new Pools(1, "2023", "Valence");
                Pools pool2 = new Pools(2, "2024", "Grenoble");
                List<Pools> newPools = Arrays.asList(pool1,pool2);

            when(poolsService.getPools()).thenReturn(newPools);
            mockMvc.perform(get("/pools"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(jsonPath("$").value(2))
                    .andExpect(jsonPath("$[0].town").value("Valence"))
                    .andExpect(jsonPath("$[1].town").value("Grenoble"));
        }
    }

