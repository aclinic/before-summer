package ca.alexleung.lil.learningspring.web;

import ca.alexleung.lil.learningspring.business.domain.RoomReservation;
import ca.alexleung.lil.learningspring.business.service.ReservationService;
import ca.alexleung.lil.learningspring.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestsWebController {
    private final ReservationService reservationService;

    @Autowired
    public GuestsWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model) {
        List<Guest> allGuests = reservationService.getGuests();
        model.addAttribute("allGuests", allGuests);
        return "guests";
    }
}