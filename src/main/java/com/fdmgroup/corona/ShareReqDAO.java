package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Share;
import com.fdmgroup.entities.ShareRequest;
import com.fdmgroup.entities.UserRequest;
import com.fdmgroup.repos.ShareRequestRep;

@Service
public class ShareReqDAO {
@Autowired 
private ShareRequestRep sharerep;

private Optional<ShareRequest> shareRequests;
private List<ShareRequest> allShareRequests;

public void addShareRequest(ShareRequest shareRequest) {
	shareRequests = sharerep.findIdByShareId(shareRequest.getShareId());
	if (!shareRequests.isPresent()) {

		sharerep.save(shareRequest);
	}
}

public ShareRequest getShareRequest(int shareRequestId)
{
	shareRequests = sharerep.findById(shareRequestId); 
	if(shareRequests.isPresent()) {
		return shareRequests.get();
		
	}else {
		return null;
	}
}


public ShareRequest getShare(int shareId)
{
	Optional<ShareRequest> sh = sharerep.findIdByShareId(shareId) ;
	if(shareRequests.isPresent()) {
		return sh.get();
		
	}else {
		return null;
	}
}

public void removeShareRequest(int shareRequestId)
{
	shareRequests = sharerep.findById(shareRequestId);
	
	if(shareRequests.isPresent()) {
		sharerep.delete(shareRequests.get());
	}

}

public void updateShareRequest (ShareRequest shareRequest) {
	shareRequests = sharerep.findIdByShareId(shareRequest.getShareReqId());
	if (shareRequests.isPresent()) {
		sharerep.save(shareRequest);
		System.out.println("shareRequest changed");
	}
}


public List<ShareRequest> listSHareRequests() {
	allShareRequests = sharerep.findAll();

	return allShareRequests;
}
public ShareReqDAO() {

}

}
