package model;
/**
 * 극장 정보를 담는 클래스
 */
public class Theater {
	private String thtrCd = "";    
	private String thtrNm = "";       
	private String loc1 = "";          
	private String loc2 = "";
	private int thtrSeatCnt; 
	private String thtrAddr = "";
	private String playStrtDt = "";
	private String playEndDt = "";
	
	public Theater() {}
	public Theater(String thtrCd, String thtrNm, String loc1, String loc2, int thtrSeatCnt, String thtrAddr,
			String playStrtDt, String playEndDt) {
		super();
		this.thtrCd = thtrCd;
		this.thtrNm = thtrNm;
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.thtrSeatCnt = thtrSeatCnt;
		this.thtrAddr = thtrAddr;
		this.playStrtDt = playStrtDt;
		this.playEndDt = playEndDt;
	}
	public Theater(String thtrCd, String thtrNm, String loc1, String loc2, int thtrSeatCnt, String thtrAddr) {
		super();
		this.thtrCd = thtrCd;
		this.thtrNm = thtrNm;
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.thtrSeatCnt = thtrSeatCnt;
		this.thtrAddr = thtrAddr;
	}

	public String getPlayStrtDt() {
		return playStrtDt;
	}

	public void setPlayStrtDt(String playStrtDt) {
		this.playStrtDt = playStrtDt;
	}

	public String getPlayEndDt() {
		return playEndDt;
	}

	public void setPlayEndDt(String playEndDt) {
		this.playEndDt = playEndDt;
	}

	public String getThtrCd() {
		return thtrCd;
	}

	public void setThtrCd(String thtrCd) {
		this.thtrCd = thtrCd;
	}

	public String getThtrNm() {
		return thtrNm;
	}

	public void setThtrNm(String thtrNm) {
		this.thtrNm = thtrNm;
	}

	public String getLoc1() {
		return loc1;
	}

	public void setLoc1(String loc1) {
		this.loc1 = loc1;
	}

	public String getLoc2() {
		return loc2;
	}

	public void setLoc2(String loc2) {
		this.loc2 = loc2;
	}

	public int getThtrSeatCnt() {
		return thtrSeatCnt;
	}

	public void setThtrSeatCnt(int thtrSeatCnt) {
		this.thtrSeatCnt = thtrSeatCnt;
	}

	public String getThtrAddr() {
		return thtrAddr;
	}

	public void setThtrAddr(String thtrAddr) {
		this.thtrAddr = thtrAddr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Theater [thtrCd=");
		builder.append(thtrCd);
		builder.append(", thtrNm=");
		builder.append(thtrNm);
		builder.append(", loc1=");
		builder.append(loc1);
		builder.append(", loc2=");
		builder.append(loc2);
		builder.append(", thtrSeatCnt=");
		builder.append(thtrSeatCnt);
		builder.append(", thtrAddr=");
		builder.append(thtrAddr);
		builder.append(", playStrtDt=");
		builder.append(playStrtDt);
		builder.append(", playEndDt=");
		builder.append(playEndDt);
		builder.append("]");
		return builder.toString();
	}
} // end of class
