package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class ScoreService {

	protected List<ScoreVO> scoreList;
	protected StudentService stService;
	protected Scanner scan;
	
	public ScoreService() {
		// TODO Auto-generated constructor stub
		scoreList = new ArrayList<ScoreVO>();
		scan = new Scanner(System.in);
		stService = new StudentService();
	}
	
	public boolean inputScore() {
		ScoreVO scVO = new ScoreVO();
		
		System.out.println("학번 >>");
		String strNum = scan.nextLine();
		try {
			strNum = String.format("%05d", Integer.valueOf(strNum));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("학번은 정수 5자리 이내 값만 가능!!!");
			return false;
		}
		for (StudentVO stVO : studentList) {
			if(!stVO.getNum().equals(strNum)) {
				System.out.println("등록되지 않은 학생정보");
				return false;
			} 
		}
		
		scVO.setNum(strNum);
		
		System.out.println("국어 >>");
		String strKor = scan.nextLine();
		int intKor = 0;
		try {
			intKor = Integer.valueOf(strKor);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("숫자만 가능!!!");
			return false;
		}
		if(intKor < 0 || intKor > 100) {
			System.out.println("0~100까지의 숫자만 가능!!!");
			return false;
		}
		scVO.setKor(intKor);
		
		System.out.println("영어 >>");
		String strEng = scan.nextLine();
		int intEng = 0;
		try {
			intEng = Integer.valueOf(strEng);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("숫자만 가능!!!");
			return false;
		}
		if(intEng < 0 || intEng > 100) {
			System.out.println("0~100까지의 숫자만 가능!!!");
			return false;
		}
		scVO.setEng(intEng);
		
		System.out.println("수학 >>");
		String strMath = scan.nextLine();
		int intMath = 0;
		try {
			intMath = Integer.valueOf(strMath);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("숫자만 가능!!!");
			return false;
		}
		if(intMath < 0 || intMath > 100) {
			System.out.println("0~100까지의 숫자만 가능!!!");
			return false;
		}
		scVO.setMath(intMath);
		
		System.out.println("음악 >>");
		String strMusic = scan.nextLine();
		int intMusic = 0;
		try {
			intMusic = Integer.valueOf(strMusic);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("숫자만 가능!!!");
			return false;
		}
		if(intMusic < 0 || intMusic > 100) {
			System.out.println("0~100까지의 숫자만 가능!!!");
			return false;
		}
		scVO.setMusic(intMusic);
		
		int sum = intKor
				+ intEng
				+ intMath
				+ intMusic;
		scVO.setSum(sum);
		
		float avg = (float)sum / 4;
		scVO.setAvg(avg);
		
		scoreList.add(scVO);	
		
		return true;
	}
	@Override
	protected void saveScore() {
		String sFile = "src/com/biz/grade/exec/data/score.txt";
		PrintStream savefile = null;
		try {
			savefile = new PrintStream(sFile);
			for (ScoreVO scVO : scoreList) {
				savefile.printf("%s:%d:%d:%d:%d:%d:%f\n",
						scVO.getNum(),
						scVO.getKor(),
						scVO.getEng(),
						scVO.getMath(),
						scVO.getMusic(),
						scVO.getSum(),
						scVO.getAvg());	
			}
			savefile.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	protected void lordScore() {
		scoreList.clear();
		String sFile = "src/com/biz/grade/exec/data/score.txt";
		
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(sFile);
			buffer = new BufferedReader(fileReader);

			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}
				String[] scores = reader.split(":");

				ScoreVO scVO = new ScoreVO();

				scVO.setNum(scores[0]);
				scVO.setKor(Integer.valueOf(scores[1]));
				scVO.setEng(Integer.valueOf(scores[2]));
				scVO.setMath(Integer.valueOf(scores[3]));
				scVO.setMusic(Integer.valueOf(scores[4]));
				scVO.setSum(Integer.valueOf(scores[5]));
				scVO.setAvg(Float.valueOf(scores[6]));
				
				scoreList.add(scVO);
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("score.txt파일이 없으므로 새로운 파일을 만듭니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void listScore() {
		System.out.println("==============================================");
		System.out.println("성적 리스트");
		System.out.println("==============================================");
		System.out.println("학번\t국어\t영어\t수학\t음악\t총점\t평균");
		System.out.println("----------------------------------------------");
		for (ScoreVO scVO : scoreList) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\n",
					scVO.getNum(),
					scVO.getKor(),
					scVO.getEng(),
					scVO.getMath(),
					scVO.getMusic(),
					scVO.getSum(),
					String.format("%.2f", scVO.getAvg()));
		}
		System.out.println("리스트 출력완료!! 아무버튼이나 눌러주세요");
		scan.hasNextLine();
	}
}
