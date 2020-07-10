package com.biz.grade.exec;

import java.util.Scanner;

import com.biz.grade.service.GradeService;
import com.biz.grade.service.GradeServiceImplV3;

public class GradeMain {
	
	public static void main(String[] args) {
		
		GradeService gService = new GradeServiceImplV3();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("==============================================");
			System.out.println("학교 관리 시스템 V3");
			System.out.println("==============================================");
			System.out.println("1.학생 인적사항 입력");
			System.out.println("2.학생 성적 입력");
			System.out.println("3.전체 성적 리스츠 출력");
			System.out.println("-1.종료");
			System.out.println("==============================================");
			System.out.print(">>");
			String strNum = scan.nextLine();
			int intNum = 0;
			try {
				intNum = Integer.valueOf(strNum);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력 가능");
				continue;
			}
			
			if(intNum == -1) {
				break;
			} else if(intNum == 1) {
				gService.inputStudent();
			} else if (intNum == 2) {
				gService.inputScore();
			} else if (intNum == 3) {
				gService.listScore();
			} else {
				System.out.println("선택한 업무가 없습니다.");
			}
			
		}
		
	}

}
