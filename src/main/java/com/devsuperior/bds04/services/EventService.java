package com.devsuperior.bds04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable){
		Page<Event> list = repository.findAll(pageable);
		return list.map(x -> new EventDTO(x));
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event(); 
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());
		
		// Antes de associar, verificamos se a cidade realmente existe no banco
	    if (!cityRepository.existsById(dto.getCityId())) {
	        throw new ResourceNotFoundException("Id da cidade não encontrado: " + dto.getCityId());
	    }
	    
	    // Se existir, associamos usando a referencia dele
	    City city = cityRepository.getReferenceById(dto.getCityId());
		city.setId(dto.getCityId());
		entity.setCity(city);
		
		entity = repository.save(entity);
		return new EventDTO(entity);
	}
}
