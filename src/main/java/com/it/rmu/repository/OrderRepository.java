package com.it.rmu.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query("select t from OrderEntity t where t.userId = ?1")
    public OrderEntity findByUserDetail(Integer userId);
    
    @Query("SELECT o FROM OrderEntity o WHERE o.userId = :userId")
    List<OrderEntity> findByUserId(@Param("userId") Integer userId);


//    @Query("select t from UserEntity t where t.roleId = 1")
//    public List<UserEntity> findAllUser();

    @Modifying
    @Query("delete from OrderEntity t where t.id = ?1")
    void deleteByOrderId(Integer orderId);

   @Modifying
   @Query("UPDATE OrderEntity o SET o.userId = :userId, o.address = :address,o.phone = :phone, o.status = SUBSTRING(:status, 1, 255), o.updateBy = :updateBy, o.updateDate = :updateDate WHERE o.id = :id")
  void updateOrderDetails(Integer userId, String address, String phone, String status, String updateBy, Date updateDate, Integer id);

}