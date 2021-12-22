package com.notsay.user.config.users;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/22 17:43
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.users")
public class UsersConfig {
    private String type;
    private String url;
    private String username;
    private String password;
    private String uniqueResourceName;
}