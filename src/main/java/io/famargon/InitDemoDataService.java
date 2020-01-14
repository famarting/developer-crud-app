package io.famargon;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.famargon.developer.Developer;
import io.famargon.developer.DeveloperService;
import io.quarkus.runtime.StartupEvent;

/**
 * InitDemoDataService
 */
public class InitDemoDataService {

    @Inject
    DeveloperService developerService;

    @Transactional
    public void init(@Observes StartupEvent startupEvent) {
        if(Developer.count() == 0) {
            developerService.createDeveloper("jon doe", "python");
            developerService.createDeveloper("juan zuri", "java");
        }
    }

}