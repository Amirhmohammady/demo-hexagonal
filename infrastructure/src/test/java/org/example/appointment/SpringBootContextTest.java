package org.example.appointment;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class SpringBootContextTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextShouldInitialized(){
        Assertions.assertNotNull(context);
    }

    @Test
    void printSpringContext(){
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.printf("===> %s%n",beanName);
        }
    }

}
