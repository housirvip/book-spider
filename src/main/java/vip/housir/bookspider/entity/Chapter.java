package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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

    private String url;

    private List<String> urls;

    private static final long serialVersionUID = 1L;
}