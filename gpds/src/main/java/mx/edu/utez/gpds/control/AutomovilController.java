package mx.edu.utez.gpds.control;

import mx.edu.utez.gpds.dto.AutomovilDto;
import mx.edu.utez.gpds.entity.Automovil;
import mx.edu.utez.gpds.repository.AutomovilRepository;
import mx.edu.utez.gpds.service.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automoviles")
public class AutomovilController {

    @Autowired
    private AutomovilRepository automovilRepository; // Inyecta el repositorio JPA

    @Autowired
    private AutomovilService automovilService; // Supongamos que tienes un servicio para manejar la lógica de los automóviles

    // Endpoint para registrar un nuevo automóvil
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarAutomovil(@RequestBody AutomovilDto automovilDto) {
        try {
            // Aquí puedes llamar al servicio para registrar el automóvil
            automovilService.registrarAutomovil(automovilDto);
            // Si se registró correctamente, puedes responder con un mensaje de éxito
            return ResponseEntity.status(HttpStatus.CREATED).body("Automóvil registrado con éxito.");
        } catch (Exception e) {
            // En caso de error, puedes responder con un mensaje de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el automóvil.");
        }
    }
    // Endpoint para obtener todos los automóviles
    @GetMapping("/todos")
    public List<Automovil> obtenerTodosLosAutomoviles() {
        return automovilService.obtenerTodosLosAutomoviles();
    }

    // Endpoint para obtener un automóvil por su ID
    @GetMapping("/{id}")
    public Automovil obtenerAutomovilPorId(@PathVariable Long id) {
        return automovilService.obtenerAutomovilPorId(id).orElse(null);
    }
}
