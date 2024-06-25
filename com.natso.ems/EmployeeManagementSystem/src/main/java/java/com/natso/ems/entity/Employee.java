package java.com.natso.ems.entity;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Employee {
	@Id
	private int id;
	private String name;
	private int age;
	private String gender;
	@Column(unique = true, nullable = false)
	private long phone;
	@Column(nullable = false)
	private String email;


}
