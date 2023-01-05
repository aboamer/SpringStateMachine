package com.amer.statemachine.config;

import com.amer.statemachine.domain.EmployeeEvent;
import com.amer.statemachine.domain.EmployeeState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.UUID;

@SpringBootTest
class StateMachineConfigTest {

    @Autowired
    StateMachineFactory<EmployeeState, EmployeeEvent> factory;

    @Test
    void testAddedStateMachine() {

        StateMachine<EmployeeState, EmployeeEvent> sm = factory.getStateMachine(UUID.randomUUID());

        sm.start();

        System.out.println("1- " + sm.getState().toString());

        sm.sendEvent(EmployeeEvent.BEGIN_CHECK);

        System.out.println("2- " + sm.getState().toString());

        sm.sendEvent(EmployeeEvent.COMPLETE_INITIAL_WORK_PERMIT_CHECK);

        System.out.println("3- " + sm.getState().toString());

        sm.sendEvent(EmployeeEvent.FINISH_SECURITY_CHECK);

        System.out.println("4- " + sm.getState().toString());

        sm.sendEvent(EmployeeEvent.ACTIVATE);

        System.out.println("666- " + sm.getState().toString());

        sm.sendEvent(EmployeeEvent.FINISH_WORK_PERMIT_CHECK);

        System.out.println("5- " + sm.getState().toString());

        sm.sendEvent(EmployeeEvent.ACTIVATE);

        System.out.println("6- " + sm.getState().toString());

        sm.sendEvent(EmployeeEvent.BEGIN_CHECK);

        System.out.println("777- " + sm.getState().toString());
    }
}
