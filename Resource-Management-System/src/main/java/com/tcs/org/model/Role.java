package com.tcs.org.model;

import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

import com.tcs.org.audit.AuditableEntity;

import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 01/08/17.
 */
@Entity
@Table(name = "roles")

public class Role /*extends AuditableEntity*/ {

	@Id
	@GeneratedValue
	private int roleId;
  /*  @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;*/
	private String name;
    private String type;
    private String description;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }


    public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
