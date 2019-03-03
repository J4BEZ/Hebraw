import java.util.ArrayList;

class hcs{//히브리어 알파벳 배열
	String alphabet, hebname, index, korName, uniName = null;
	String range[], KoRange[], shape, number = null;
	java.net.URL alphabetInf = null;
	//2차원배열을 이용해서 range 와 KoRange를 등록해보자
	
	//생성자 엄청기넹
	hcs(String alphabet, String hebname, String index, String korName, String uniName,
		String shape, String number, String range[]
			/*, java.net.URL alphabetInf*/){
		this.alphabet = alphabet; this.hebname = hebname; this.index = index;
		this.korName = korName; this.uniName = uniName; this.shape = shape; this.number = number;
		this.range = range; this.KoRange = KoRange;
		
		this.alphabetInf = hcs.class.getResource(uniName+"html");
		//자바 베이스 프로그램인데 Html파일이 더 많을 것 같은건 기분 타시에오
	}
}

public class hebConsonant {
	ArrayList<hcs> CS = new ArrayList<hcs>();
	
	String []alph= {"א","ב","בּ","ג","גּ", 	"ד","דּ","ה","ו","ז",
					"ח","ט","י","כ","ך",		"כּ","ךּ","ל","מ","ם",
					"נ","ן","ס","ע","פ",		"ף","פּ","ףּ","צ","ץ",
					"ק","ר","שׂ","שׁ","ת","תּ"};
	
	String []hbname = {"אָלֶף","בֵית","	בֵּית","גִימֶל","	גִּימֵל",	"דָלֶת","דָּלֶת","הֵא","וָו","זַין",
					   "חֵית","טֵית","יוֹד","כַף","כַף סוֹפִית",	"כַּף","כַּף סוֹפִית","לָמֶד","מֵם","מֵם סוֹפִית",
					   "נוּן","נוּן סוֹפִית","סָמֶךְ","עַיִן","פֵא",	"פֵא סוֹפִית","פֵּא","פֵּא סוֹפִית","צָדֵי","צָדֵי סוֹפִית",
					   "קוֹף","רֵישׁ","שִׂין","שִׁין","תָו","תָּו"};
	
	String []idx = {"1.","2.","2-1.","3.","3-1.", 	"4.","4-1.","5.","6.","7.",
					"8.","9.","10.","11.","11-1.",		"11-2.","11-3.","12.","13.","13-1.",
					"14.","14-1.","15.","16.","17.",		"17-2.","17-3.","17-4.","18.","18-2.",
					"19.","20.","21.","21-2.","22.","22-1."};
	
	String []korN = {"알레프","베 트","베 트","기멜","기멜", 	"달레트","달레트","헤","바브","쟈인",
					"헤트","테트","요드","카프","<font size=5>카프 소핏</font>",		"카프","<font size=5>카프 소핏</font>","라메드","멤","<font size=5>멤 소핏</font>",
					"눈","<font size=5>눈 소핏</font>","싸메크","아인","페",		"페 소핏","페","페 소핏","짜디","<font size=5>짜디 소핏</font>",
					"코프","레쉬","신","쉰","타브","타브"};
	
	String []uniN = {"Alef","Bet","Bet","Gimel","Gimel", 	"Dalet","Dalet","He","Vav","Zayin",
					"Het","Tet","Yod","Kaf","<font size=4>Kaf Sofit</font>",	"Kaf","<font size=4>Kaf Sofit</font>","Lamed","Mem","<font size=5>Mem Sofit</font>",
					"Nun","<font size=5>Nun Sofit</font>","Samekh","Ayin","Pe",		"Pe Sofit","Pe","Pe Sofit","Tsadi","<font size=4>Tsadi Sofit</font>",
					"Qof","Resh","Sin","Shin","Tav","Tav"};
	
	String []shape = {"황소","집","집","낙타","낙타", 	"문","문","숨구멍","갈고리","무기",
					"울타리","뱀","손","굽은 손","굽은 손",		"굽은 손","굽은 손","소몰이막대","물","물",
					"물고기","물고기","버팀대","눈","입",		"입","입","입","낚싯바늘","낚싯바늘",
					"바늘귀","머리","아랫니","윗니","십자,표시","십자,표시"};
	
	String []num = {"1","2","2","3","3", 	"4","4","5","6","7",
					"8","9","10","20","500",	"20","500","30","40","600",
					"50","700","60","70","80",		"800","80","800","90","900",
					"100","200","300","300","400","400"};
	
	//TODO 빈 발음 부분 마저 채우기
	String [][]rang = {{"ɔ","(묵음)"},{"","v"},{"b"},{"","gh"},{"g"},	{"","dh"},{"d"},{"h"},{"v","w"},{"z"},
					   {""},{""},{"y"},{"","","kh"},{"","","kh"},	{"k"},{"k"},{"l"},{"m"},{"m"},
					   {"n"},{"n"},{"s"},{"c","(묵음)"},{"","f","ph"},	{"","f","ph"},{"p"},{"p"},{"","ts"},{"","ts"},
					   {"q"},{"r"},{""},{""},{"","th","ʃ"},{"t"}};
	
	String [][]KoRang = {{""},{""},{""},{""},{""},	{""},{""},{""},{""},{""},
			   			 {""},{""},{""},{""},{""},	{""},{""},{""},{""},{""},
			   			 {""},{""},{""},{""},{""},	{""},{""},{""},{""},{""},
			   			 {""},{""},{""},{""},{""},{""}};
	
	hebConsonant(){
		for(int i=0; i<alph.length; i++) {
			CS.add(new hcs(alph[i],hbname[i],idx[i],korN[i],uniN[i],shape[i],num[i],rang[i]));
		}
	}

}
