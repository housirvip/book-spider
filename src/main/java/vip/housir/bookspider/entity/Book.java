package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author housirvip
 */
@Data
public class Book implements Serializable {

    private Integer id;

    private String name;

    private String author;

    private String cover;

    private static final long serialVersionUID = 1L;
}