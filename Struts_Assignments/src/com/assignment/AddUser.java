package com.assignment;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import assignment.dao.AssignmentDao;

public class AddUser extends Action {
	// List<UserForm> users = new ArrayList<UserForm>();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("loading!!");
		UserForm userform = (UserForm) form;
		AssignmentDao ad = new AssignmentDao();
		UserForm uf = new UserForm();
		
		if(request.getParameter("id")!=null) {
			session.setAttribute("view", "true");
			session.setAttribute("edit", "false");
			session.setAttribute("add", "false");
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			System.out.println("id for edit "+id);
//			userform.reset();
			userform = ad.getItem(id);
			
			request.setAttribute("UserForm", userform);
			request.setAttribute("state", userform.getState());
			request.setAttribute("city", userform.getCity());
			System.out.println("fname for edit "+userform.getFname());
			ArrayList users = (ArrayList) ad.executeQuery();
			request.setAttribute("data", users);
			
			return mapping.findForward("added");
		}
		
		if(request.getParameter("editid")!=null) {
			
			session.setAttribute("edit", "true");
			session.setAttribute("view", "false");
			session.setAttribute("add", "false");
			String ids = request.getParameter("editid");
			int id = Integer.parseInt(ids);
			System.out.println("id for edit "+id);
//			userform.reset();
			userform = ad.getItem(id);
			
			request.setAttribute("UserForm", userform);
			request.setAttribute("state", userform.getState());
			request.setAttribute("city", userform.getCity());
			System.out.println("fname for edit "+userform.getFname());
			ArrayList users = (ArrayList) ad.executeQuery();
			request.setAttribute("data", users);
			
			return mapping.findForward("added");
		
			
		}
		
		if(request.getParameter("update")!=null) {
			
			System.out.println("id is"+ request.getParameter("uid"));
			System.out.println("fname is"+ userform.getFname());
			String update= ad.update(userform);
			request.setAttribute("update",update);
			userform.reset();
		}
		
		
		
		if(request.getParameter("insert")!=null) {
			session.setAttribute("edit", "false");
			session.setAttribute("view", "false");
			session.setAttribute("add", "true");
			System.out.println("inserting !!"+userform.getUid());
			int uid=0;
			try {
				uid = Integer.parseInt(userform.getUid());
			}catch(Exception e){
				System.out.println("some error occured!!!"+e);
			}
			 
			 String fname = userform.getFname();
				String lname = userform.getLname();
				String gender = userform.getGender();
				String dob = userform.getDob();
				if(dob==null) {
					dob="2001-01-21";
				}
				String email = userform.getEmail();
				String ef = userform.getEmailnot();
				String address1 = userform.getAdress1();
				String address2 = userform.getAdress2();
				String city = userform.getCity();
				String state = userform.getState();
				String pincode = userform.getPincode();
				String insert = ad.insert(uid, fname, lname, gender,dob, email, ef, address1, address2, city, state, pincode);
				request.setAttribute("insert", insert);
				userform.reset();
		}
		
		ArrayList users = (ArrayList) ad.executeQuery();

		System.out.println("users are " + users);
		System.out.println(userform.toString());
		System.out.println("add user control triggered!!!");
		request.setAttribute("data", users);
//		userform.reset();
	  
		session.setAttribute("edit", "false");
		session.setAttribute("view", "false");
		session.setAttribute("add", "true");
		System.out.println("ending!!");
		userform.reset();
		String uid = ad.getId();
		userform.setUid(uid);
		return mapping.findForward("added");
	}
}
