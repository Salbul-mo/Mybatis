package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDAO;
import org.hta.member.domain.Member;

import java.io.IOException;

public class UpdatePro implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("id");
    String password = request.getParameter("password");

    Member member = new Member();
    member.setId(id);
    member.setPassword(password);

    MemberDAO dao = new MemberDAO();
    int result = dao.update(member);

    String message = "회원 정보 수정에 실패했습니다.";
    // String message = (result == 1) ? "수정 성공" : "수정 실패";
    String url = "history.back()";
    // String url = (result == 1) ? "list.net" : "history.back()";

    if (result == 1) {
      System.out.println("회원 정보 수정 성공");
      message = "회원 정보 수정에 성공했습니다.";
      url = "list.net";
    } else {
      System.out.println("회원 정보 수정 실패");
    }

    request.setAttribute("message", message);
    request.setAttribute("url", url);

    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("jsp/message_modal.jsp");
    return forward;
  }
}
