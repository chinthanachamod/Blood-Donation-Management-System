package org.example.backend.service.impl;

import org.example.backend.dto.DonorDTO;
import org.example.backend.entity.Donor;
import org.example.backend.entity.DonorRequest;
import org.example.backend.enums.RequestStatus;
import org.example.backend.repository.DonorRepository;
import org.example.backend.repository.DonorRequestRepository;
import org.example.backend.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private DonorRequestRepository donorRequestRepository;

    @Override
    public DonorDTO registerDonor(DonorDTO donorDTO) {
        /*Checks if the donor is already registered using email or contact number.
        Converts DTO to Entity, saves it, then returns the DTO.*/

        if (donorRepository.existsByEmail(donorDTO.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }
        if (donorRepository.existsByContactNumber(donorDTO.getContactNumber())) {
            throw new RuntimeException("Contact number already registered.");
        }

        Donor donor = mapToEntity(donorDTO);

        //System.out.println("donor age : ............"+donor.getDonorAge());
        donor = donorRepository.save(donor);

        if(donor != null) {
            System.out.println("Donor Registered Successfully");

            DonorRequest donorRequest = new DonorRequest();

            donorRequest.setDonorName(donor.getDonorName());
            donorRequest.setBloodGroup(donor.getBloodGroup());
            donorRequest.setContact(donor.getContactNumber());
            donorRequest.setHospitalName(donor.getHospitalName());
            donorRequest.setStatus(RequestStatus.PENDING);
            donorRequest.setRequestDate(LocalDateTime.now());
            donorRequestRepository.save(donorRequest);
            System.out.println("Donor Requested for Blood Donation Successfully");

            if (donorRequest != null) {
                System.out.println("Donor Requested for Blood Donation Successfully");

                return mapToDTO(donor);
            } else {
                throw new RuntimeException("Donor Request Failed");
            }

        }else{
            throw new RuntimeException("Donor not registered.");
        }
    }

    @Override
    public DonorDTO getDonorById(Long id) {     // Fetches donor details by ID and converts it to DTO.
        Donor donor = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found."));
        return mapToDTO(donor);
    }

    @Override
    public List<DonorDTO> getAllDonors() {      // Retrieves all donors and converts them to DTO format.
        List<Donor> donors = donorRepository.findAll();
        return donors.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public DonorDTO updateDonor(Long id, DonorDTO donorDTO) {       // Updates donor details if the donor exists.
        Donor donor = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found."));

        donor.setDonorName(donorDTO.getDonorName());
        donor.setDonorAge(donorDTO.getDonorAge());
        donor.setBloodGroup(donorDTO.getBloodGroup());
        donor.setGender(donorDTO.getGender());
        donor.setContactNumber(donorDTO.getContactNumber());
        donor.setDistrict(donorDTO.getDistrict());
        donor.setEmail(donorDTO.getEmail());
        donor.setHomeAddress(donorDTO.getHomeAddress());
        donor.setHospitalName(donorDTO.getHospitalName());
        donor.setLastDonationDate(donorDTO.getLastDonationDate());

        donor = donorRepository.save(donor);
        return mapToDTO(donor);
    }

    @Override
    public void deleteDonor(Long id) {      // Deletes a donor if the ID exists.
        if (!donorRepository.existsById(id)) {
            throw new RuntimeException("Donor not found !");
        }
        donorRepository.deleteById(id);
    }

    private DonorDTO mapToDTO(Donor donor) {        // Converts Entity to DTO.
        DonorDTO donorDTO = new DonorDTO();
        donorDTO.setId(donor.getId());
        donorDTO.setDonorName(donor.getDonorName());
        donorDTO.setDonorAge(donor.getDonorAge());
        donorDTO.setBloodGroup(donor.getBloodGroup());
        donorDTO.setGender(donor.getGender());
        donorDTO.setContactNumber(donor.getContactNumber());
        donorDTO.setDistrict(donor.getDistrict());
        donorDTO.setEmail(donor.getEmail());
        donorDTO.setHomeAddress(donor.getHomeAddress());
        donorDTO.setHospitalName(donor.getHospitalName());
        donorDTO.setLastDonationDate(donor.getLastDonationDate());
        return donorDTO;
    }

    private Donor mapToEntity(DonorDTO donorDTO) {        // Converts DTO to Entity.
        Donor donor = new Donor();
        donor.setDonorName(donorDTO.getDonorName());
        donor.setDonorAge(donorDTO.getDonorAge());
        donor.setBloodGroup(donorDTO.getBloodGroup());
        donor.setGender(donorDTO.getGender());
        donor.setContactNumber(donorDTO.getContactNumber());
        donor.setDistrict(donorDTO.getDistrict());
        donor.setEmail(donorDTO.getEmail());
        donor.setHomeAddress(donorDTO.getHomeAddress());
        donor.setHospitalName(donorDTO.getHospitalName());
        donor.setLastDonationDate(donorDTO.getLastDonationDate());
        return donor;
    }
}
