package com.jci.controller;
import java.time.LocalDate;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.common.Encry;
import com.jci.service.UserRegistrationService;

@Controller
public class LoginController {
	
	public static String secretkey = "keyforencryptid";

	public static String dpcCode;
	
	public static String useremail1;


	@Autowired
	UserRegistrationService userRegService;
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED)
    public String handle404(HttpServletRequest request, Exception e) {
           String username = (String) request.getSession().getAttribute("usrname");
           ModelAndView mv = new ModelAndView("errorPage");
           if (username == null) {
                  mv = new ModelAndView("index");
           }
           e.printStackTrace();
           return "errorPage";
    }
	
	@ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    public String handle(HttpServletRequest request, NumberFormatException e) {
           String username = (String) request.getSession().getAttribute("usrname");
           ModelAndView mv = new ModelAndView("errorPage");
           if (username == null) {
                  mv = new ModelAndView("index");
           }
           e.printStackTrace();
           return "errorPage";
    }
	
	@ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    public String handle2(HttpServletRequest request, NullPointerException e) {
           String username = (String) request.getSession().getAttribute("usrname");
           ModelAndView mv = new ModelAndView("errorPage");
           if (username == null) {
                  mv = new ModelAndView("index");
           }
           e.printStackTrace();
           return "errorPage";
    }
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    public String handle3(HttpServletRequest request, IllegalArgumentException e) {
           String username = (String) request.getSession().getAttribute("usrname");
           ModelAndView mv = new ModelAndView("errorPage");
           if (username == null) {
                  mv = new ModelAndView("index");
           }
           e.printStackTrace();
           return "errorPage";
    }

	 @RequestMapping("404")
	    @ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
	    public String handle500(HttpServletRequest request) {
	           String username = (String) request.getSession().getAttribute("usrname");
	           ModelAndView mv = new ModelAndView("errorPage");
	           if (username == null) {
	                  mv = new ModelAndView("index");
	           }
	           
	           return "errorPage";
	    }

	    @RequestMapping("500")
	    @ResponseStatus(value = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
	    public String handle400(HttpServletRequest request) {
	           String username = (String) request.getSession().getAttribute("usrname");
	           ModelAndView mv = new ModelAndView("errorPage");
	           if (username == null) {
	                  mv = new ModelAndView("index");
	           }
	           return "errorPage";
	    }
	    
	 
	    
	    @RequestMapping("501")
	    @ResponseStatus(value = org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED)
	    public String handle501(HttpServletRequest request) {
	           return "errorPage";
	    }

	    @RequestMapping("405")
	    @ResponseStatus(value = org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED)
	    public String handle405(HttpServletRequest request) {
	           return "errorPage";
	    }


	@RequestMapping("index")
	public ModelAndView login(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();

		ModelAndView mv = new ModelAndView("index");
	
		return mv;
	}

	@RequestMapping("login")
	public ModelAndView loginDetails(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	
	  @RequestMapping("dashboardview") 
	  public ModelAndView dashboardview(HttpServletRequest request){ 
		//  System.out.println("dashboard"); 
			String username =(String)request.getSession().getAttribute("usrname");
		  ModelAndView mv = new ModelAndView("dashboard");
		  if(username == null) {
          	mv = new ModelAndView("index");
              }
		  return mv; 
		  }
	 

	  @RequestMapping("loginAction")
      public ModelAndView loginDetailsCheck(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session){
            ModelAndView mv = new ModelAndView("index");
            
            try {
                   String email =  request.getParameter("email");
                   String password = request.getParameter("password");
                   if(email != null && password != null) {
                   String dpcId = request.getParameter("dpcId");
                   String ifExist =  userRegService.checkLogin(email, password);
                   if(ifExist == "inactive")
                   {
                       mv.addObject("msg", "<div class=\"alert alert-danger\"><b>Failure !</b> Inactive User.</div> \r\n");
                       return mv;
                   }
                   //String flag =  userRegService.checkConcurrentlogin(email);
                   String username =(String)request.getSession().getAttribute("usrname");
                     if(ifExist!=null && ifExist.equalsIgnoreCase("mobile")) { 
                           mv.addObject("msg", "<div class=\"alert alert-danger\"><b>Failure !</b>Mobile User Can not Login Here.</div> \r\n");
                     
                     } else if(ifExist == null){
                     
                     mv.addObject("msg", "<div class=\"alert alert-danger\"><b>Failure !</b>Please Enter correct username and password.</div> \r\n"); 
                     }
                   
                     else
                         {
                    	 LocalDate obj = LocalDate.now();
							//LocalDate obj = LocalDate.of(2020, 1, 8)
							int currentyear = obj.getYear();
							int nextyear = 0;
							int month = obj.getMonthValue();
							if (month >= 7) 
							{
								nextyear = currentyear + 1;
							} else
							{
								nextyear = currentyear;
								currentyear -= 1;
							}
							String currCropYear = currentyear + "-" + nextyear;
							 nextyear =  nextyear-1;
							String priviouscropyear = currentyear-1 + "-" + nextyear;
                    	        useremail1 = email;
                    	        String set0 = "0";
                                userRegService.updateConcurrentlogin(email,set0);
                                //userRegService.checkConcurrentlogin(email);
                                int refId = userRegService.getRefId(email);
                                int roleId = userRegService.getUserRoleId(refId);
                                String rolename = userRegService.getUserId(refId);
                                String dpcIdd = userRegService.getUserDpc(refId);
                                System.out.println("refId =====   "+refId);
                                System.out.println("dpcIdd =====   "+dpcIdd);
                                String region = userRegService.getUserRegion(refId);
                                String dpc_center = userRegService.getdpc_center(dpcIdd);
                                int is_ho = userRegService.getis_ho(email);
                                String roletype = userRegService.getroletypr(email);
                                String regionId = userRegService.getregionId(email);
                                String zoneId = userRegService.getzoneId(email);
                                System.out.println("dpc_center =====   "+dpc_center);
                                
                                
                                session.setAttribute("regionId", regionId);
                                session.setAttribute("zoneId", zoneId);
                                session.setAttribute("roletype", roletype);
                                session.setAttribute("is_ho", is_ho);
                                session.setAttribute("userId", refId);
                                session.setAttribute("usrname", email);
                                session.setAttribute("dpcId", dpcIdd);
                                session.setAttribute("region", region);
                                session.setAttribute("zone", dpcId);
                                session.setAttribute("roleId", roleId);
                                session.setAttribute("refId", refId);
                                session.setAttribute("rolename", rolename);
                                session.setAttribute("dpc_center", dpc_center);
                                session.setAttribute("userpass", password);
                                System.out.println("check");
                                //session.setAttribute("Concurrentloginflag",flag);
                                session.setAttribute("currCropYear", currCropYear);
                                session.setAttribute("priviouscropyear", priviouscropyear);
                                System.err.println("currCropYear"+currCropYear+"priviouscropyear"+priviouscropyear);
                                  mv= new ModelAndView( (View)new RedirectView("dashboardview.obj")); 
                                 System.out.println();
                         }
                         
                   }        
                     

            }catch(Exception e) {
                   System.out.println(e);
            }
            return mv;
      }
}
