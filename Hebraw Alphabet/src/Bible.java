import java.util.ArrayList;

class bibleList{
	String bible, ChapterNVerse;
	bibleList(String bible, String CNV){
		this.bible = bible; this.ChapterNVerse = CNV;
	}
}

public class Bible {
	ArrayList<bibleList> bibleList = new ArrayList<bibleList>();
	
	String Bible[] = {"여호와 그가 네 앞서 행하시며 너와 함께하사 <br>너를 떠나지 아니하시며 버리지 아니하시리니<br> 너는 두려워 말라 놀라지 말라",
					  "하나님이 이르시되 <br>그가나를 사랑한즉 내가 그를 건지리라<br>그가 내 이름을 안즉 내가 그를 높이리라<br>그가 내게 간구하리니 내가 그에게 응답하리라",
					  "너의 평생에 너를 능히 당할 자 없으리니<br>내가 모세와 함께 있던것 같이 <br>너와 함께 있을 것임이라<br>내가 너를 떠나지 아니하며 버리지 아니하리니",
					  "두려워 말라 내가 너와 함께함이라<br>놀라지 말라 나는 네 하나님이 됨이니라<br>내가 너를 굳세게 하리라 참으로 너를 도와주리라<br>참으로 나의 의로운 오른손으로 너를 붙들리라",
					  "평안을 너희에게 끼치노니<br>곧 나의 평안을 너희에게 주노라<br>내가 너희에게 주는 것은<br>세상이 주는 것 같지 아니하니라<br>너희는 마음에 근심도 말고 두려워하지도 말라",
					  "사람이 마음으로 자기의 길을 계획할지라도<br><br>그 걸음을 인도하는 자는 여호와시니라",
					  "믿음의 기도는 병든 자를 구원하리니<br>주께서 저를 일으키시리라<<br>혹시 죄를 범하였을찌라도<br>사하심을 얻으리라",
					  "사람이 감당할 시험 밖에는<br>너희에게 당한 것이 없나니 오직 하나님은 미쁘사 <br>너희가 감당치 못할 시험을 허락지 아니하시고<br>시험을 당할 즈음에 또한 피할길을 내사<br>너희로 능히 감당하게 하시느니라",
					  "내가 사망의 음침한 골짜기로 다닐찌라도<br>해를 두려워하지 않을 것은<br>주께서 나와 함께 하심이라<br>주의 지팡이와 막대기가 나를 안위하시나이다",
					  "여호와는 네게 복을 주시고 <br>너를 지키시기를 원하며 여호와는 그 얼굴로<br>네게 비취사 은혜 베푸시기를 원하며<br>여호와는 그 얼굴을 네게로 향하여 드사<br>평강 주시기를 원하노라 할찌니라 하라",
					  "여호와는 마음이 상한 자에게 가까이 하시고<br>중심에 통회하는 자를 구원하시는 도다",
					  "의인은 고난이 많으나 여호와께서<br>그 모든 고난에서 건지시는도다<br>그 모든 뼈를 보호하심이여<br>그 중에 하나도 꺾이지 아니하도다",
					  "내 의의 하나님이여<br>내가 부를 때에 응답하소서<br>곤란 중에 나를 너그럽게 하셨사오니<br>나를 긍휼히 여기사 나의 기도를 들으소서",
					  "네 짐을 여호와께 맡겨버리라<br>너를 붙드시고 의인의 요동함을<br>영영히 허락지 아니하시리로다",
					  "네 영혼아 네가 어찌하여 낙망하며<br>어찌하여 내 속에서 불안하여 하는고<br>너는 하나님을 바라라<br>그 얼굴의 도우심을 인하여<br>내가 오히려 찬송하리로다",
					  "무릇 징계가 당시에는 즐거워 보이지 않고<br>슬퍼보이나 후에 그로 말미암아<br>연달한 자에게는 의의 평강한 열매를 맺나니",
					  "내가 여호와를 가리켜 말하기를<br>저는 나의 피난처요 나의 요새요<br>나의 의뢰하는 하나님이라 하리니",
					  "너의 하나님 여호와가 너의 가운데 계시니<br>그는 구원을 베푸실 전능자시라<br>그가 너로 인하여 기쁨을 이기지 못하여 하시며<br>너를 잠잠히 사랑하시며 너로 인하여<br>즐거이 부르며 기뻐하시리라 하리라",
					  "너희 염려를 다 주께 맡겨 버리라<br>이는 저가 너희를 권고하심이니라",
					  "그러므로 하나님의 능하신 손 아래서<br>겸손하라 때가되면 너희를 높이시리라",
					  "내가 여호와를 항상 내 앞에 모심이여<br>그가 나의 오른쪽에 계시므로<br>내가 흔들리지 아니하리로다",
					  "나를 사랑하는 자들이 나의 사랑을 입으며<br><br>나를 간절히 찾는자가 나를 만날 것이니라",
					  "<font size = 5>아무 것도 염려하지말고<br>다만 모든 일에 기도와 간구로<br>너희의 구할 것을 감사함으로 하나님께 아뢰라<br>그리하면 모든 지각에 뛰어난 하나님의 평강이<br>그리스도 예수 안에서<br>너희 마음과 생각을 지키시리라</font>",
					  "생각건대 현재의 고난은<br>장차 우리에게 나타날 영광과<br>족히 비교할 수 없도다",
					  "나는 주의 힘을 노래하며<br>아침에 주의 인자하심을 높이 부르오리니<br>주는 나의 산성이시며<br>나의 환난 날에 피난처심이니이다",
					  "너의 평생에 너를 능히 당할 자 없으리니<br>내가 모세와 함께 있던것 같이<br>너와 함께 있을 것임이라<br>내가 너를 떠나지 아니하며 버리지 아니하리니",
					  "한 사람의 순종치 아니함으로<br>많은 사람이 죄인 된것 같이<br>한 사람의 순종하심으로<br>많은 사람이 의인이 되리라",
					  "이는 보좌 가운데 계신 어린 양이<br>저희의 목자가 되사 생명수 샘으로 인도하시고<br>하나님께서 저희 눈에서 모든 눈물을<br>씻어 주실 것임이러라",
					  "너희 믿음의 시련이<br>불로 연단하여도 없어질 금보다 더 귀하여<br>예수 그리스도의 나타나실 때에<br>칭찬과 영광과 존귀를 얻게하려 함이라",
					  "<font size = 5>우리 주 예수 그리스도로 말미암아<br>우리에게 이김을 주시는 하나님께 감사하노니<br>그러므로 내 사랑하는 형제들아<br>견고하며 흔들리지 말며 항상 주의 일에<br>더욱 힘쓰는 자들이 되라  이는 너희의 수고가<br>주 안에서 헛되지 않은 줄을 앎이니라</font>",
					  "네가 나가 대적과 싸우려할 때에<br>말과 병거와 민중이 너보다 많음을 볼찌라도<br>그들을 두려워 말라<br>애굽 땅에서 너를 인도하여 내신<br>네 하나님 여호와께서 너와 함께 하시느니라",
					  "사랑하는 자여 네 영혼이 잘 됨같이<br><br>네가 범사에 잘 되고 강건하기를 내가 간구하노라",
					  "우리가 사랑함은<br><br>그가 먼저 우리를 사랑하셨음이라",
					  "내가 여호와께 구하매 내게 응답하시고<br><br>내 모든 두려움에서 나를 건지셨도다",
					  "<font size = 5>이르시기를 너희는 가만히 있어<br>내가 하나님 됨을 알찌어다</font><br><font size =4>내가 열방과 세계 중에서 높임을 받으리라 하시도다</font><br><font size=5>만군의 여호와께서 우리와 함께하시니<br>야곱의 하나님은 우리의 피난처시로다 <font face= Serif color = #00B992>סֶֽלָה׃</font></font>",
					  "시험을 참는 자는 복이 있도다<br>이것에 옳다 인정하심을 받은 후에<br>주께서 자기를 사랑하는 자들에게 약속하신<br>생명의 면류관을 얻을 것임이니라",
					  "여호와께 감사하라 저는 선하시며<br><br>그 인자하심이 영원함이로다",
					  "여호와는 나의 능력과 찬송이시요<br><br>또 나의 구원이 되셨도다",
					  "나 여호와가 말하노라<br>너희를 향한 나의 생각은 내가 아나니<br>재앙이 아니라 곧 평안이요<br>너희 장래에 소망을 주려하는 생각이라",
					  "너희는 내게 부르짖으며 와서 내게 기도하면<br>내가 너희를 들을 것이요<br>너희가 전심으로 나를 찾고 찾으면<br>나를 만나리라",
					  "나 여호와가 말하노라 내가 너희에게 만나지겠고<br>너희를 포로된 중에서 다시 돌아오게 하되<br>내가 쫓아 보내었던 열방과 모든 곳에서 모아<br>사로잡혀 떠나게 하던 본 곳으로 돌아오게 하리라<br>여호와의 말이니라 하셨느니라",
					  "오라 우리가 여호와께로 돌아가자<br>여호와께서 우리를 찢으셨으나<br>도로 낫게 하실 것이요<br>우리를 치셨으나 싸매어 주실 것임이라",
					  "이와 같이 성령도 우리 연약함을 도우시나니<br>우리가 마땅히 빌바를 알지 못하나<br>오직 성령이 말할 수 없는 탄식으로<br>우리를 위하여 친히 간구하시느니라",
					  "내게 이르시기를 내 은혜가 네게 족하도다<br>이는 내 능력이 약한데서 온전하여짐이라 하신지라<br>이러므로 도리어 크게 기뻐함으로<br>나의 여러 약한 것들에 대하여 자랑하리니<br>이는 그리스도의 능력으로 내게 머물게 하려함이라"
					  
	};
	
