package org.hta.member.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.action.*;

import java.io.IOException;

@WebServlet("*.net")
public class FrontController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String RequestURI = request.getRequestURI();
    String contextPath = request.getContextPath();
    String command = RequestURI.substring(contextPath.length());
    ActionForward forward = null;
    Action action = null;

    System.out.println("RequestURI => " + RequestURI);
    System.out.println("ContextPat => " + contextPath);
    System.out.println("command => " + command);

    switch (command) {
      case "/main.net":
        action = new MainAction();
        break;
      case "/loginForm.net" :
        action = new LoginForm();
        break;
      case "/joinForm.net" :
        action = new JoinForm();
        break;
      case "/loginPro.net" :
        action = new Loginpro();
        break;
      case "/joinPro.net" :
        action = new JoinProAction();
        break;
      case "/logout.net" :
        action = new LogoutAction();
        break;
      case "/list.net" :
        action = new ListAction();
        break;
      case "/updateForm.net" :
        action = new UpdateForm();
        break;
      case "/updatePro.net" :
        action = new UpdatePro();
        break;
      case "/delete.net" :
        action = new DeleteAction();
        break;
      default:
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
        return;
    }

    forward = action.execute(request, response);

    if (forward != null) {
      if (forward.isRedirect()) {
        response.sendRedirect(forward.getPath());
      } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
        dispatcher.forward(request, response);
      }
    }

  }
}
