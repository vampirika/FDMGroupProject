package com.fdmgroup.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.ShareRequest;

public interface ShareRequestRep extends JpaRepository<ShareRequest, Integer>
{
Optional<ShareRequest> findIdByShareId(int shareRequestId);


}
