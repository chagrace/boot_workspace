package com.sds.testapp.common;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Pager {
	private int totalRecord; //총 레코드 수
	private int pageSize=10; //페이지당 레코드 수
	private int totalPage; //총 페이지 수
	private int blockSize=10; //블럭당 페이지 수
	private int currentPage=1; //현재 페이지(기본값은 1)
	private int firstPage; //블럭당 반복문의 시작 값
	private int lastPage; //블럭당 반복문의 끝 값
	private int curPos; //페이지당 List에서의 시작 index
	private int startIndex;
	private int num; //페이지당 시작 번호
	
	public void init(int totalRecord, int currentPage) {
		this.totalRecord = totalRecord;
		this.totalPage = (int)Math.ceil((float)totalRecord/pageSize);
		this.currentPage = currentPage;
		this.firstPage = this.currentPage - (this.currentPage-1) % blockSize;
		this.lastPage = this.firstPage + (this.blockSize-1);
		
		//thymeleaf에는 break문이 없으므로 lastPAge에 대한 조건을 부여
		//lastPage보다 totalPage가 더 작으면, totalPage가 lastPage가 되면 된다
		if(this.totalPage < this.lastPage) {
			this.lastPage = this.totalPage;
		}
		this.startIndex = (this.currentPage-1) * this.pageSize;
		this.num = this.totalRecord - this.startIndex;
	}
}