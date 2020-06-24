package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;


@WebServlet("/pbc")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/pbc ---> doGet()");
		
		String action = request.getParameter("action");
		
		//action.equals("list")과 비교할 것
		if("list".equals(action)) { //리스트일때
			System.out.println("list");
			
			PhoneDao dao = new PhoneDao();
			List<PersonVo> pList = dao.getPersonList();
						
			//데이터 리퀘스트에 추가
			request.setAttribute("personList", pList);//인스턴스 pList의 이름을 personList로 하라는 의미 
		
			//포워드하는 방법 (아래 2줄 고정 코드 사용하는 대신 웹유틸 클래스 이용)
			WebUtil.forward(request, response, "/WEB-INF/list.jsp"); //webUtil이 Static 클래스여서  WebUtil을 대문자로 인스턴스 생성 없이 바로시작
			
			/*
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response); 		
			*/
			
		}else if ("wForm".equals(action)) {
			System.out.println("번호 저장");
			
			//포워드하는 방법 (아래 2줄 고정 코드 사용하는 대신 웹유틸 클래스 이용)
			WebUtil.forward(request, response, "/WEB-INF/writeForm.jsp"); //webUtil이 Static 클래스여서  WebUtil을 대문자로 인스턴스 생성 없이 바로시작
			
			/*
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response); 
			*/		
			
		}else if ("insert".equals(action)) {
			System.out.println("번호 저장");
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVo vo = new PersonVo(name, hp, company);
			
			PhoneDao dao = new PhoneDao();
			dao.personInsert(vo);
			
			
			//리다이렉트
			WebUtil.redirect(request, response, "/pb2/pbc?action=list");
			
			/*
			response.sendRedirect("/pb2/pbc?action=list"); //이 순서에서 포워드가 아니라 리다이렉트이므로 사용자의 요청시의 주소를 입력해야함 WebUtil로 포워드와 리다이렉트를 관리함
			*/
		}else if ("updateForm".equals(action)) {
			System.out.println("번호 수정폼");
			
			//포워드하는 방법 (아래 2줄 고정 코드 사용하는 대신 웹유틸 클래스 이용)
			WebUtil.forward(request, response, "/WEB-INF/updateForm.jsp"); //webUtil이 Static 클래스여서  WebUtil을 대문자로 인스턴스 생성 없이 바로시작
			
			/*
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response); 
			*/		
		}else if ("update".equals(action)) {
			System.out.println("번호 수정");
						 			
			//파라미터 추출		
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
							
			//vo 만들기
			PersonVo vo = new PersonVo(name, hp, company);
			
			//dao 만들기
			PhoneDao dao = new PhoneDao();
								
			//personUpdate()
			dao.personUpdate(vo);
			
			
			//리다이렉트
			WebUtil.redirect(request, response, "/pb2/pbc?action=list");
			
			/*
			response.sendRedirect("/pb2/pbc?action=list"); //이 순서에서 포워드가 아니라 리다이렉트이므로 사용자의 요청시의 주소를 입력해야함 WebUtil로 포워드와 리다이렉트를 관리함
			*/
			
		}else if ("delete".equals(action)) {
			System.out.println("번호 삭제");
			
			int personId = Integer.parseInt(request.getParameter("pId"));
			
			PhoneDao dao = new PhoneDao();
			dao.personDelete(personId);
			
			
			//리다이렉트
			WebUtil.redirect(request, response, "/pb2/pbc?action=list");
			
			/*
			response.sendRedirect("/pb2/pbc?action=list"); //이 순서에서 포워드가 아니라 리다이렉트이므로 사용자의 요청시의 주소를 입력해야함 WebUtil로 포워드와 리다이렉트를 관리함
			*/
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
