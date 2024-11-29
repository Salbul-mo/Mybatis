package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDAO;
import org.hta.member.domain.Member;

import java.io.IOException;

public class JoinProAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    Member member = new Member();
    member.setId(id);
    member.setPassword(password);

    int result = 0;
    MemberDAO md = new MemberDAO();
    int chkresult = md.chk(member);

    String message = "이미 존재하는 아이디입니다.";
    String url = "history.back()";

    if (chkresult == 0) {
      result = md.insert(member);
      message = (result > 0) ? "가입 성공입니다." : "가입 실패입니다.";
      url = (result > 0) ? "loginForm.net" : "history.back()";
    }

    request.setAttribute("message", message);
    request.setAttribute("url", url);

    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("jsp/message_modal.jsp");
    return forward;

  }
}
