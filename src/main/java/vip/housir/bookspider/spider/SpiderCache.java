package vip.housir.bookspider.spider;

import lombok.Data;
import vip.housir.bookspider.entity.Rule;

import java.util.List;

/**
 * @author housirvip
 */
@Data
public class SpiderCache {

    private Boolean busy;

    private Integer bookId;

    private String siteId;

    private Integer domainId;

    private List<Rule> rules;
}
