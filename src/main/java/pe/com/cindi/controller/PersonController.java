package pe.com.cindi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pe.com.cindi.model.DetailPerson;
import pe.com.cindi.model.Person;

@Api(tags = "Details Persons", description = "Listado de Personas y Promedio de Edades")
@SuppressWarnings("deprecation")
@RestController
@RequestMapping("api/person")
public class PersonController {

	private static List<Person> listPerson;

	static {
		listPerson = new ArrayList<>();

		listPerson.add(new Person("Alvaro Daniel", "Aguinaga Delgado", 26, new Date(92, 3, 27)));
		listPerson.add(new Person("Gonzalo Andress", "Aguinaga Delgado", 24, new Date(95, 9, 10)));
		listPerson.add(new Person("Diego Renato", "Aguinaga Delgado", 29, new Date(89, 2, 06)));
		listPerson.add(new Person("Susan Aracelli", "Paucar Usca", 25, new Date(93, 04, 05)));
		listPerson.add(new Person("Maria del Carmen", "Delgado Vasquez", 53, new Date(65, 07, 06)));
	}

	@PostMapping("/add")
	private Map<String, String> addPerson(@RequestBody Person person) {
		Map<String, String> replyApi = new HashMap<>();

		replyApi.put("reply", "Se Agrego con Exito");
		return replyApi;
	}

	@GetMapping(value = "/avg-age", produces = MediaType.APPLICATION_JSON_VALUE)
	private Map<String, String> avgAgePerson() {

		OptionalDouble promEdad = listPerson.stream().mapToInt(Person::getAge).average();

		Map<String, String> map = new HashMap<>();
		map.put("average", String.valueOf(promEdad.getAsDouble()));
		return map;
	}

	@GetMapping(value = "/list-person", produces = MediaType.APPLICATION_JSON_VALUE)
	private DetailPerson detailPerson() {

		DetailPerson detailPerson = new DetailPerson();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		detailPerson.setDetailPerson(listPerson);

		List<String> deathDates = new ArrayList<>();

		for (Person person : listPerson) {
			if (person.getBirthDate().before(new Date(70, 12, 30))) {
				deathDates.add(person.getName() + " Fecha Probable:  " + dateFormat.format(new Date(130, 10, 12)));
			} else {
				deathDates.add(person.getName() + " Fecha Probable:  " + dateFormat.format(new Date(145, 10, 12)));

			}
			detailPerson.setDeathDate(deathDates);
		}

		return detailPerson;
	}
}
