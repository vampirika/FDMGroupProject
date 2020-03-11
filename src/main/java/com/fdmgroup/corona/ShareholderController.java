package com.fdmgroup.corona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.entities.BasicUser;
import com.fdmgroup.entities.Broker;
import com.fdmgroup.entities.Share;
import com.fdmgroup.entities.Shareholder;
import com.fdmgroup.entities.Sysadmin;
import com.fdmgroup.entities.UserFactory;
import com.fdmgroup.entities.UserRequest;
import com.fdmgroup.entities.Wallet;
import com.fdmgroup.repos.WalletRep;

@Controller
@SessionAttributes("userName")
public class ShareholderController {

	@Autowired
	private ShareDAO shdao = new ShareDAO();
	@Autowired
	private ShareholderDAO sholderdao = new ShareholderDAO();
	
	
	
	
	@GetMapping("/ViewShares")
	public String viewShares(Model model) {
		model.addAttribute("shares", shdao.listShares());
		return "ViewShares";
	}
	
	@GetMapping("/ShareholderTransactions")
	public String viewTransactions(Model model) {
		
		model.addAttribute("shares", shdao.listShares());
		
		return "ShareholderTransactions";
	}
	
	@GetMapping(value = "/buyshare", params="button=Buy")
	public String buyShare(@ModelAttribute(name = "userName")Shareholder shareholder, Model model, @RequestParam int shareid, @RequestParam int sharequantity) {
		
		model.addAttribute("shares", shdao.listShares());
		
		
		
		Map<Share,Integer> portfolio = new HashMap<Share,Integer>();
		portfolio = shareholder.getPortfolio();
		
		Share share = shdao.getShare(shareid);
		
		portfolio.put(share, sharequantity);
		
		shareholder.setPortfolio(portfolio);
		
		sholderdao.updateShareholder(shareholder);
		
		
		
		return "ShareholderTransactions";
	}
	
	@GetMapping(value = "/buyshare", params="button=Sell")
	public String sellShare(@ModelAttribute(name = "userName")Shareholder shareholder, Model model, @RequestParam int shareid, @RequestParam int sharequantity) {
		
		model.addAttribute("shares", shdao.listShares());
		
		
		
		Map<Share,Integer> portfolio = new HashMap<Share,Integer>();
		portfolio = shareholder.getPortfolio();
		
		Share share = shdao.getShare(shareid);
		
		
		
		
		if (portfolio.get(share) - sharequantity <= 0) {
			
			try {
				portfolio.remove(share);
			} catch (Exception e) {
				return "ShareholderTransactions";
			}
			
		}
		else {
			portfolio.put(share, portfolio.get(share) - sharequantity);
		}
		
		
		
		
		shareholder.setPortfolio(portfolio);
		
		sholderdao.updateShareholder(shareholder);
		
		
		
		return "ShareholderTransactions";
	}
	
	
	
	
	@GetMapping("/ViewPortfolio")
	public String viewPortfolio() {
		return "ViewPortfolio";
	}
	
}
