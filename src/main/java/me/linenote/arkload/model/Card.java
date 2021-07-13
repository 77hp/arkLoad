package me.linenote.arkload.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {

    /**
     * 카드 이름
     */
    private String name;

    /**
     * 카드 최대 각인
     */
    private int awakeTotal;

    /**
     * 카드 현재 각인
     */
    private int awakeCount;

    /**
     * 카드 티어
     */
    private int tierGrade;

    /**
     * 카드 설명
     */
    private String description;
}
