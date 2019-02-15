package vip.housir.bookspider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author housirvip
 */
@Data
@AllArgsConstructor
public class PageDto implements Serializable {

    private Integer pageNum;

    private Integer pageSize;
}
