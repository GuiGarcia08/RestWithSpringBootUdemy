package br.com.guilherme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.converter.DozerConverter;
import br.com.guilherme.converter.custom.PersonConverter;
import br.com.guilherme.data.model.Person;
import br.com.guilherme.data.vo.PersonVO;
import br.com.guilherme.data.vo.v2.PersonVOV2;
import br.com.guilherme.exception.ResourceNotFoundException;
import br.com.guilherme.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person);
		var vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
