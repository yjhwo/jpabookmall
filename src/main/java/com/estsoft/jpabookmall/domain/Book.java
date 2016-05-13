package com.estsoft.jpabookmall.domain;

import javax.persistence.Column;
import javax.persistence.Entity; 		// JPA
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

// Book 클래스를 그냥 Entity라고 일컫음
// domain entity
@Entity
@Table(name = "book")
public class Book {
	
	// Id : primary key
	// GeneratedValue : Auto Increment
	@Id
	@Column(name = "no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "price")
	private Long price;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Transient
	private String test;		// 영속화 시키지 않고, 비영속 상태로 놔두겠다.
	
	@ManyToOne
	@JoinColumn(name = "category_no", nullable = true)
	private Category category;
	
	public Book(){	}

	public Book(Long no, String title, Long price) {
		this.no = no;
		this.title = title;
		this.price = price;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", price=" + price + ", description=" + description + ", test="
				+ test + ", category=" + category + "]";
	}
	
	
}
