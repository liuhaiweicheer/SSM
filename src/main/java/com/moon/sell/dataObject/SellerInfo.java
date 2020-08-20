package com.moon.sell.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import sun.nio.cs.FastCharsetProvider;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author lhw
 * @date 2020/8/18
 */

@Data
@Entity
@Proxy(lazy = false)
@DynamicUpdate
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;

}
