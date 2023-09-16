package org.example.appointment.web.resources;

import org.example.appointment.domain.doctor.port.api.DoctorService;
import org.example.appointment.web.mapping.WebModelMapper;
import org.example.appointment.web.mapping.WebModelMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = AppointmentResources.class)
//@AutoConfigureMockMvc
//@SpringBootTest
@Import(WebModelMapperImpl.class)
class AppointmentResourcesTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService doctorService;

    @Autowired
    private ApplicationContext context;

    @Test
    void printSpringContext() {
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.printf("===> %s%n", beanName);
        }
        System.out.println(Arrays.stream(context.getBeanDefinitionNames()).count());
    }

    @Test
    void whenGetAllAppointment_thenListOfAppointment() throws Exception {
        Assertions.assertNotNull(mockMvc);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/appointments")
                        .param("date", "2017-10-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}