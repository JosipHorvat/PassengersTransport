package com.josip.passenegertransport.bootstrap;

import com.github.javafaker.Faker;
import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.repositories.OperatorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class InputData implements ApplicationListener<ContextRefreshedEvent> {

    private final OperatorRepository operatorRepository;

    public InputData(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    Faker faker = new Faker();

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("***********************************************************");
        log.debug("****************LOADING DATA FROM BOOTSTRAP****************");
        log.debug("***********************************************************");

        if(operatorRepository.findAll().equals(0)){
            operatorRepository.saveAll(getOperators());
        }
    }

    private List<Operator> getOperators(){

        List<Operator> operators = new ArrayList<>(2);

        Operator user = new Operator();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setRole("user");
        user.setEmail("user@gmail.com");
        user.setOib("123345667889");
        user.setPassword("user1");
        operators.add(user);

        Operator admin = new Operator();
        admin.setFirstName(faker.name().firstName());
        admin.setLastName(faker.name().lastName());
        admin.setRole("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setOib("123345667889");
        admin.setPassword("admin1");
        operators.add(admin);

        return operators;
    }
}
