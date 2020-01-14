package io.famargon.developer;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.eclipse.microprofile.metrics.annotation.Timed;

/**
 * DeveloperService
 */
@Timed
// @Singleton
@ApplicationScoped
public class DeveloperService {

    DeveloperService() {
        //
    }

    public List<Developer> listAll() {
        return Developer.findAll().list();
    }

    public Developer createDeveloper(String name, String programmingLanguage) {
        Developer dev = new Developer();
        dev.name = name;
        dev.programmingLanguage = programmingLanguage;
        return create(dev);
    }

    @Transactional
    public Developer create(@Valid Developer dev) {
        if(Developer.find("name", dev.name).firstResult() != null) {
            throw new IllegalArgumentException("Developer already exists");
        }
        dev.persist();
        return dev;
    }
}