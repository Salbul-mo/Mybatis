package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDAO;
import org.hta.member.domain.Member;

import java.io.IOException;

public class UpdateForm implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    MemberDAO dao = new MemberDAO();
    Member member = dao.select(id);
    request.setAttribute("member", member);

    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("jsp/updateForm.jsp");

    return forward;
  }
}
