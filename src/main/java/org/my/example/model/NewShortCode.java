package org.my.example.model;

import lombok.Data;


/**
 * maybe use this instead of shortened since validation is hard to conceal
 */
@Data
public class NewShortCode {

    private String code;
    private String url;

}
