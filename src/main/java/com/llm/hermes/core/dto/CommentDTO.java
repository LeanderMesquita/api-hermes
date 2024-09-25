package com.llm.hermes.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO author;

}
