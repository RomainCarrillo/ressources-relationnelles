package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void createResourceTest() {
        Resource resource = new Resource();
        resourceService.createResources(resource);
        List<Resource> actualResourceList = resourceService.list();
        assertNotNull(actualResourceList);
    }

}
