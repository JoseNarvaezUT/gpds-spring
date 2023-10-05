package mx.edu.utez.gpds.service;

import mx.edu.utez.gpds.dto.AutomovilDto;
import mx.edu.utez.gpds.entity.Automovil;
import mx.edu.utez.gpds.repository.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutomovilService {
    @Autowired
    private AutomovilRepository automovilRepository;

    public void registrarAutomovil(AutomovilDto automovilDto) {
        Automovil automovil = new Automovil();
        automovil.setMarca(automovilDto.getMarca());
        automovil.setModelo(automovilDto.getModelo());
        automovil.setPrecio(automovilDto.getPrecio());
        automovil.setVersion(automovilDto.getVersion());
        automovilRepository.save(automovil);
    }

    public List<Automovil> obtenerTodosLosAutomoviles() {
        return automovilRepository.findAll();
    }

    public Optional<Automovil> obtenerAutomovilPorId(Long id) {
        return automovilRepository.findById(id);
    }
}
