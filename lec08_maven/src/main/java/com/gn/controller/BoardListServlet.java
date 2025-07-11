package com.gn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.gn.dto.Board;
import com.gn.dto.Member;
import com.gn.service.BoardService;
import com.gn.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
	private MemberService memberService = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 사용자만 접근 허용
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		} else {
			if (session.getAttribute("loginMember") == null) {
				response.sendRedirect(request.getContextPath() + "/");
				return;
			}
		}
		
		Board param = new Board();
		// 현재 페이지 정보 셋팅
		int nowPage = 1;
		String nowPageStr = request.getParameter("nowPage");
		if (nowPageStr != null) nowPage = Integer.parseInt(nowPageStr);
		param.setNowPage(nowPage);
		
		// 검색어 셋팅
		String keyword = request.getParameter("keyword");
		param.setKeyword(keyword);
		
		// 전체 게시글 개수 조회
		int totalData = boardService.selectBoardCount(param);
		param.setTotalData(totalData);
		
		// 게시글 목록 정보 조회
		List<Board> boardList = boardService.selectBoardList(param);
		
//		List<Member> memberList = memberService.selectMemberList();
//		Map<Integer, String> memberMap = new HashMap<Integer, String>();
//		for (Member m : memberList) {
//			memberMap.put(m.getMemberNo(), m.getMemberId());
//		}
//		System.out.println(memberList);
		
		Map<Integer, Member> memberMap = memberService.selectMemberMap(param);
//		System.out.println(memberMap);
		
		request.setAttribute("boardList", boardList);
//		request.setAttribute("memberMap", memberMap);
		session.setAttribute("memberMap", memberMap);
		request.setAttribute("paging", param);
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
