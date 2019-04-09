package com.gitub.xl137010393.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("|----------------------------------------|");
        log.info("|                                        |");
        log.info("|       Powered By www..com        |");
        log.info("|                                        |");
        log.info("|----------------------------------------|");
    }
}
