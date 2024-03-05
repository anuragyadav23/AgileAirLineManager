package AirlineManager.Aircraft.Controller;

import AirlineManager.Aircraft.DTO.AircraftDTO;
import AirlineManager.Aircraft.Service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/fetch")
    public ResponseEntity<Optional<AircraftDTO>> getAircraft(@RequestParam String aircraftNo)
    {
        Optional<AircraftDTO> aircraftDTO = this.aircraftService.getAircraft(aircraftNo);
        return ResponseEntity.status(HttpStatus.FOUND).body(aircraftDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<AircraftDTO> addAircraft(@RequestBody AircraftDTO aircraftDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.aircraftService.addAircraft(aircraftDTO));
    }


}
