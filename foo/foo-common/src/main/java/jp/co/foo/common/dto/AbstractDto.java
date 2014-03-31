package jp.co.foo.common.dto;

import java.util.Date;

public abstract class AbstractDto<ID> {

	protected ID id;
	
	protected long version;
	
	protected String updatedAccount;
	
	protected Date updatedAt;
	
	protected String createdAccount;

	protected Date createdAt;

	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(long version) {
		this.version = version;
	}

	/**
	 * @return the updatedAccount
	 */
	public String getUpdatedAccount() {
		return updatedAccount;
	}

	/**
	 * @param updatedAccount the updatedAccount to set
	 */
	public void setUpdatedAccount(String updatedAccount) {
		this.updatedAccount = updatedAccount;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the createdAccount
	 */
	public String getCreatedAccount() {
		return createdAccount;
	}

	/**
	 * @param createdAccount the createdAccount to set
	 */
	public void setCreatedAccount(String createdAccount) {
		this.createdAccount = createdAccount;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
