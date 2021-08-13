package com.captal.account.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.captal.account.Dao.CapitalAccountRepo;
import com.captal.account.Model.CapitalAccountClass;
import com.captal.account.service.CapitalAccountService;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CapitalAccountController {

@Autowired
CapitalAccountService service;

@Autowired 
CapitalAccountRepo repo;
	
@RequestMapping({"/hello"})
public String hello()
{
	return "layout1";
}



@RequestMapping(value="/",method=RequestMethod.GET)
public String GetAllCapitalAccount(Model model)
 {

	model.addAttribute("searchById",service.getAllCapitalAccount());
	return "index1";
	
}

@GetMapping("/showNewCapitalAccountForm")
public String ShowNewMasterForm(Model model)
{

CapitalAccountClass ca = new CapitalAccountClass();

model.addAttribute("addcapitalaccount",ca);

return "new_form";

}

@PostMapping("/SaveMasterData")
public String SaveCapitalAccount(@ModelAttribute("account") CapitalAccountClass ca)	
{
	service.SaveCapitalAccount(ca);
	System.out.println(ca.getParticulars());
	System.out.println(ca.getDebit());
	System.out.println(ca.getCredit());
	return "redirect:/";
}


@GetMapping("/showFormForUpdate/{id}")
public String UpdateCapitalAccount(@PathVariable (value ="id" ) int id ,Model model )	
{
	
	CapitalAccountClass ca=service.geAccountTypeById(id);
	
	model.addAttribute("account",ca);
	
	System.out.println("id: "+ca.getId());
	System.out.println("Debit: "+ca.getDebit());
	System.out.println("credit: "+ca.getCredit());
	
	return "update_form";
}

@GetMapping("/deleteTrialBalance/{id}")
public String deleteTrialBalance(@PathVariable (value="id") int id)
{
		this.service.deleteTrialBalanceBytId(id);
		return "redirect:/";
	
}	


@GetMapping("/searchById")
public String searchById(Model model,int id )

{
    
        if(id !=0)
        {
        model.addAttribute("searchById",service.findById(id));
	   
        }
        	
       
        
		return "index1.html";
	
}	


@GetMapping("/searchByParticular")
public String searchByParticular(Model model,String particulars )

{
    
        if(particulars !=null)
        {
        model.addAttribute("searchById",service.findByParticularsSorted(particulars));
	    }
        	
       
        
		return "index1.html";
	
}	

@GetMapping("/searchByDebit")
public String searchByDebit(Model model,double debit )

{
    
        if(debit != 0)
        {
        model.addAttribute("searchById",service.findByDebit(debit));
	    }
        	
       
        
		return "index1.html";
	
}	

@GetMapping("/searchByCredit")
public String searchByCredit(Model model,double credit )

{
    
        if(credit != 0)
        {
        model.addAttribute("searchById",service.findByCredit(credit));
	    }
        	
       
        
		return "index1.html";
	
}	

@GetMapping("/searchByCreditGreater")
public String searchByCreditGreater(Model model,double credit )

{
    
        if(credit != 0)
        {
        model.addAttribute("searchById",service.findByCreditGreaterThan(credit));
	    }
        	
       
        
		return "index1.html";
	
}


	
}