	String CNV[] = {"(신명기 8: 31)",
					"(시편 91: 14 ~ 15)",
					"(여호수아 1: 9)",
					"(이사야 41: 10)",
					"(요한복음 14: 27)",
					"(잠언 16: 9)",
					"(야고보서 5: 15)",
					"(고린도전서 10: 13)",
					"(시편 23: 4)",
					"(민수기 6: 24 ~ 26)",
					"(시편 34: 18)",
					"(시편 34: 19 ~ 20)",
					"(시편 4: 1)",
					"(시편 55: 22)",
					"(시편 42: 5)",
					"(히브리서 12: 11)",
					"(시편 91: 2)",
					"(스바냐 3: 17)",
					"(베드로전서 5: 7)",
					"(베드로전서 5: 6)",
					"(시편 16: 8)",
					"(잠언 8: 17)",
					"(빌립보서 4: 6 ~ 7)",
					"(로마서 8: 18)",
					"(시편 59: 16)",
					"(여호수아 1: 5)",
					"(로마서 5: 19)",
					"(요한계시록 7: 17)",
					"(베드로전서  1: 7)",
					"(고린도전서 15: 57 ~ 58)",
					"(신명기 20: 1)",
					"(요한3서 1: 2)",
					"(요한1서 4: 19)",
					"(시편 34: 4)",
					"(시편 46: 10 ~ 11)",
					"(야고보서 1: 12)",
					"(시편 118: 1)",
					"(시편 118: 14)",
					"(예레미야 29 : 11)",
					"(예레미야 29: 12 ~ 13)",
					"(예레미야 29: 14)",
					"(호세아 6: 1)",
					"(로마서 8: 26)",
					"(고린도후서 12: 9)"
	};
	
	Bible(){
		for(int i = 0; i<=Bible.length-1; i++) {
			bibleList.add(new bibleList(Bible[i],CNV[i]));
		}
	}

}
