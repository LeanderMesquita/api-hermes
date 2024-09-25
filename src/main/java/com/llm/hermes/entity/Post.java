package com.llm.hermes.entity;

import com.llm.hermes.dto.AuthorDTO;
import com.llm.hermes.dto.CommentDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private String title;
    private String body;
    private Date date;

    private AuthorDTO author;
    private List<CommentDTO> comments;
}
