package com.cesi.ressourcesrelationnelles.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Resource")
public class Resource {

    @Id
    private String id;
    private String creatorId;
    private String resourceName;
    private int resourceType;
}
