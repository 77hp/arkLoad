package me.linenote.arkload.model;

import java.util.List;

/**
 * 캐릭터 정보
 */
public class Character {

  /**
   * 캐릭터 이름
   */
  private String name;

  /**
   * 원정대 레벨
   */
  private int expeditionLevel;

  /**
   * 전투 레벨
   */
  private int battleLevel;

  /**
   * 장착 아이템 레벨
   */
  private int itemLevel;

  /**
   * 달성 아이템 레벨
   */
  private int achieveItemLevel;

  /**
   * 칭호
   */
  private String title;

  /**
   * 길드
   */
  private String guild;

  /**
   * pvp 급
   */
  private int pvpClass;

  /**
   * 영지 이름
   */
  private String wisdom;

  /**
   * 영지 레벨
   */
  private int wisdomLevel;

  /**
   * 특수장비 (나침반, 부적, 문장)
   */
  private List<Item> specialItems;

  // TODO : 캐릭터 정보 추가 예정
}
