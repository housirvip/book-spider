package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author housirvip
 */
@Data
public class Domain implements Serializable {

    private Integer id;

    private String domain;

    private String url;

    private String name;

    private Integer thread;

    private Integer bookId;

    private Integer chapterId;

    private List<Rule> rules;

    private static final long serialVersionUID = 1L;
}