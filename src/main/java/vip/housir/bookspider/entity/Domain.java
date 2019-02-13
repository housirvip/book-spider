package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author housirvip
 */
@Data
public class Domain implements Serializable {

    private Integer id;

    private String domain;

    private String name;

    private Integer bookId;

    private Integer chapterId;

    private static final long serialVersionUID = 1L;
}