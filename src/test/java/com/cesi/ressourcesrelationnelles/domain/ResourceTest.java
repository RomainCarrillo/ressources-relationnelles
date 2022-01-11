package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResourceTest {

    @Test
    public void createResource() {

        Resource resource = new Resource();
        resource.setResourcesName("bar");
        assertNotNull(resource);
        assertEquals("bar", resource.getResourcesName());
    }
}
