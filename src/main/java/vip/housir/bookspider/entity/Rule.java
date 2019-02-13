package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author housirvip
 */
@Data
public class Rule implements Serializable {

    private Integer id;

    private Integer domainId;

    private String type;

    private String key;

    private String xpath;

    private List<String> regexp;

    private static final long serialVersionUID = 1L;
}