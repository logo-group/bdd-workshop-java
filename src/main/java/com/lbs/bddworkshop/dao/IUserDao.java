package com.lbs.bddworkshop.dao;

import com.lbs.bddworkshop.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface IUserDao extends JpaRepository<User, UUID> {
}
