package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;

import java.io.IOException;

public class JoinAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ActionForward forward = new ActionForward();


    return forward;
  }
}
