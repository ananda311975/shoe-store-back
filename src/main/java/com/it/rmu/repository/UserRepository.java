package com.it.rmu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.UserEntity;

@Repository
public interface UserRepository extends  JpaRepository<UserEntity, Integer>{


	@Query("select t from UserEntity t where t.userName=?1")
	public UserEntity findByUserName(String userName);
	
	  @Query("select t from UserEntity t where t.userName = ?1 and t.password =?2 ")
	    public UserEntity findByUserNameAndPassword(String userName, String password);
	  
	    @Query("select t from UserEntity t where t.roleId = 1 ")
	    public List<UserEntity> findAllUser();
	    
	    @Modifying(clearAutomatically = true)
	    @Query("delete from UserEntity t where t.id = ?1")
	    void deleteByUserId(Integer userId);
}
