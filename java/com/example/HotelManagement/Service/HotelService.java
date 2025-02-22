package com.example.HotelManagement.Service;

import com.example.HotelManagement.Communicator.RestTemplateCommunicator;
import com.example.HotelManagement.DTO.HotelDto;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RestTemplateCommunicator restTemplateCommunicator;

    public Hotel saveHotel(HotelDto hotelDto) {
        Hotel hotel=new Hotel();
        hotel.setName(hotelDto.getName());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setCity(hotelDto.getCity());
        hotel.setPostalCode(hotelDto.getPostalCode());
        hotel.setRating(hotelDto.getRating());
        hotel.setAvailable(hotelDto.isAvailable());
        hotelRepository.save(hotel);
        return hotel;
    }
    public List<Hotel> getallhotels() {
         return hotelRepository.findAll();
    }
    public void  GetHotelByid(long id) {
       Optional<Hotel> h= hotelRepository.findById(id);
       if(h.isPresent()){
        hotelRepository.deleteById(id);
       }
    }

    public Hotel getHotel(long id){
    Optional<Hotel> hotelbox=hotelRepository.findById(id);

    Float hotelActualRating=restTemplateCommunicator.getActualRating(id);
    Hotel hotel=hotelbox.get();
    hotel.setRating(hotelActualRating);
        if(hotelbox.isPresent()){
            return hotel;
        }
        else{
            return null;
        }
    }
    public Hotel updatehotel(HotelDto hotelDto, long id) {
        Hotel hotel=getHotel(id);
        if(hotel!=null){
            hotel.setName(hotelDto.getName());
            hotel.setAddress(hotelDto.getAddress());
            hotel.setCity(hotelDto.getCity());
            hotel.setPostalCode(hotelDto.getPostalCode());
            hotel.setRating(hotelDto.getRating());
            hotel.setAvailable(hotelDto.isAvailable());
            hotelRepository.save(hotel);
            return hotel;
        }
        else{
            return null;
        }
    }
    public Hotel updatehoteladdress(UpdateHotelAddressDTO hoteladdress, long id) {
       Hotel hotel=getHotel(id);
       if(hotel!=null){
        hotel.setAddress(hoteladdress.getAddress());
        hotel.setCity(hoteladdress.getCity());
        hotel.setPostalCode(hoteladdress.getPostalCode());
        hotelRepository.save(hotel);
        return hotel;
       }
       else{
        return null;
       }
    }
    public float FindRating(String name) {
        return hotelRepository.getrating(name);
    }
}
