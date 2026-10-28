package fr.medassi.democours.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import fr.medassi.democours.models.Equipement;
import fr.medassi.democours.models.Imprimante;
import fr.medassi.democours.models.Ordinateur;
import fr.medassi.democours.models.Service;
import fr.medassi.democours.repositories.EquipementRepository;
import fr.medassi.democours.repositories.ServiceRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EquipementController {
    private final EquipementRepository equipementRepository;
    private final ServiceRepository serviceRepository;

    public EquipementController(EquipementRepository equipementRepository, ServiceRepository serviceRepository) {
        this.equipementRepository = equipementRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/")
    public String getEquipements(Model model, Authentication authentication) {
        List<Equipement> equipements = equipementRepository.findAll();
        boolean isAdmin = authentication != null && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN") || a.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("equipements", equipements);
        return "liste";
    }

    @GetMapping("/addOrdinateur")
    public String addOrdinateur(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "add_ordinateur";
    }

    @GetMapping("/addImprimante")
    public String addImprimante(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "add_imprimante";
    }

    @PostMapping("/addOrdinateur")
    public String addOrdinateur(@ModelAttribute Ordinateur ordinateur, @RequestParam Long serviceId) {
        if (serviceId != null) {
            Service service = serviceRepository.findById(serviceId).orElse(null);
            ordinateur.setService(service);
        }
        equipementRepository.save(ordinateur);
        return "redirect:/";
    }

    @PostMapping("/addImprimante")
    public String addImprimante(@ModelAttribute Imprimante imprimante, @RequestParam Long serviceId) {
        if (serviceId != null) {
            Service service = serviceRepository.findById(serviceId).orElse(null);
            imprimante.setService(service);
        }
        equipementRepository.save(imprimante);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String getTest(Model model) {
        model.addAttribute("test", "coucou");
        return "test";
    }

}
