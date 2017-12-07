package com.yuzhi.bean;

public class MovieTable {
	private int id;
	private String movieName;
	private String time;
	private String url;
	private String imagePath;
	private String saveImagePath;
	private float score;
	private int status;
	private String source;
	private String timePublish;

	@Override
	public String toString() {
		return "MovieTable [id=" + id + ", movieName=" + movieName + ", time=" + time + ", url=" + url + ", imagePath="
				+ imagePath + ", saveImagePath=" + saveImagePath + ", score=" + score + ", status=" + status
				+ ", source=" + source + ", timePublish=" + timePublish + "]";
	}

	public String getTimePublish() {
		return timePublish;
	}

	public void setTimePublish(String timePublish) {
		this.timePublish = timePublish;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getSaveImagePath() {
		return saveImagePath;
	}

	public void setSaveImagePath(String saveImagePath) {
		this.saveImagePath = saveImagePath;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
