package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author housirvip
 */
@Data
public class Rule implements Serializable {

    private Integer id;

    private Integer domainId;

    private String type;

    private String name;

    private String xpath;

    private List<Map> pattern;

    private static final long serialVersionUID = 1L;
}