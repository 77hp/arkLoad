package me.linenote.arkload.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardSet {

    /**
     * 세트 이름
     */
    private String name;

    /**
     * 세트 설명
     */
    private String description;
}
