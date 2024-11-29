package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDAO;
import org.hta.member.domain.Member;

import java.io.IOException;

public class Loginpro implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("id");
    String password = request.getParameter("password");
    Member member = new Member();
    member.setId(id);
    member.setPassword(password);


    MemberDAO dao = new MemberDAO();
    int result = dao.chk(member);
    HttpSession session = request.getSession();

    String message = "비밀번호가 다릅니다.";
    String url = "history.back()";

    if (result == 1) {
      session.setAttribute("id", id);
      message = "환영합니다. " + id + "님~";
      url = "main.net";
    } else if (result == 0) {
      message = "ID 가 존재하지 않습니다.";
    }



    request.setAttribute("message", message);
    request.setAttribute("url", url);
    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("jsp/message_modal.jsp");
    return forward;
  }
}
