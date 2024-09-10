package com.it.rmu.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


	
	@Entity
	@Table(name = "role")
	@Data
	public class RoleEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "role_name")
	    private String roleName;

	    @Column(name = "role_description")
	    private String roleDescription;

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

	    public String getRoleName() {
	        return roleName;
	    }

	    public void setRoleName(String roleName) {
	        this.roleName = roleName;
	    }

	    public String getRoleDescription() {
	        return roleDescription;
	    }

	    public void setRoleDescription(String roleDescription) {
	        this.roleDescription = roleDescription;
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
