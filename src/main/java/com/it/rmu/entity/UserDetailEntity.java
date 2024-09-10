package com.it.rmu.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_detail")
public class UserDetailEntity {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;
	 
	 @Column(name = "user_id")
	    private Integer userId;
	 
	 @Column(name = "frist_name")
	    private String fristName;
	 
	 @Column(name = "last_name")
	    private String lastName;
	 
	 @Column(name = "phone")
	    private String phone;
	 
	 @Column(name = "age")
	    private String age;
	 
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

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getFristName() {
			return fristName;
		}

		public void setFristName(String fristName) {
			this.fristName = fristName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
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
