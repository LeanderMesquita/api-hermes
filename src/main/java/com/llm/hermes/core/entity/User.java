package com.llm.hermes.core.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = {"id", "name"})
@Document(collection = "user")
public class User  implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts;
}
