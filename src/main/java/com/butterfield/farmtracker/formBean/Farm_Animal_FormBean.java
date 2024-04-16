package com.butterfield.farmtracker.formBean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Farm_Animal_FormBean {
    private Integer id;

    private String name;

    private String alt_name;

    private Integer type;

    private String sex;

    private Integer dead;

    // TODO: Might need to rework this or something, in-case cow was not sold.
    private Integer sold;

    private String note;
}
