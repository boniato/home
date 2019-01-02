package com.home.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lee on 2019.01.02
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByGithub(String github);
}