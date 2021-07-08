package me.linenote.arkload;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlingTest {
  public static void main(String[] args) throws IOException, JSONException {

    Connection.Response response = Jsoup
        .connect("https://lostark.game.onstove.com/Profile/Character/갈마동갈매기")
        .method(Connection.Method.GET)
        .execute();
    Document document = response.parse();

//    Pattern memberNoPattern = Pattern.compile("_memberNo = \\'.+\\'");
//    Pattern pcIdPattern = Pattern.compile("_pcId = \\'.+\\'");
//    Pattern worldNoPattern = Pattern.compile("_worldNo = \\'.+\\'");
//
//    // 13 번째 script 태그안에는 회원 정보가 담겨있습니다.
//    // _memberNo : 회원의 고유 번호
//    // _pcId : 미확인
//    // _worldNo : 서버 고유 번호
//    Element script = document.getElementsByTag("script").get(12);
//    String scriptData = script.data();
//    Matcher memberNoMatcher = memberNoPattern.matcher(scriptData);
//    Matcher pcIdMatcher = pcIdPattern.matcher(scriptData);
//    Matcher worldNoMatcher = worldNoPattern.matcher(scriptData);
//
//    System.out.println(memberNoMatcher.find());
//    System.out.println(pcIdMatcher.find());
//    System.out.println(worldNoMatcher.find());
//
//    // 원정대 레벨
//    Element select = document.selectFirst("div.level-info__expedition span:eq(1)");
//    System.out.println("원정대 레벨 : " + select.ownText());
//
//    // 전투 레벨
//    Element select2 = document.selectFirst("div.level-info__item span:eq(1)");
//    System.out.println("전투 레벨 : " + select2.ownText());
//
//    Element select111 = document.selectFirst("div.level-info2__expedition span:eq(1)");
//    Element select1111 = document.selectFirst("div.level-info2__expedition span:eq(1) small:eq(1)");
//    System.out.println("장착 아이템 레벨 : " + select111.ownText()+select1111.ownText());
//
//    Element select222 = document.selectFirst("div.level-info2__item span:eq(1)");
//    Element select2222 = document.selectFirst("div.level-info2__item span:eq(1) small:eq(1)");
//    System.out.println("달성 아이템 레벨 : " + select222.ownText()+select2222.ownText());
//
//    // 칭호
//    Element select3 = document.selectFirst("div.game-info__title span:eq(1)");
//    System.out.println("칭호 : " + select3.text());
//
//    // 길드
//    Element select4 = document.selectFirst("div.game-info__guild span:eq(1)");
//    System.out.println("길드 : " + select4.text());
//
//    // PVP
//    Element select5 = document.selectFirst("div.level-info__pvp span:eq(1)");
//    System.out.println("PVP : " + select5.text().split("급")[0]);
//
//    // 영지 레벨
//    Element select6 = document.selectFirst("div.game-info__wisdom span:eq(1)");
//    System.out.println("영지 레벨 : " + select6.ownText());
//
//    // 영지 이름
//    Element select7 = document.selectFirst("div.game-info__wisdom span:eq(2)");
//    System.out.println("영지 이름 : " + select7.text());
//
//    // 특수 장비 1
//    Element select8 = document.selectFirst("ul.special-info__slot li:eq(0)");
//    System.out.println("특수 장비 1 : " + select8.text());
//
//    // 특수 장비 2
//    Element select9 = document.selectFirst("ul.special-info__slot li:eq(1)");
//    System.out.println("특수 장비 2 : " + select9.text());
//
//    // 특수 장비 3
//    Element select10 = document.selectFirst("ul.special-info__slot li:eq(2)");
//    System.out.println("특수 장비 3 : " + select10.text());
//
//    // 기본 특성 - 공격력
//    Element select11 = document.selectFirst("div.profile-ability-basic ul li:eq(0) span:eq(1)");
//    System.out.println("기본 특성 - 공격력 : " + select11.text());
//
//    // 기본 특성 - 최대 생명력
//    Element select12 = document.selectFirst("div.profile-ability-basic ul li:eq(1) span:eq(1)");
//    System.out.println("기본 특성 - 최대 생명력 : " + select12.text());
//
//    // 전투 특성 - 치명
//    Element select13 = document.selectFirst("div.profile-ability-battle ul li:eq(0) span:eq(1)");
//    System.out.println("전투 특성 - 치명 : " + select13.text());
//
//    // 전투 특성 - 특화
//    Element select14 = document.selectFirst("div.profile-ability-battle ul li:eq(1) span:eq(1)");
//    System.out.println("전투 특성 - 특화 : " + select14.text());
//
//    // 전투 특성 - 제압
//    Element select15 = document.selectFirst("div.profile-ability-battle ul li:eq(2) span:eq(1)");
//    System.out.println("전투 특성 - 제압 : " + select15.text());
//
//    // 전투 특성 - 신속
//    Element select16 = document.selectFirst("div.profile-ability-battle ul li:eq(3) span:eq(1)");
//    System.out.println("전투 특성 - 신속 : " + select16.text());
//
//    // 전투 특성 - 인내
//    Element select17 = document.selectFirst("div.profile-ability-battle ul li:eq(4) span:eq(1)");
//    System.out.println("전투 특성 - 인내 : " + select17.text());
//
//    // 전투 특성 - 숙련
//    Element select18 = document.selectFirst("div.profile-ability-battle ul li:eq(5) span:eq(1)");
//    System.out.println("전투 특성 - 숙련 : " + select18.text());
//
//    // 각인 효과
//    Elements select19 = document.select("ul.swiper-slide li span");
//    for (Element element : select19) {
//      System.out.println(element.text());
//    }

    Element script1 = document.getElementsByTag("script").get(0);
    Element script2 = document.getElementsByTag("script").get(1);
    Element script3 = document.getElementsByTag("script").get(2);
    Element script4 = document.getElementsByTag("script").get(3);
    Element script5 = document.getElementsByTag("script").get(4);
    Element script6 = document.getElementsByTag("script").get(5);
    Element script7 = document.getElementsByTag("script").get(6);
    Element script8 = document.getElementsByTag("script").get(7);
    Element script9 = document.getElementsByTag("script").get(8);
    Element script10 = document.getElementsByTag("script").get(9);
    Element script11 = document.getElementsByTag("script").get(10);
    Element script12 = document.getElementsByTag("script").get(11);

//    System.out.println("1 : " + script1.data());
//    System.out.println("2 : " + script2.data());
//    System.out.println("3 : " + script3.data());
//    System.out.println("4 : " + script4.data());
//    System.out.println("5 : " + script5.data());
//    System.out.println("6 : " + script6.data());
//    System.out.println("7 : " + script7.data());
//    System.out.println("8 : " + script8.data());
//    System.out.println("9 : " + script9.data());
//    System.out.println("10 : " + script10.data());
//    System.out.println("11 : " + script11.data());
//    System.out.println("12 : " + script12.data());

    String s = script3.data().replaceAll("(\\$.Profile = )", "").replaceAll("};", "}");
//    System.out.println(script3.data().replaceAll("(\\$.Profile = )", "").replaceAll("};", ""));
//    final Pattern pattern = Pattern.compile("(\\t\\t\\$.Profile)(.*?)(};)");


//    final Pattern pattern = Pattern.compile("(\\$.Profile)(.*?)(};)");
//    Matcher matcher = pattern.matcher(script3.data());
//
//    if(matcher.find()) {
//      System.out.println("실행");
//      System.out.println(matcher.group(2));
//    } else {
//      System.out.println("안됨");
//    }

//    System.out.println(matcher.group(3));
    JSONObject jsonObject = new JSONObject(s);

    Iterator keys = jsonObject.keys();
    while (keys.hasNext()) {
      System.out.println("키 : " + keys.next());

      JSONObject inKey = jsonObject.getJSONObject((String) keys.next());
    }


    JSONObject equip = jsonObject.getJSONObject("Equip");
    Iterator equipKeys = equip.keys();
    while (equipKeys.hasNext()) {
      System.out.println("장비 : " + equipKeys.next());
    }

    JSONObject skill = jsonObject.getJSONObject("Skill");
    Iterator skillKeys = skill.keys();
    while (skillKeys.hasNext()) {
      System.out.println("스킬 : " + skillKeys.next());
    }

    JSONObject cardSet = jsonObject.getJSONObject("CardSet");
    Iterator cardSetKeys = cardSet.keys();
    while (cardSetKeys.hasNext()) {
      System.out.println("카드셋 : " + cardSetKeys.next());
    }

    JSONObject card = jsonObject.getJSONObject("Card");
    Iterator cardKeys = card.keys();
    while (cardKeys.hasNext()) {
      System.out.println("카드 : " + cardKeys.next());
    }


    // 장비
//    Elements select20 = document.getAllElements();
//    for (int i = 0; i < select20.size(); i++) {
//      System.out.println(select20.get(i).text());
//    }
  }
}
