import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


enum menuMode{
	modeSelect, consonant, vowel, programINF
}

public class forMenu extends JPanel implements ActionListener{
	//스윙 컴포넌트들
	JLabel type, thumbnail;
	
	JComboBox menuList;
	JButton nextQuiz, submit, nextWord, prevWord;
	JRadioButton wordNote, quiz;
	
	JCheckBox showUnderLine;
	
	JTextArea incTitle;
	JTextPane incorrectList;
	JTextField submitArea;
	JScrollPane spForIL;
	
	ButtonGroup bGroup;
	
	//기본타입 변수들
	int[] randAryforMenu;//메인메뉴 말씀묵상 랜덤 배열
	int indexforRAMenu =0;//메인 메뉴 말씀 묵상 랜덤 배열의 인덱스
	
	int indexforWordNote = 0;
	
	
	String[] menubar = {"모드를 선택해주세요","자음","모음","프로그램 정보"};
	String wrongList = "";
	String colorInit = "#00B992";
	
	Color defaultColor = Color.decode(colorInit);
	Color defaultDark = new Color(40,40,40);
	Font defaultFontLar = new Font("나눔바른펜",Font.BOLD,30);
	Font defaultFontBig = new Font("나눔바른펜",Font.BOLD,20);
	Font defaultFontNor = new Font("나눔바른펜",Font.BOLD,15);
	Font defaultFontSma = new Font("나눔바른펜",Font.BOLD,10);
	
	boolean quizOrNote;
	
	//클래스 저장
	quizboard B; forAlphabet fa; Bible b; hebConsonant hc;
	
	//이넘
	menuMode mode;
	
	forMenu(JFrame quizBoard){
		mode = menuMode.modeSelect;
	}
	
