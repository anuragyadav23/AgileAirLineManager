package AirlineManager.Aircraft.Service;

import AirlineManager.Aircraft.DTO.AircraftDTO;
import AirlineManager.Aircraft.Mapper.MapperClass;
import AirlineManager.Aircraft.Model.Aircraft;
import AirlineManager.Aircraft.Repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements AircraftService{

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public Optional<AircraftDTO> getAircraft(String aircraftNo) {
        Optional<Aircraft> aircraft =  this.aircraftRepository.findByAircraftNo(aircraftNo);
        AircraftDTO aircraftDTO = MapperClass.mapAircraftToAircraftDTO(aircraft.get());
        return Optional.of(aircraftDTO);
    }

    @Override
    public AircraftDTO addAircraft(AircraftDTO aircraftDTO) {

        Aircraft aircraft = MapperClass.mapAircraftDTOToAircraft(aircraftDTO);
        this.aircraftRepository.save(aircraft);
        return aircraftDTO;
    }

    @Override
    public AircraftDTO updateAircraft(AircraftDTO aircraftDTO) {
        return null;
    }

    @Override
    public AircraftDTO deleteAircraft(AircraftDTO aircraftDTO) {
        return null;
    }
}
