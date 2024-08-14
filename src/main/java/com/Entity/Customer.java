package com.Entity;


import java.io.Serializable; 
import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.NoArgsConstructor; 
import org.springframework.data.annotation.Id; 
import org.springframework.data.redis.core.RedisHash; 
import org.springframework.data.redis.core.index.Indexed; 

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Customer") 
public class Customer { 

	@Id
	@Indexed
	private int id;  
					 
	private String name; 
	private long phone; 
	private String email; 
}

