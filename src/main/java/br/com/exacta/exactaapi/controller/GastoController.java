package br.com.exacta.exactaapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exacta.exactaapi.entity.Gasto;
import br.com.exacta.exactaapi.service.GastoService;



@RestController
@RequestMapping("/gasto")
public class GastoController {
	
	@Autowired
	private GastoService gastoService;

	@GetMapping
	public ResponseEntity<List<Gasto>> listarGastos() {
		return ResponseEntity.ok(gastoService.listarGastos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Gasto> detalharGasto(@PathVariable Long id) {
		Optional<Gasto> gastoOptional = gastoService.findById(id);
		if (gastoOptional.isPresent()) {
			return ResponseEntity.ok(gastoOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Gasto> novoGasto(@RequestBody @Valid Gasto gasto){
		return ResponseEntity.ok(gastoService.salvar(gasto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Gasto> alterarGasto(@PathVariable Long id, @RequestBody @Valid Gasto gasto){
		Optional<Gasto> gastoOptional = gastoService.findById(id);
		if (gastoOptional.isPresent()) {
			gasto.setId(gastoOptional.get().getId());
			return ResponseEntity.ok(gastoService.salvar(gasto));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> removerGasto(@PathVariable Long id) {
        Optional<Gasto> gastoOptional = gastoService.findById(id);
        if(gastoOptional.isPresent()) {
        	gastoService.remover(gastoOptional.get().getId());
        	return ResponseEntity.ok().build();            
        }
        return ResponseEntity.notFound().build();
    }
	
}
