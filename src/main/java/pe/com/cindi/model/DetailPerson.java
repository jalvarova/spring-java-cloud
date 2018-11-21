	package pe.com.cindi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@ApiModel(description = "Detalle de Personas")
public class DetailPerson {

	@ApiModelProperty(
		      value = "List Person",
		      example = "Aguinaga")
	@JsonProperty(value="persons")
	private List<Person> detailPerson;
	
	@ApiModelProperty(
		      value = "Probable death date",
		      example = "Aguinaga")
	@JsonProperty(value="deathDates")
	private List<String> deathDate;
}
