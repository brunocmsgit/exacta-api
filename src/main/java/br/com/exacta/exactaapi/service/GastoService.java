package br.com.exacta.exactaapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exacta.exactaapi.entity.Gasto;
import br.com.exacta.exactaapi.repository.GastoRepository;

@Service
public class GastoService {
	
	@Autowired
	private GastoRepository gastoRepository;
	
	public List<Gasto> listarGastos() {
		return gastoRepository.findAll();
	}
	
	public Gasto detalhar(Long id) {
		return gastoRepository.getOne(id);
	}
	
	public Gasto salvar(Gasto gasto) {
		gasto.setDataHora(LocalDateTime.now());
		return gastoRepository.save(gasto);
	}
	
	public void remover(Long id) {
		gastoRepository.deleteById(id);
	}

	public Optional<Gasto> findById(Long id) {
		return gastoRepository.findById(id);
	}

}
