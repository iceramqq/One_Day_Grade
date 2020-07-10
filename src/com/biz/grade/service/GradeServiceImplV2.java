package com.biz.grade.service;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class GradeServiceImplV2 extends GradeServiceImplV1 {

	@Override
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
		
		this.saveScore();
		
		return true;
	}
	
	
}
