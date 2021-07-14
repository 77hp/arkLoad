import me.linenote.arkload.model.Card;
import me.linenote.arkload.model.CardSet;
import me.linenote.arkload.model.Character;
import me.linenote.arkload.model.Skill;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.json.JsonException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CrawlingTest {
    public static void main(String[] args) throws IOException, JsonException {

        Connection.Response response = Jsoup
                .connect("https://lostark.game.onstove.com/Profile/Character/갈마동성심당")
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

        Character character = new Character();

        // 원정대 레벨
        Element expeditionLevel = document.selectFirst("div.level-info__expedition span:eq(1)");
        character.setExpeditionLevel(Integer.parseInt(expeditionLevel.ownText()));
        System.out.println("원정대 레벨 : " + character.getExpeditionLevel());

        // 전투 레벨
        Element battleLevel = document.selectFirst("div.level-info__item span:eq(1)");
        character.setBattleLevel(Integer.parseInt(battleLevel.ownText()));
        System.out.println("전투 레벨 : " + character.getBattleLevel());

        Element equipItemLevel = document.selectFirst("div.level-info2__expedition span:eq(1)");
        Element equipItemDecimalLevel = document.selectFirst("div.level-info2__expedition span:eq(1) small:eq(1)");
        character.setEquipItemLevel(Float.parseFloat(equipItemLevel.ownText().replaceAll(",", "") + equipItemDecimalLevel.ownText()));
        System.out.println("장착 아이템 레벨 : " + character.getEquipItemLevel());

        Element achievedItemLevel = document.selectFirst("div.level-info2__item span:eq(1)");
        Element achievedItemDecimalLevel = document.selectFirst("div.level-info2__item span:eq(1) small:eq(1)");
        character.setAchievedItemLevel(Float.parseFloat(achievedItemLevel.ownText().replace(",", "") + achievedItemDecimalLevel.ownText()));
        System.out.println("달성 아이템 레벨 : " + character.getAchievedItemLevel());

        // 칭호
        Element title = document.selectFirst("div.game-info__title span:eq(1)");
        character.setTitle(title.text());
        System.out.println("칭호 : " + character.getTitle());

        // 길드
        Element guild = document.selectFirst("div.game-info__guild span:eq(1)");
        character.setGuild(guild.text());
        System.out.println("길드 : " + character.getGuild());

        // PVP
        Element pvpClass = document.selectFirst("div.level-info__pvp span:eq(1)");
        character.setPvpClass(Integer.parseInt(pvpClass.text().replace("급", "")));
        System.out.println("PVP : " + character.getPvpClass() + "급");

        // 영지 레벨
        Element wisdomLevel = document.selectFirst("div.game-info__wisdom span:eq(1)");
        character.setWisdomLevel(Integer.parseInt(wisdomLevel.ownText()));
        System.out.println("영지 레벨 : " + character.getWisdomLevel());

        // 영지 이름
        Element wisdomName = document.selectFirst("div.game-info__wisdom span:eq(2)");
        character.setWisdomName(wisdomName.text());
        System.out.println("영지 이름 : " + character.getWisdomName());

        // 특수 장비(나침반)
        Element specialEquipCompass = document.selectFirst("ul.special-info__slot li:eq(0)");
        System.out.println("특수 장비 1 : " + specialEquipCompass.text());

        // 특수 장비(부적)
        Element specialEquipCharm = document.selectFirst("ul.special-info__slot li:eq(1)");
        System.out.println("특수 장비 2 : " + specialEquipCharm.text());

        // 특수 장비(문장)
        Element specialEquipSentence = document.selectFirst("ul.special-info__slot li:eq(2)");
        System.out.println("특수 장비 3 : " + specialEquipSentence.text());

        // 기본 특성 - 공격력
        Element select11 = document.selectFirst("div.profile-ability-basic ul li:eq(0) span:eq(1)");
        System.out.println("기본 특성 - 공격력 : " + select11.text());

        // 기본 특성 - 최대 생명력
        Element select12 = document.selectFirst("div.profile-ability-basic ul li:eq(1) span:eq(1)");
        System.out.println("기본 특성 - 최대 생명력 : " + select12.text());

        // 전투 특성 - 치명
        Element abilityFatal = document.selectFirst("div.profile-ability-battle ul li:eq(0) span:eq(1)");
        character.setAbilityFatal(Integer.parseInt(abilityFatal.text()));
        System.out.println("전투 특성 - 치명 : " + character.getAbilityFatal());

        // 전투 특성 - 특화
        Element abilitySpecialized = document.selectFirst("div.profile-ability-battle ul li:eq(1) span:eq(1)");
        character.setAbilitySpecialized(Integer.parseInt(abilitySpecialized.text()));
        System.out.println("전투 특성 - 특화 : " + character.getAbilitySpecialized());

        // 전투 특성 - 제압
        Element abilitySuppress = document.selectFirst("div.profile-ability-battle ul li:eq(2) span:eq(1)");
        character.setAbilitySuppress(Integer.parseInt(abilitySuppress.text()));
        System.out.println("전투 특성 - 제압 : " + character.getAbilitySuppress());

        // 전투 특성 - 신속
        Element abilityFast = document.selectFirst("div.profile-ability-battle ul li:eq(3) span:eq(1)");
        character.setAbilityFast(Integer.parseInt(abilityFast.text()));
        System.out.println("전투 특성 - 신속 : " + character.getAbilityFast());

        // 전투 특성 - 인내
        Element abilityPatience = document.selectFirst("div.profile-ability-battle ul li:eq(4) span:eq(1)");
        character.setAbilityPatience(Integer.parseInt(abilityPatience.text()));
        System.out.println("전투 특성 - 인내 : " + character.getAbilityPatience());

        // 전투 특성 - 숙련
        Element abilitySkill = document.selectFirst("div.profile-ability-battle ul li:eq(5) span:eq(1)");
        character.setAbilitySkill(Integer.parseInt(abilitySkill.text()));
        System.out.println("전투 특성 - 숙련 : " + character.getAbilitySkill());

        // 각인 효과
        Elements select19 = document.select("ul.swiper-slide li span");
        for (Element element : select19) {
            System.out.println(element.text());
        }

        Element script3 = document.getElementsByTag("script").get(2);

        String s = script3.data().replaceAll("(\\$.Profile = )", "").replaceAll("};", "}");
        System.out.println(s);
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

//    Iterator keys = jsonObject.keys();
//    while (keys.hasNext()) {
//      String key = keys.next().toString();
//      System.out.println("키 : " + key);
//
//      JSONObject inKey = jsonObject.getJSONObject(key);
//      Iterator keys1 = inKey.keys();
//      while (keys1.hasNext()) {
//        System.out.println("테스트 : " + keys1.next());
//      }
//    }
//    키 : Equip
//    키 : CardSet

//    키 : Equip
//    키 : Skill
//    키 : CardSet
//    키 : Card

        List<Card> cards = new ArrayList<>();
        List<CardSet> cardSets = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();

        JSONObject cardElement1 = jsonObject.getJSONObject("Card");
        cardElement1.keySet().forEach(k1 -> {
            JSONObject cardElement2 = cardElement1.getJSONObject(k1);
            JSONObject element_000 = cardElement2.getJSONObject("Element_000"); // 카드 이름
            JSONObject element_001 = cardElement2.getJSONObject("Element_001"); // 카드 각 상태 및 등급
            JSONObject element_002 = cardElement2.getJSONObject("Element_002"); // 카드 설명

            String cardName = element_000.getString("value");
            int awakeCount = element_001.getJSONObject("value").getInt("awakeCount");
            int awakeTotal = element_001.getJSONObject("value").getInt("awakeTotal");
            int tierGrade = element_001.getJSONObject("value").getInt("tierGrade");
            String description = element_002.getString("value");

            Card card = new Card();
            card.setName(cardName);
            card.setAwakeTotal(awakeTotal);
            card.setAwakeCount(awakeCount);
            card.setTierGrade(tierGrade);
            card.setDescription(description);
            cards.add(card);

            System.out.println(card);
        });

        JSONObject cardSetElement1 = jsonObject.getJSONObject("CardSet");
        cardSetElement1.keySet().forEach(k1 -> {
            JSONObject cardSetElement2 = cardSetElement1.getJSONObject(k1);
            cardSetElement2.keySet().forEach(k2 -> {
                if (!k2.equals("EffectIndex")) {
                    JSONObject cardSetElement3 = cardSetElement2.getJSONObject(k2);

                    String name = cardSetElement3.getString("title");
                    String description = cardSetElement3.getString("desc");

                    CardSet cardSet = new CardSet();
                    cardSet.setName(name);
                    cardSet.setDescription(description);
                    cardSets.add(cardSet);

                    System.out.println(cardSet);
                }
            });
        });

        JSONObject skillElement1 = jsonObject.getJSONObject("Skill");
        skillElement1.keySet().forEach(k1 -> {
            System.out.println("k1 : " + k1);
            JSONObject skillElement2 = skillElement1.getJSONObject(k1);

            JSONObject element_000 = skillElement2.getJSONObject("Element_000"); // 스킬 이름
            JSONObject element_001 = skillElement2.getJSONObject("Element_001"); // 스킬 종류
            JSONObject element_003 = skillElement2.getJSONObject("Element_003"); // 스킬 레벨






            String skillName = element_000.getString("value");
            String skillType = element_001.getJSONObject("value").getString("level");
            String skillLevel = element_003.getString("value");





            System.out.println(skillName);
            System.out.println(skillType);
            System.out.println(skillLevel);
//            JSONObject element_001 = skillElement2.getJSONObject("Element_001");
//            JSONObject element_002 = skillElement2.getJSONObject("Element_002");
//            JSONObject element_003 = skillElement2.getJSONObject("Element_003");
//            JSONObject element_004 = skillElement2.getJSONObject("Element_004");
//            JSONObject element_005 = skillElement2.getJSONObject("Element_005");

//            skillElement2.keySet().forEach(k2 -> {
//                System.out.println(k2);
//                JSONObject skillElement3 = skillElement2.getJSONObject(k2);
//            });
//      String skillName = element_000.getString("value");
        });


        // 장비
//    Elements select20 = document.getAllElements();
//    for (int i = 0; i < select20.size(); i++) {
//      System.out.println(select20.get(i).text());
//    }

        character.setCardSets(cardSets);
        character.setCards(cards);
    }
}
