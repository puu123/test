package jp.co.foo.common.dto;

public abstract class AbstractExample {
	
	protected Integer limit;
	
	protected Integer offset;
	
	protected boolean forUpdate;

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * @return the forUpdate
	 */
	public boolean isForUpdate() {
		return forUpdate;
	}

	/**
	 * @param forUpdate the forUpdate to set
	 */
	public void setForUpdate(boolean forUpdate) {
		this.forUpdate = forUpdate;
	}
}
