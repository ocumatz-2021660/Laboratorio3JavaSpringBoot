package com.oscarcumatzl.SportStore.repository;

import com.oscarcumatzl.SportStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {




}
