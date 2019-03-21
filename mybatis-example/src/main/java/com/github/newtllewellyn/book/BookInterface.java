package com.github.newtllewellyn.book;

import java.math.BigDecimal;
import java.util.UUID;

public class BookInterface {
	protected String name;
	protected BigDecimal price;
	protected String press;
	private String uuid;
	
	
		
	public BookInterface() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookInterface(String bid, String name, BigDecimal price, String press) {
		this.name = name;
		this.price = price;
		this.press = press;
		if(bid == null) {
			bid = UUID.randomUUID().toString();
		}
		this.uuid = bid;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPress() {
		return this.press;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((press == null) ? 0 : press.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInterface other = (BookInterface) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (press == null) {
			if (other.press != null)
				return false;
		} else if (!press.equals(other.press))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookInterface [name=" + name + ", price=" + price + ", press=" + press + ", uuid=" + uuid
				+ ", getUuid()=" + getUuid() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getPress()=" + getPress() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}