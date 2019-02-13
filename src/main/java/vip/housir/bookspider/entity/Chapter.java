package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author housirvip
 */
@Data
public class Chapter implements Serializable {

    private Integer id;

    private String title;

    private Integer bookId;

    private Integer num;

    private String content;

    private static final long serialVersionUID = 1L;
}