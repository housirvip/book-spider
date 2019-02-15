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

    private String name;

    private String author;

    private String cover;

    private List<Chapter> chapters;

    private static final long serialVersionUID = 1L;
}