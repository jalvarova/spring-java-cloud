package pe.com.cindi.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Information the Persons")
public class Person {
	
	@ApiModelProperty(
		      value = "Name the Person",
		      example = "Alvaro")
	private String name;

	@ApiModelProperty(
		      value = "LastName the Person",
		      example = "Aguinaga")
	private String lastName;

	@ApiModelProperty(
		      value = "Age of the Person",
		      example = "12")
	private int age;

	@ApiModelProperty(
		      value = "Birthdate of the Person",
		      example = "Alvaro")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
}
