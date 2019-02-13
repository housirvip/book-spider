package vip.housir.bookspider.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author housirvip
 */
@Data
public class SpiderTask implements Serializable {

    private Integer siteId;

    private String url;

    private List<String> urls;

    private TaskType type;

    private Integer thread;

    private static final long serialVersionUID = 1L;
}