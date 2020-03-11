package com.fdmgroup.corona;

import java.util.ArrayList;
import java.util.List;

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
import com.fdmgroup.entities.ShareRequest;
import com.fdmgroup.entities.Trade;
import com.fdmgroup.entities.UserRequest;
import com.fdmgroup.repos.TradeRep;


@Controller
@SessionAttributes("userName")
public class BrokerController {

	@Autowired
	TradeDAO tradeserv = new TradeDAO() ;

	@Autowired
	ShareReqDAO sharereqserv = new ShareReqDAO();
	
	@Autowired
	ShareDAO shareserv = new ShareDAO();

	
	Trade t1 = new Trade();
	Trade t2 = new Trade();
	Trade t3 = new Trade();
	Trade t4 = new Trade();

	
	@GetMapping("tradeList")
	public String showTradeList(@ModelAttribute(name = "userName")BasicUser userName, Model model) {

		model.addAttribute("trades", tradeserv.listTrades());
		return "BrokerTradePage";
	}
	
	
	@GetMapping("shareReqList")
	public String showShareReqList(Model model) {
		
		List<ShareRequest> allUserRequest = sharereqserv.listSHareRequests();

		model.addAttribute("share", allUserRequest);
		
		return "BrokerRequestPage";
	}
	@PostMapping("shareReqResult")
	public String shareReqRez(@RequestParam String[] cb, Model model) {
		List<Share> approvedShareRequest = new ArrayList<Share>();
		for (String i : cb) {
			System.out.println(i);
			
			ShareRequest shareRequestObtainedFromDatabase = sharereqserv.getShare(Integer.parseInt(i)); // Getting the shares and share request
			int shareId = shareRequestObtainedFromDatabase.getShareId();
			Share sh = shareserv.getShare(shareId);
			approvedShareRequest.add(sh);
		
	
		
	}
		return "BrokerRequestPage";
		}
	}
	


