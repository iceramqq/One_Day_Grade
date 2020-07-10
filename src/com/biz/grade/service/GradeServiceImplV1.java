package com.biz.grade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class GradeServiceImplV1 implements GradeService {
	
	protected List<ScoreVO> scoreList;
	protected List<StudentVO> studentList;
	protected Scanner scan;
	
	public GradeServiceImplV1() {
		// TODO Auto-generated constructor stub
		scoreList = new ArrayList<ScoreVO>();
		studentList = new ArrayList<StudentVO>();
		scan = new Scanner(System.in);
		this.lordGrade();
	}
	
	@Override
	public boolean inputStudent() {
		// TODO Auto-generated method stub
		StudentVO stVO = new StudentVO();
		
		System.out.print("학번 >>");
		String strNum = scan.nextLine();
		try {
			strNum = String.format("%05d", Integer.valueOf(strNum));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("학번은 정수 5자리 이내 값만 가능!!!");
			return false;
		}
		for (StudentVO studentVO : studentList) {
			if(studentVO.getNum().equals(strNum)) {
				System.out.println("등록된 학생정보!!!");
				return false;
			}			
		}
		stVO.setNum(strNum);
		
		System.out.print("이름 >>");
		String strName = scan.nextLine();
		stVO.setName(strName);
		
		System.out.print("학과 >>");
		String strDepart = scan.nextLine();
		stVO.setDepart(strDepart);
		
		System.out.print("학년 >>");
		String strGrade = scan.nextLine();
		int intGrade = 0;
		try {
			if(intGrade < 1 || intGrade > 4) {
				intGrade = Integer.valueOf(strGrade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("학년은 1~4까지의 숫자만 가능!!!");
			return false;
		}		
		stVO.setGrade(intGrade);
		
		System.out.print("전화번호 >>");
		String strTel = scan.nextLine();
		stVO.setTel(strTel);
		
		studentList.add(stVO);
		
		this.saveStudent();
		
		return true;
	}
	
	protected void saveStudent() {
		
		
	}
	protected void lordStudent() {
		
		
	}

	@Override
	public boolean inputScore() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void saveScore() {

	}
	
	protected void lordScore() {

	}

	@Override
	public void saveGrade() {
		// TODO Auto-generated method stub
		this.saveStudent();
		this.saveScore();
	}
	
	@Override
	public void lordGrade() {
		this.lordStudent();
		this.lordScore();
	}

	@Override
	public void listScore() {
		// TODO Auto-generated method stub
		
	}
	
	
}
