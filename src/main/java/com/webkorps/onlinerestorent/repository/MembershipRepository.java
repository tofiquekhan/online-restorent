package com.webkorps.onlinerestorent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.onlinerestorent.entity.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long>{

}
