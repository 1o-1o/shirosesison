package microservice.sc.util;

import java.io.Serializable;
import java.util.List;

public class ResultRestBody<T> implements Serializable{
	private int totalCount;
	private List<T> data;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