	forMenu(JFrame quizBoard,JPanel forAlphabet){
		this.B = (quizboard)quizBoard;
		this.fa = (forAlphabet)forAlphabet;
		fa.fm = this;//동기화
		b = new Bible();
		hc = new hebConsonant();
		
		mode = menuMode.modeSelect;//기본 모드를 메뉴선택 모드로 변경합니다.
		randAryforMenu = randomnumberGen(b.bibleList.size());//중복 방지 랜덤 묵상 배열을 생성합니다.
		////////////////////forAlphabet의 메인메뉴 초기화/////////////////////////////////////////////
		int initMenu = randAryforMenu[indexforRAMenu++];
		fa.Biblekor.setText("<html><center>"+b.bibleList.get(initMenu).bible
						+"<br><br><font color ="+colorInit+">"+b.bibleList.get(initMenu).ChapterNVerse
						+"</font></center></html>");
		////////////////////////////////////////////////////////////////////////////////////////
		
		setLayout(null);
		setSize(180,355);
		this.setBorder(BorderFactory.createEtchedBorder());
		
		//메뉴
		menuList = new JComboBox(menubar);
		menuList.setSelectedIndex(0);
		menuList.setBounds(5,5,170,30);
		menuList.setBackground(defaultColor);
		menuList.setForeground(Color.WHITE);
		menuList.setFont(defaultFontBig);
		menuList.addActionListener(this);
		add(menuList);
		
		//썸네일
		thumbnail = new JLabel("יַעְבֵּץ");
		thumbnail.setFont(new Font("Serif",Font.BOLD,30));
		thumbnail.setForeground(defaultColor);
		thumbnail.setBounds(5,300,170,50);
		thumbnail.setVisible(true);
		add(thumbnail);

		//퀴즈 on, off 모드
		wordNote = new JRadioButton("단어장");
		wordNote.setBounds(5,45,70,30);
		wordNote.setFont(defaultFontNor);
		wordNote.addActionListener(this);
		wordNote.setSelected(true);
		wordNote.setVisible(false);
		add(wordNote);
		
		quiz = new JRadioButton("퀴즈");
		quiz.setBounds(80,45,70,30);
		quiz.setFont(defaultFontNor);
		quiz.addActionListener(this);
		quiz.setSelected(false);
		quiz.setVisible(false);
		add(quiz);
		
		bGroup = new ButtonGroup();
		bGroup.add(quiz);bGroup.add(wordNote);
		
		//quizmode
		forQuiz();
		forNote();
		
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	
	
	//단어장 모드 
	public void forNote() {
		showUnderLine = new JCheckBox("안내선");
		showUnderLine.setFont(defaultFontNor);
		showUnderLine.setBounds(5,220,100,40);
		showUnderLine.addActionListener(this);
		add(showUnderLine);
		
		prevWord = new JButton("이전");
		prevWord.setForeground(defaultColor);
		prevWord.setBackground(Color.WHITE);
		prevWord.setFont(defaultFontNor);
		prevWord.setBounds(5,280,80,40);
		prevWord.addActionListener(this);
		add(prevWord);
		
		nextWord = new JButton("다음");
		nextWord.setForeground(Color.WHITE);
		nextWord.setBackground(defaultColor);
		nextWord.setFont(defaultFontNor);
		nextWord.setBounds(90,280,80,40);
		nextWord.addActionListener(this);
		add(nextWord);
		
		showUnderLine.setVisible(false);
		prevWord.setVisible(false);
		nextWord.setVisible(false);
	}
	
	//퀴즈모드
	public void forQuiz() {
		//오답노트 표시제목
		incTitle = new JTextArea("오답노트");
		incTitle.setFont(defaultFontSma);
		incTitle.setDisabledTextColor(defaultColor);
		incTitle.setBackground(new Color(40,40,40));
		incTitle.setEnabled(false);
		incTitle.setBounds(5,80,169,15);
		add(incTitle);
		
		//오답노트 리스트
		incorrectList = new JTextPane();
		incorrectList.setText(wrongList);
		incorrectList.setBackground(Color.WHITE);
		incorrectList.setDisabledTextColor(new Color(40,40,40));
		incorrectList.setDragEnabled(true);
		incorrectList.setEditable(false);
		
		//리스트 텍스트창에 스크롤 넣기
		spForIL = new JScrollPane(incorrectList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//JFrame의 컨텐트페인에 스크롤페인 등록
		B.getContentPane().add(spForIL);
		spForIL.setBounds(10,100,170,100);
		
		//정답 입력라벨
		type = new JLabel("뜻:");
		type.setForeground(defaultColor);
		//위 사항은 '뜻:', '이름(한글):' '발음:', '수:' 으로 분화될 예정입니다.
		type.setFont(defaultFontNor);
		type.setBounds(5,250,40,30);
		add(type);
		
		//정답 입력 텍스트 필드
		submitArea = new JTextField(15);
		submitArea.setFont(defaultFontNor);
		submitArea.setBounds(5,280,100,25);
		add(submitArea);
		
		//정답 제출 버튼
		submit = new JButton("제출");
		submit.setFont(defaultFontNor);
		submit.setForeground(Color.WHITE);
		submit.setBackground(defaultColor);
		submit.setBounds(110,280,65,24);
		submit.addActionListener(this);
		add(submit);
		
		//다음 퀴즈단어 버튼
		nextQuiz = new JButton("다음 퀴즈");
		nextQuiz.setFont(defaultFontNor);
		nextQuiz.setForeground(Color.WHITE);
		nextQuiz.setBackground(defaultColor);
		nextQuiz.setBounds(5,310,170,40);
		nextQuiz.addActionListener(this);
		add(nextQuiz);
		
		incTitle.setVisible(false);
		incorrectList.setVisible(false);
		spForIL.setVisible(false);
		type.setVisible(false);
		submitArea.setVisible(false);
		submit.setVisible(false);
		nextQuiz.setVisible(false);
	}
	
	public void checkQuizorNote(boolean quizOrNote, menuMode m) {
		switch(m) {
		case modeSelect:
		case programINF:
			wordNote.setVisible(false);
			quiz.setVisible(false);
			
			incTitle.setVisible(false);
			incorrectList.setVisible(false);
			spForIL.setVisible(false);
			type.setVisible(false);
			submitArea.setVisible(false);
			submit.setVisible(false);
			nextQuiz.setVisible(false);
			
			showUnderLine.setVisible(false);
			prevWord.setVisible(false);
			nextWord.setVisible(false);
			break;
			
		case consonant:
		case vowel:
			wordNote.setVisible(true);
			quiz.setVisible(true);
			
			if(quizOrNote) {
				incTitle.setVisible(true);
				incorrectList.setVisible(true);
				spForIL.setVisible(true);
				type.setVisible(true);
				submitArea.setVisible(true);
				submit.setVisible(true);
				nextQuiz.setVisible(true);
				
				showUnderLine.setVisible(true);
				prevWord.setVisible(false);
				nextWord.setVisible(false);
			}
			else {
				incTitle.setVisible(false);
				incorrectList.setVisible(false);
				spForIL.setVisible(false);
				type.setVisible(false);
				submitArea.setVisible(false);
				submit.setVisible(false);
				nextQuiz.setVisible(false);
				
				showUnderLine.setVisible(true);
				prevWord.setVisible(true);
				nextWord.setVisible(true);
			}
			break;
			
		default:
			break;
		}
		
	}
	
	public void wordNoteLabel(String alphabet, String hebname, String index, String korName, String uniName
			, String shape,String number, String[] range) {
		fa.hebAlpha.setText(alphabet);
		fa.hebName0.setText(hebname);
		fa.forhebInf.setText("<html><font size=+2>"+index+"</font>"
			+ "<span color="+colorInit+">   "+korName+
			"("+uniName+")</span><br>"
			+ "<font size = 1><br></font>"//줄간격을 띄어줘요!
			+ "음역:  "//TODO 아래range[0]을 배열을 받으면 , , 추가해서 문자열로 반환해주는걸로 바꾸기
			+"<span color=#F35A62 face=Serif>"+range[0]+"</span><font color=#F35A62 size =4></font>"+"<br>"
			+ "한글 소리값:  <span color =#0894A1>ㅇ</span><br>"
			+ "<font size = 1><br></font>"//줄간격을 띄어줘요!
			+ "형상:  <span color =#F2B134>"+shape+"</span><br>"
			+ "숫자값:  <span color=#112F41>"+number+"</span></html>");
	}
	
	public void NextPrev(int size,int max) {//이전, 다음 버튼 활성화 비활성화
		if(size==0)
			prevWord.setEnabled(false);
		else
			prevWord.setEnabled(true);
		
		if(size==max)
			nextWord.setEnabled(false);
		else
			nextWord.setEnabled(true);
		
	}
	
	//중복없는 랜덤 넘버 배열 생성기
	public int[] randomnumberGen(int r) {
		int randAry[] = new int[r];
		
		for(int i = 0; i<randAry.length-1; i++) {
			randAry[i] = (int)(Math.random()*r);
			
			for(int j =0; j<i; j++) {
				
				if(randAry[j]==randAry[i]) {
					i--;
				}
			}
		}
		return randAry;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//메뉴 선택바
		if(menuList.getSelectedItem().equals("모드를 선택해주세요")) {
			int randomIndex = 0;
			if(mode != menuMode.modeSelect) {
				if(indexforRAMenu>randAryforMenu.length-1) {//만약 메뉴랜덤인덱스의 값이 메뉴랜덤배열의길이보다 커진다면?
					System.out.println("말씀묵상의 랜덤값이 갱신됩니다.");//메시지 출력하고
					randAryforMenu = randomnumberGen(b.bibleList.size());//중복방지 랜덤배열 제네레이터를 이용하여 묵상배열리스트의 크기만큼 랜덤넘버배열을 생성합니다.
					indexforRAMenu = 0;//메뉴랜덤인덱스의 값은 다시 0으로 초기화하고
					randomIndex = randAryforMenu[indexforRAMenu];//랜덤인덱스의 값을 초기값으로 반환해줘요
				}
				else {
					randomIndex = randAryforMenu[indexforRAMenu++];//아니면 그냥 메뉴렌덤인덱스+1한 랜덤배열의 값을 부여해주면 되구요
				}
				
				fa.Biblekor.setText("<html><center>"+b.bibleList.get(randomIndex).bible
						+"<br><br><font color =#00B992>"+b.bibleList.get(randomIndex).ChapterNVerse
						+"</font></center></html>");
				mode = menuMode.modeSelect;
			}
			wordNote.setSelected(true);
			showUnderLine.setSelected(false);
			thumbnail.setVisible(true);
		}
		else if(menuList.getSelectedItem().equals("자음")) {
			if(mode != menuMode.consonant) {
				mode = menuMode.consonant;
				indexforWordNote = 0;
				wordNoteLabel(hc.CS.get(indexforWordNote).alphabet,hc.CS.get(indexforWordNote).hebname,
						hc.CS.get(indexforWordNote).index,hc.CS.get(indexforWordNote).korName,
						hc.CS.get(indexforWordNote).uniName,hc.CS.get(indexforWordNote).shape,
						hc.CS.get(indexforWordNote).number,hc.CS.get(indexforWordNote).range);
			}
			thumbnail.setVisible(false);
		}
		else if(menuList.getSelectedItem().equals("모음")) {
			if(mode != menuMode.vowel) {
				mode = menuMode.vowel;
			}
			thumbnail.setVisible(false);
		}
		else if(menuList.getSelectedItem().equals("프로그램 정보")) {
			if(mode != menuMode.programINF) {
				mode = menuMode.programINF;
				wordNote.setSelected(true);
			}
			showUnderLine.setSelected(false);
			thumbnail.setVisible(true);
		}
		//메뉴 동기화
		
		
		//퀴즈 or 단어장
		if(wordNote.isSelected()) {
			quizOrNote = false;
		}
		else if(quiz.isSelected()) {
			quizOrNote = true;
			indexforWordNote = 0;
		}		
		
		if(showUnderLine.isSelected()) { 
			fa.showUnderLineBool = true;
		}
		else {
			fa.showUnderLineBool = false;
		}
		
		if(this.mode == menuMode.consonant) {
			if(!quizOrNote) {
				if(e.getSource()==nextWord) {
					if(indexforWordNote<hc.CS.size()-1) {
						indexforWordNote++;
					}
					wordNoteLabel(hc.CS.get(indexforWordNote).alphabet,hc.CS.get(indexforWordNote).hebname,
							hc.CS.get(indexforWordNote).index,hc.CS.get(indexforWordNote).korName,
							hc.CS.get(indexforWordNote).uniName,hc.CS.get(indexforWordNote).shape,
							hc.CS.get(indexforWordNote).number,hc.CS.get(indexforWordNote).range);
				}
				if(e.getSource()==prevWord) {
					if(indexforWordNote>0) {
						indexforWordNote--;
					}
					wordNoteLabel(hc.CS.get(indexforWordNote).alphabet,hc.CS.get(indexforWordNote).hebname,
							hc.CS.get(indexforWordNote).index,hc.CS.get(indexforWordNote).korName,
							hc.CS.get(indexforWordNote).uniName,hc.CS.get(indexforWordNote).shape,
							hc.CS.get(indexforWordNote).number,hc.CS.get(indexforWordNote).range);
				}
				NextPrev(indexforWordNote,hc.CS.size()-1);
				}
		}
		
		checkQuizorNote(quizOrNote,mode);
		fa.changeMode(this);
	}
}
