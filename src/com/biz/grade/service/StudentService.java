package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.StudentVO;

public class StudentService {
	protected List<StudentVO> studentList;
	protected Scanner scan;
	
	public StudentService() {
		// TODO Auto-generated constructor stub
		studentList = new ArrayList<StudentVO>();
		scan = new Scanner(System.in);
	}
	
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
		
		return true;
	}
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
}
