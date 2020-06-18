package com.srinath.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class User {

	
		@Id
		private int userId;
		
		private String food;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getFood() {
			return food;
		}
		public void setFood(String food) {
			this.food = food;
		}
		public User(int userId, String food) {
			super();
			this.userId = userId;
			this.food = food;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", food=" + food + "]";
		}
		public User() {
			super();
		
		}
		
		
		
}
