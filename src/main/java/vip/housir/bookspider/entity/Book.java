package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author housirvip
 */
@Data
public class Book implements Serializable {

    private Integer id;

    private Integer siteId;

    private String name;

    private String author;

    private String cover;

    private String url;

    private List<String> urls;

    private Integer thread;

    private static final long serialVersionUID = 1L;
}