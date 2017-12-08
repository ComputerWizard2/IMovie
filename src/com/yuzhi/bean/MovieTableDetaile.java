package com.yuzhi.bean;

public class MovieTableDetaile {
	private int id;
	private String director;
	private String keyword;
	private String categroy;
	private String des;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCategroy() {
		return categroy;
	}

	public void setCategroy(String categroy) {
		this.categroy = categroy;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "MovieTableDetaile [id=" + id + ", director=" + director + ", keyword=" + keyword + ", categroy="
				+ categroy + ", des=" + des + "]";
	}

}
