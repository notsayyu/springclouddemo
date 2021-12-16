package com.notsay.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSaveDTO {
    private String name;

    private String content;
}