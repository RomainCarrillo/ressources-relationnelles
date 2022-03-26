package java.com.cesi.ressourcesrelationnelles.test.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cesi.ressourcesrelationnelles.domain.Resource;

public class ResourceTest {

    @Test
    public void createResource() {

        Resource resource = new Resource();
        resource.setResourcesName("bar");
        assertNotNull(resource);
        assertEquals("bar", resource.getResourcesName());
    }
}
