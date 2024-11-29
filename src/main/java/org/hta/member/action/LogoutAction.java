package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;

import java.io.IOException;

public class LogoutAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ActionForward forward = new ActionForward();
    HttpSession session = request.getSession();

    session.invalidate();
    //session.removeAttribute("id");

    request.setAttribute("message", "로그 아웃 되었습니다.");
    request.setAttribute("url", "main.net");
    forward.setRedirect(false);
    forward.setPath("jsp/message_modal.jsp");

    return forward;
  }
}
