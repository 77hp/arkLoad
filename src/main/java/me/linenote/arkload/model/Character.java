package me.linenote.arkload.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 정보
 */
@Getter
@Setter
@ToString
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
  private float equipItemLevel;

  /**
   * 달성 아이템 레벨
   */
  private float achievedItemLevel;

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
  private String wisdomName;

  /**
   * 영지 레벨
   */
  private int wisdomLevel;

  /**
   * 전투 특성 - 치명
   */
  private int abilityFatal;

  /**
   * 전투 특성 - 특화
   */
  private int abilitySpecialized;

  /**
   * 전투 특성 - 제압
   */
  private int abilitySuppress;

  /**
   * 전투 특성 - 신속
   */
  private int abilityFast;

  /**
   * 전투 특성 - 인내
   */
  private int abilityPatience;

  /**
   * 전투 특성 - 숙련
   */
  private int abilitySkill;

  /**
   * 카드
   */
  private List<Card> cards;

  /**
   * 카드 세트
   */
  private List<CardSet> cardSets;

  // TODO : 캐릭터 정보 추가 예정
}
