package com.it.rmu.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;
	  
	  @Column(name = "username")
	  private String userName;
	  
	  @Column(name = "password")
	  private String password;
	  
	  @Column(name = "role_id")
	  private Integer roleId;
	  
	  @Column(name = "status")
	  private String status;
	  
	  @Column(name = "create_by")
	    private String createBy;

	  
	    @Column(name = "create_date")
	    private Date createDate;

	    @Column(name = "update_by")
	    private String updateBy;

	   
	    @Column(name = "update_date")
	    private Date updateDate;


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public Integer getRoleId() {
			return roleId;
		}


		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public String getCreateBy() {
			return createBy;
		}


		public void setCreateBy(String createBy) {
			this.createBy = createBy;
		}


		public Date getCreateDate() {
			return createDate;
		}


		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}


		public String getUpdateBy() {
			return updateBy;
		}


		public void setUpdateBy(String updateBy) {
			this.updateBy = updateBy;
		}


		public Date getUpdateDate() {
			return updateDate;
		}


		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
	    
	    

}
