package com.appranix.LiveBackUp.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LiveBackUp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String environmentId;
    
    private Date createdDateTime;
    
    private String createdUser;
    
    private String schedulerRefId;
    
    private String policyName;
    
    private HashMap<String, String> backUpFrequency;
    
    private String retention;
    
//    TODO: look how to add frequency object
//    private Frequency frequency;
    
//  TODO: look how to add retention object
//  private Retention retention;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(String environmentId) {
		this.environmentId = environmentId;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getSchedulerRefId() {
		return schedulerRefId;
	}

	public void setSchedulerRefId(String schedulerRefId) {
		this.schedulerRefId = schedulerRefId;
	}

	public HashMap<String, String> getBackUpFrequency() {
		return backUpFrequency;
	}

	public void setBackUpFrequency(HashMap<String, String> backUpFrequency) {
		this.backUpFrequency = backUpFrequency;
	}

	public String getRetention() {
		return retention;
	}

	public void setRetention(String retention) {
		this.retention = retention;
	}
}
