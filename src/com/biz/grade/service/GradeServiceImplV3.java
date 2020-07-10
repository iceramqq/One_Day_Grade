package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class GradeServiceImplV3 extends GradeServiceImplV2 {

	@Override
	protected void saveStudent() {
		String sFile = "src/com/biz/grade/exec/data/student.txt";
		PrintStream savefile = null;
		try {
			savefile = new PrintStream(sFile);
			for (StudentVO stVO : studentList) {
				savefile.printf("%s:%s:%s:%d:%s\n",
						stVO.getNum(),
						stVO.getName(),
						stVO.getDepart(),
						stVO.getGrade(),
						stVO.getTel());	
			}
			savefile.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	protected void lordStudent() {
		studentList.clear();
		String sFile = "src/com/biz/grade/exec/data/student.txt";
		
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
				String[] students = reader.split(":");

				StudentVO stVO = new StudentVO();

				stVO.setNum(students[0]);
				stVO.setName(students[1]);
				stVO.setDepart(students[2]);
				stVO.setGrade(Integer.valueOf(students[3]));
				stVO.setTel(students[4]);
				
				studentList.add(stVO);
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("student.txt파일이 없으므로 새로운 파일을 만듭니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
