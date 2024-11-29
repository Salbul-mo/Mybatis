package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDAO;

import java.io.IOException;

public class DeleteAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    MemberDAO dao = new MemberDAO();

    int result = dao.delete(id);

    String message = (result == 1) ? "회원 삭제에 성공했습니다." : "회원 삭제에 실패했습니다.";

    if (result == 1) {
      System.out.println("회원 삭제 성공");
    } else {
      System.out.println("회원 삭제 실패");
    }

    request.setAttribute("message", message);
    request.setAttribute("url", "list.net");

    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("jsp/message_modal.jsp");

    return forward;
  }
}
