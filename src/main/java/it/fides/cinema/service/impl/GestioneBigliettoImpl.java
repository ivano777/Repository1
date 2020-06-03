package it.fides.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.repository.BigliettoRepository;
import it.fides.cinema.service.GestioneBiglietto;

@Service
@Transactional
public class GestioneBigliettoImpl implements GestioneBiglietto {
	
	@Autowired
	private BigliettoRepository bigliettoRepository;
	private DozerBeanMapper mapper;
	
	@Override
	public Set<BigliettoDto> findAll() {
		mapper = new DozerBeanMapper();
		Set<BigliettoDto> setBigliettoDto = new HashSet<BigliettoDto>();
		bigliettoRepository.findAll().forEach(biglietto -> {
			BigliettoDto bigliettoDto = new BigliettoDto();
			bigliettoDto = mapper.map(biglietto, BigliettoDto.class);
			setBigliettoDto.add(bigliettoDto);
		});
		 return setBigliettoDto;
	}
	
	public List<BigliettoDto> testBiglietto(String fila) {
		mapper = new DozerBeanMapper();
		List<BigliettoDto> bigliettiDto = new ArrayList<BigliettoDto>();
		bigliettoRepository.testBiglietto(fila).forEach( biglietto -> {
			BigliettoDto bigliettoDto = new BigliettoDto();
			bigliettoDto = mapper.map(biglietto, BigliettoDto.class);
			bigliettiDto.add(bigliettoDto);
		});
		return bigliettiDto;
	}

	@Override
	public <Optional> BigliettoDto findById(Long id) {
		mapper = new DozerBeanMapper();
		return mapper.map(bigliettoRepository.findById(id).get(),BigliettoDto.class);
	}

}